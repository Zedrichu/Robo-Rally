package game.players;


import springboot.model.Position;
import springboot.model.cards.*;
import springboot.model.Direction;
import springboot.model.checkPoints.CheckPoint;
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
    Set<CheckPoint> collectedCP;




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

    public void setLives(int lives) {
        this.lives = lives;
    }

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

    public CardHand getHand() {
        return hand;
    }

    // Assign cards to each player
    public void setHand(ArrayList<Card> hand) {
        this.hand.setHand(hand);
    }


    public void playCard(Card card, Board board) {
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

    public void skipCard(int round) {
        ArrayList<Card> current = this.hand.getHand();
        current.set(round, null);
        this.setHand(current);
    }

    public void chooseCards(int x) {
        ArrayList<Card> current = hand.getHand();
        ArrayList<Card> chosen = new ArrayList<>(x);
        // To be implemented
        boolean selected = true;
        for (int i = 0; i < x; i++) {
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

    public void updateLives(int effect) {
        this.lives = lives + effect;
    }

    public double getLives() {
        return lives;
    }

    public boolean hasCP(CheckPoint cp) {
        return (collectedCP.contains(cp)) ;
    }

    public void addCheckPoint(CheckPoint cp) {
        if (collectedCP == null) {
            collectedCP = new HashSet<>();
        }
        if (!hasCP(cp)) collectedCP.add(cp);
    }

    public boolean hasAllCP(Set<CheckPoint> set){
       return collectedCP.equals(set);
    }

    public Set<CheckPoint> getCollectedCP() {
        return collectedCP;
    }

    public void pushPlayer(Player player2){
        Card card = CardFactory.getCard(CardType.MOVE, 1);

        Object[] newPosDir = card.applyAction(player2.getPosition(), getDirection());

        player2.setPosition((Position) newPosDir[0]);
    }

}


