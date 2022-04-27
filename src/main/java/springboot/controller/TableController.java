package springboot.controller;

import springboot.model.cards.*;
import springboot.model.players.Player;
import springboot.model.round.Round;
import springboot.view.cardViews.CardTableView;
import springboot.view.gameplay.PromptView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TableController {

    private ApplicationController application;
    private JPanel view;
    private Round round;
    private CardDeck deck;

    TableController(ApplicationController application, Round round, CardDeck deck) {
        this.application = application;
        this.round = round;
//        ArrayList<Card> cards = new ArrayList<Card>();
//        cards.add(CardFactory.getCard(CardType.MOVE,1));
//        cards.add(CardFactory.getCard(CardType.MOVE,2));
//        cards.add(CardFactory.getCard(CardType.ROTATE,-1));
//        cards.add(CardFactory.getCard(CardType.MOVE,3));
//        cards.add(CardFactory.getCard(CardType.MOVE,-1));
//        cards.add(CardFactory.getCard(CardType.ROTATE,1));
//        cards.add(CardFactory.getCard(CardType.ROTATE,2));
//        this.view = new CardTableView(this,new CardHand(cards));
        for (Player player : round.getPlayers()) {
            prompt(player);
        }
        this.deck = deck;

    }

    public void prompt(Player player) {
        PromptView promptView = new PromptView(this, player);
        this.view = promptView;
        promptView.setVisible(true);
    }

    public void showTable(Player player){
        if (round.getRoundNumber() == 1
                && player.getHand() == null) {
            player.drawCardHand(deck);
        }
        CardTableView cardTableView = new CardTableView(this, player.getHand());
        this.view = cardTableView;
        cardTableView.setVisible(true);
    }

    public JPanel getView() {
        return view;
    }
}
