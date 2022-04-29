package springboot.view.cardInterface;

import springboot.controller.game.TableController;
import springboot.model.cards.Card;
import springboot.model.cards.CardHand;
import springboot.model.players.Player;
import springboot.utils.GridBagUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CardTableView extends JPanel implements PropertyChangeListener {

    private final TableController tableController;
    private CardView[] cardButtons;
    private Player player;
    private int choiceNo;

    public CardTableView(TableController tableController, Player player){
        // Initialize a view for showing available cards on table
        this.tableController = tableController;
        this.player = player;
        this.choiceNo = 1;
        initGUI(this.player.getHand());
    }


    private void initGUI(CardHand cardHand) {
        setMinimumSize(new Dimension(400, 300));
        setLayout(new GridBagLayout());
        setForeground(Color.red);
        setBackground(Color.DARK_GRAY);

        // For each card in the player's hand create a cardView
        int i=0;
        this.choiceNo = 1;
        for (Card card : cardHand.getHand()){
            CardView cardView = new CardView(card);
            cardView.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // If haven't selected 5 cards yet allow selections
                    if (choiceNo <= 5 && !cardView.isSelected()) {
                        // If a card has been selected, update its view
                        cardView.select(true, choiceNo++);
                    } else if (choiceNo > 0) {
                        // If a card is deselected, restore the initial view
                        cardView.select(false, choiceNo--);
                    }
                }
            });
            // Add all the cardViews to the common panel
            add(cardView, GridBagUtils.constraint(i%3,i/3,3));
            i++;
        }
    }

    // OBSERVER pattern implemented here
    // Method to update/reload view if a certain property change is observed
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // If cards need to be selected set the view with cards
        if (evt.getPropertyName().equals("selection")
                && !(boolean) evt.getNewValue()) {
            tableController.setView(this);
            revalidate();
        // If the current player's turn changes update the pointer to that player
        } else if (evt.getPropertyName().equals("player")) {
            this.player = (Player) evt.getNewValue();
            revalidate();
        }
    }
}


