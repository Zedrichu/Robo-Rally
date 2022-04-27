package springboot.view.cardViews;

import springboot.controller.TableController;
import springboot.model.cards.Card;
import springboot.model.cards.CardHand;
import springboot.utils.GridBagUtils;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CardTableView extends JPanel implements PropertyChangeListener {

    private TableController tableController;

    public CardTableView(TableController tableController, CardHand cardHand){
        this.tableController = tableController;
        initGUI(cardHand);
    }


    private void initGUI(CardHand cardHand) {
        setMinimumSize(new Dimension(400, 300));
        setLayout(new GridBagLayout());
        setForeground(Color.red);
        setBackground( Color.DARK_GRAY );

        int i=0;
        for (Card c : cardHand.getHand()){
            JButton card = new CardView(c);
            add(card, GridBagUtils.constraint(i%3,i/3,3));
            i++;
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}


