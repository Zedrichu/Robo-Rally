package game.players;


import springboot.model.Position;
import springboot.model.cards.Card;
import springboot.model.cards.CardDeck;
import springboot.model.cards.CardHand;
import springboot.model.Direction;
import springboot.model.checkPoints.CheckPoint;
import springboot.model.checkPoints.CheckPointSet;
import springboot.model.checkPoints.collectedCheckpoints;
import view.widgets.Board;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private static int IDs = 0;
    final private int playerID;
    final private String playerName;
    private Position position;
    private Direction direction;
    public CardHand hand;
    private int lives = 10;
    collectedCheckpoints cpSet;


    private int getFreshID() {
        IDs++;
        return IDs;
    }

    public void drawCardHand(CardDeck deck) {
        this.hand = new CardHand(deck.drawCards(9));
    }

    public Player(String name) {
        this.playerID = getFreshID();
        this.playerName = name;
    }

    public void setLives(int lives){this.lives = lives;}

    public String getPlayerName() {
        return playerName;
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public CardHand getHand() {return hand;}
    // Assign cards to each player
    public void setHand(ArrayList<Card> hand) {
        this.hand.setHand(hand);
    }


    public void playCard (Card card, Board board) {
        Object[] res = card.applyAction(this.position, this.direction);
        if (board.checkPositionInBounds((Position) res[0])) {
            this.setPosition((Position) res[0]);
            this.setDirection((Direction) res[1]);
        }
    }

    //Returns size of hand
    public int getHandSize() {
        return hand.size();
    }

    public void skipCard(int round){
        ArrayList<Card> current = this.hand.getHand();
        current.set(round, null);
        this.setHand(current);
    }

// CARD SELECTION METHOD
    //+++++++++YET TO BE IMPLEMENTED+++++++++
//    void cardSelect(){
//        int nr_sel = 5; int nr_disc = 4;
//        ArrayList<Card> selCards = new ArrayList<Card>();
//        ArrayList<Card> disCards = new ArrayList<Card>();
//
//        while(selCards.size() < nr_sel){
//            //FOR Every click in the 3x3 grid in the GUI
//                //A new card is added to the selCards arraylist
//
//        }
//        //After the cards are selected the remaining 4 cards are assigned to disCards local var.
//
//        //CardDeck method for pushing discarded cards back in the set
//                // - uses hand, and selected cards for disCards definition
//        //                             $    pushDiscardsMeth();     $
//
//
//        this.setHand(selCards);
//    }

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
        // send current cards back to deck
        this.setHand(chosen);
    }

    public void setStartPosition(Position pos) {
        this.position = new Position(pos.x, pos.y);
    }

    public void updateLives(int effect){
        this.lives = lives + effect;
    }
    public double getLives(){
        return lives;
    }



    public void addCheckPoint(CheckPoint cp){
        cpSet.addCheckPoint(cp);
    }

    public collectedCheckpoints getCpSet(){
        Set<CheckPoint> set = cpSet.getSet();
        return (collectedCheckpoints) set;

    }



}

