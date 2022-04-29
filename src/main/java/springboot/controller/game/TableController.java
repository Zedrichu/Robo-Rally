package springboot.controller.game;

import springboot.model.cards.*;
import springboot.model.players.Player;
import springboot.model.round.Round;
import springboot.view.cardInterface.CardTableView;
import springboot.view.gameplay.PromptView;

import javax.swing.*;
import java.beans.PropertyChangeSupport;

public class TableController {

    private final PropertyChangeSupport support;
    private boolean selected;
    private JPanel view;
    private final Round round;
    private final CardDeck deck;
    private Player player;

    TableController(PropertyChangeSupport support, Round round, CardDeck deck) {
        this.round = round;
        this.support = support;
        this.deck = deck;
        this.player = round.getPlayers().iterator().next();
        this.selected = true;

        if (this.player.getHand() == null) {
            this.player.drawCardHand(this.deck);
        }

        PromptView promptView = new PromptView(this, player);
        CardTableView cardTableView = new CardTableView(this, this.player);

        this.view = promptView;
        this.view.setVisible(true);

        support.addPropertyChangeListener(cardTableView);
        support.addPropertyChangeListener(promptView);
    }

    public void setView(JPanel view) {
        this.view.setVisible(false);
        support.firePropertyChange("table", this.view, view);
        this.view = view;
        this.view.setVisible(true);
    }

    public void nextPlayer() {
        Player tempo = this.player;
        this.player = this.round.getPlayers().iterator().next();
        support.firePropertyChange("player", tempo, this.player);
        System.out.println("Selection for player: "+ this.player.getPlayerName());
    }

    public void select(boolean value){
        support.firePropertyChange("selection", this.selected, value);
        this.selected = value;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public JPanel getView() {
        return view;
    }
}
