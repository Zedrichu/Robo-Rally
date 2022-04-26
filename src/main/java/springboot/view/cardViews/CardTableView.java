package springboot.view.cardViews;

import springboot.controller.CardTableController;
import springboot.model.cards.Card;
import springboot.model.cards.CardDeck;
import springboot.model.cards.CardHand;
import springboot.model.players.Player;
import springboot.utils.GridBagUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class CardTableView extends JPanel{

    private CardTableController cardTableController;

    public CardTableView(CardTableController cardTableController, CardHand cardHand){
        this.cardTableController = cardTableController;
        initGUI(cardHand);
    }


    private void initGUI(CardHand cardHand) {
        setMinimumSize(new Dimension(400, 300));
        setLayout(new GridBagLayout());
        setForeground(Color.red);

        int i=0;
        for (Card c : cardHand.getHand()){
            JButton card = new CardView(c);
            add(card, GridBagUtils.constraint(i,0,3));
            i++;
        }


    }

}


