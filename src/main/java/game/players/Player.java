package game.players;

public class Player {
    private int playerID;
    private String playerName;
    //private int robotID;


    public Player(int id) {
        this.playerID = id;
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
}
