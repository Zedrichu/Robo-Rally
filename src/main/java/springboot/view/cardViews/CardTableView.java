package springboot.view.cardViews;

import springboot.controller.tableController;
import springboot.model.cards.Card;
import springboot.model.cards.CardHand;
import springboot.utils.GridBagUtils;

import javax.swing.*;
import java.awt.*;

public class CardTableView extends JPanel{

    private tableController tableController;

    public CardTableView(tableController tableController, CardHand cardHand){
        this.tableController = tableController;
        initGUI(cardHand);
    }


    private void initGUI(CardHand cardHand) {
        setMinimumSize(new Dimension(400, 300));
        setLayout(new GridBagLayout());
        setForeground(Color.red);

        int i=0;
        for (Card c : cardHand.getHand()){
            JButton card = new CardView(c);
            add(card, GridBagUtils.constraint(i%3,i/3,3));
            i++;
        }


    }

}


