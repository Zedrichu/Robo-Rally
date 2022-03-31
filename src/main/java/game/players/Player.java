package game.players;

import game.Position;
import game.cards.Card;
import game.cards.CardHand;
import view.CardinalPoints;

import java.util.ArrayList;

public class Player {
    private static int IDs = 0;
    private int playerID;
    private String playerName;
    private Position position;
    private CardinalPoints direction;
    private CardHand hand;
    private int lives;

    //private int robotID;

    private int getFreshID() {
        IDs++;
        return IDs;
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

    public void updateLives(int effect){
        this.lives = lives + effect;
    }
    public double getLives(){
        return lives;
    }

}

