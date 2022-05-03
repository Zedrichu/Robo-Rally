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
import java.util.ArrayList;
import java.util.List;

/**
 * View class presenting table of cards on GUI.
 *   Implements the Observer design pattern
 *   Listener of the property changes and actions in the TableController
 */
public class CardTableView extends JPanel implements PropertyChangeListener, ActionListener {

    private final TableController tableController;
    private List<CardView> cardButtons;
    private JButton submit;
    private Player player;
    private ArrayList<Integer> selections;
    private int choiceNo;

    public CardTableView(TableController tableController, Player player){
        // Initialize a view for showing available cards on table
        this.tableController = tableController;
        this.player = player;

        initGUI(this.player.getHand());
    }


    private void initGUI(CardHand cardHand) {
        //setMinimumSize(new Dimension(400, 300));
        setLayout(new GridBagLayout());
        setForeground(Color.red);
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.decode("#DC47DA")), BorderFactory.createRaisedBevelBorder()));

        this.cardButtons = new ArrayList<>();
        this.selections = new ArrayList<>(this.player.getHandSize());

        // For each card in the player's hand create a cardView
        int i=0;
        this.choiceNo = 0;
        for (Card card : cardHand.getHand()){
            if (card != null) {
                CardView cardView = new CardView(card);
                cardButtons.add(cardView);
                cardView.addActionListener(this);
                // Add all the cardViews to the common panel
                add(cardView, GridBagUtils.constraint(i%3,i/3,3));
                i++;
            } else {
                add(new JLabel("Missing Card"), GridBagUtils.constraint(i%3, i/3, 3));
            }
        }
        submit = new JButton("Submit card selection");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (choiceNo == 5){
                    for (CardView card : cardButtons) {
                        selections.add(card.choice);
                    }
                    tableController.handleChosenCards(selections);
                    tableController.nextPlayer();
                    tableController.select(true);
                }
            }
        });
        add(submit, GridBagUtils.constraint(1,i/3,3));
    }

    // OBSERVER pattern implementation
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
            this.removeAll();
            initGUI(this.player.getHand());
            revalidate();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardView cardView = (CardView) e.getSource();
        // If haven't selected 5 cards yet allow selections
        if (choiceNo < 5 && !cardView.isSelected()) {
            // If a card has been selected, update its view
            cardView.select(choiceNo+1);
            choiceNo++;
        } else if (choiceNo > 0 && cardView.isSelected()) {
            // If a card is deselected, restore the initial view
            cardView.select(0);
            choiceNo--;
        }
    }

}


