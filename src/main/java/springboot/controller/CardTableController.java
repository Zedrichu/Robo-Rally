package springboot.controller;

import springboot.model.GameSettings;
import springboot.model.cards.*;
import springboot.view.boardViews.BoardView;
import springboot.view.cardViews.CardTableView;

import java.util.ArrayList;

public class CardTableController {

    private ApplicationController application;
    private CardTableView view;
    private CardDeck deck;

    CardTableController(ApplicationController application, CardDeck deck) {
        this.application = application;
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(CardFactory.getCard(CardType.MOVE,1));
        cards.add(CardFactory.getCard(CardType.MOVE,2));
        cards.add(CardFactory.getCard(CardType.ROTATE,-1));
        cards.add(CardFactory.getCard(CardType.MOVE,3));
        cards.add(CardFactory.getCard(CardType.MOVE,-1));
        cards.add(CardFactory.getCard(CardType.ROTATE,1));
        cards.add(CardFactory.getCard(CardType.ROTATE,2));
        this.view = new CardTableView(this,new CardHand(cards));
        this.deck = deck;
        display();
    }

    public void display(){view.setVisible(true);}

    public CardTableView getView() {
        return view;
    }
}
