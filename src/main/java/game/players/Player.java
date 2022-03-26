package game.players;

import game.Position;
import view.CardinalPoints;

public class Player {
    private static int IDs = 0;
    private int playerID;
    private String playerName;
    private Position position;
    private CardinalPoints direction;

    //private int robotID;

    private int getFreshID(){
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
        this.position = new Position(x,y);
    }

    public void  setPosition(Position pos) {this.position = pos;}

    public Position getPosition() {
        return position;
    }

    public CardinalPoints getDirection() {
        return direction;
    }

    public void setDirection(CardinalPoints direction) {
        this.direction = direction;
    }
}
