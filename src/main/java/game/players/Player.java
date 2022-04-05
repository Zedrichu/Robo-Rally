package game.players;


import java.util.*;
import game.Position;
import game.cards.Card;
import game.cards.CardDeck;
import game.cards.CardHand;
import view.CardinalPoints;

//import java.util.ArrayList;
import java.util.LinkedList;


public class Player {
    private static int IDs = 0;
    private int playerID;
    private String playerName;
    private Position position;
    private CardinalPoints direction;
    private CardHand hand;
    private int lives = 10;



    //private int robotID;

    private int getFreshID() {
        IDs++;
        return IDs;
    }

    public void drawCardHand(CardDeck deck) {
        this.hand = new CardHand(deck.drawCards());
        //this.hand.printHand();
    }


    public Player(String name) {
        this.playerID = getFreshID();
        this.playerName = name;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setLives(int lives){this.lives = lives;}

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPosition(int x, int y) {
        this.position = new Position(x, y);
    }

    public void setPosition(Position pos) {
        this.position = pos;
    }

    public Position getPosition() {
        return position;
    }

    public CardinalPoints getDirection() {
        return direction;
    }

    public void setDirection(CardinalPoints direction) {
        this.direction = direction;
    }

//    public void looseCard(){
//        this.hand.removeCard();
//    }

    public boolean checkInbounds(int rows, int columns) {
        return (this.position.x < 0 | position.y > columns - 1
                || this.position.y < 0 | position.y > rows - 1);
    }


    // Assign cards to each player
    public void setHand(CardHand hand) {
        this.hand = hand;
    }

    public CardHand getHand() {
        return hand;
    }

    public void playCard (Card card) {
        Object[] res = card.applyAction(this.position, this.direction);
        this.setPosition((Position) res[0]);
        this.setDirection((CardinalPoints) res[1]);
    }

    //Returns size of hand
    public int getHandSize() {
        return hand.size();
    }

// CARD SELECTION METHOD
    //++++++++++++++++++++++++++++++++YET TO BE IMPLEMENTED+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    void cardSelect(){
        int nr_sel = 5; int nr_disc = 4;
        ArrayList<Card> selCards = new ArrayList<Card>();
        ArrayList<Card> disCards = new ArrayList<Card>();

        while(selCards.size() < nr_sel){
            //FOR Every click in the 3x3 grid in the GUI
                //A new card is added to the selCards arraylist

        }
        //After the cards are selected the remaining 4 cards are assigned to disCards local var.

        //CardDeck method for pushing dicarded cards back in the set
                // - uses hand, and selected cards for disCards definition
        //                             $    pushDiscardsMeth();     $


        this.setHand(new CardHand(selCards));
    }

    public void chooseCards(int x) {
        ArrayList<Card> current = hand.getHand();
        ArrayList<Card> chosen = new ArrayList<>(x);
        // To be implemented
        boolean selected = true;
        for (int i=0;i<x;i++) {
            if (selected) {
                chosen.add(current.get(i));
            }
        }
        // send current back to deck
        this.setHand(new CardHand(chosen));
    }

    public void updateLives(int effect){
        this.lives = lives + effect;
    }
    public double getLives(){
        return lives;
    }

}

