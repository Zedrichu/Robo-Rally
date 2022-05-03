package springboot.controller.game;

import springboot.model.cards.*;
import springboot.model.players.Player;
import springboot.model.Round;
import springboot.view.cardInterface.CardTableView;
import springboot.view.gameplay.PromptView;

import javax.swing.*;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Controller class handling the switching between game flow prompts and card selection panels.
 */
public class TableController {

    private final GameController gameController;
    private final PropertyChangeSupport support;
    private boolean selected;
    private JPanel view;
    private final Round round;
    private final CardDeck deck;
    private Player player;
    private Iterator iterator;

    /**
     * Class constructor establishing starting board configurations and listeners.
     * @param support - channel supporting the observer pattern on property changes
     * @param gameController - link to the facade controller of the gameplay
     * @param round - object of class Round, modelling the rounds to be played
     * @param deck - object CardDeck, deck of cards to be used in the game
     */
    TableController(PropertyChangeSupport support, GameController gameController, Round round, CardDeck deck) {
        this.round = round;
        this.gameController = gameController;
        this.support = support;
        this.deck = deck;
        this.iterator = round.getPlayers().iterator();
        // Select first player
        this.player = (Player) iterator.next();
        this.selected = true;

        if (this.view != null) {
            this.view.removeAll();
            this.view.revalidate();
        }

        // Draw cards to all players registered
        round.drawCardsAll(deck);

        // Create a new game flow prompt
        PromptView promptView = new PromptView(this, player);
        // Create a new card selection table
        CardTableView cardTableView = new CardTableView(this, this.player);

        System.out.println("Selection for player: " + this.player.getPlayerName());
        // Set the first view
        this.view = promptView;
        this.view.setVisible(true);

        // Bind the view listeners
        this.support.addPropertyChangeListener(cardTableView);
        this.support.addPropertyChangeListener(promptView);
    }
    /**
     * Round Getter
     */
    public Round getRound() {
        return round;
    }

    /**
     * View setter, notifying listeners about the view change.
     * @param view
     */
    public void setView(JPanel view) {
        //Hide the old view
        this.view.setVisible(false);
        this.support.firePropertyChange("table", this.view, view);
        this.view = view;
        //Show the new view
        this.view.setVisible(true);
    }

    /**
     * Method to prepare the controller for a new round.
     */
    public void nextRound(){
        // Update the iterator of the player set
        this.iterator = this.round.getPlayers().iterator();
        // Draw 9 cards to all players
        this.round.drawCardsAll(this.deck);
    }

    /**
     * Method to prepare the controller to handle the selections of the next player.
     */
    public void nextPlayer() {
        if (this.iterator.hasNext()) {
            // Update the player
            this.player = (Player) this.iterator.next();
            // Notify the listeners about change in player
            support.firePropertyChange("player", null, this.player); //Fires to Prompt or CardTableView
            System.out.println("Selection for player: " + this.player.getPlayerName());
        } else {
            this.view.removeAll();
            // Initiate a new round if all players have selected cards
            gameController.nextRound();
        }
    }

    /**
     * Method to handle the card selections from the view.
     * @param selected - array of choice, keeping also the order of selections
     */
    public void handleChosenCards(ArrayList<Integer> selected) {
        this.player.chooseCards(5, selected, this.deck);
    }

    /**
     * Method to switch from the prompt dialog to the selections table, and backwards.
     * @param value - boolean value, true to trigger the prompt, false - card table
     */
    public void select(boolean value){
        support.firePropertyChange("selection", this.selected, value); //Fires to Prompt or CardTableView
        this.selected = value;
    }

    /**
     * Method to check the view currently showing.
     * @return boolean value to confirm the current view shown
     */
    public boolean isSelected() {
        return this.selected;
    }

    /**
     * View Getter
     * @return JPanel object storing the current view set
     */
    public JPanel getView() {
        return view;
    }
}
