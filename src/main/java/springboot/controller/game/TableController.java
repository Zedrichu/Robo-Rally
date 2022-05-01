package springboot.controller.game;

import springboot.model.cards.*;
import springboot.model.players.Player;
import springboot.model.round.Round;
import springboot.view.cardInterface.CardTableView;
import springboot.view.gameplay.PromptView;

import javax.swing.*;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class TableController {

    private PromptView promptView;
    private CardTableView cardTableView;
    private GameController gameController;
    private final PropertyChangeSupport support;
    private boolean selected;
    private JPanel view;
    private final Round round;
    private final CardDeck deck;
    private Player player;
    private Iterator iterator;



    TableController(PropertyChangeSupport support, GameController gameController, Round round, CardDeck deck) {
        this.round = round;
        this.gameController = gameController;
        this.support = support;
        this.deck = deck;
        this.iterator = round.getPlayers().iterator();
        this.player = (Player) iterator.next();
        this.selected = true;

        if (this.view != null) {
            this.view.removeAll();
            this.view.revalidate();
        }


        round.drawCardsAll(deck);

        promptView = new PromptView(this, player);
        cardTableView = new CardTableView(this, this.player);

        System.out.println("Selection for player: " + this.player.getPlayerName());
        this.view = promptView;
        this.view.setVisible(true);

        this.support.addPropertyChangeListener(cardTableView);
        this.support.addPropertyChangeListener(promptView);
    }

    public Round getRound() {
        return round;
    }

    public void setView(JPanel view) {
        this.view.setVisible(false);
        this.support.firePropertyChange("table", this.view, view);
        this.view = view;
        this.view.setVisible(true);
    }

    public void nextRound(){
        this.iterator = this.round.getPlayers().iterator();
        this.round.drawCardsAll(this.deck);
    }

    public void nextPlayer() {
        if (this.iterator.hasNext()) {
            this.player = (Player) this.iterator.next();
            support.firePropertyChange("player", null, this.player); //Fires to Prompt or CardTableView
            System.out.println("Selection for player: " + this.player.getPlayerName());
        } else {
            this.view.removeAll();
            gameController.nextRound();
        }
    }

    public void handleChosenCards(ArrayList<Integer> selected) {
        this.player.chooseCards(5, selected, this.deck);
    }

    public void select(boolean value){
        support.firePropertyChange("selection", this.selected, value); //Fires to Prompt or CardTableView
        this.selected = value;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public JPanel getView() {
        return view;
    }
}
