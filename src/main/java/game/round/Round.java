package game.round;

import game.players.Player;
import view.widgets.Board;

import java.util.Set;

// Singleton design applied on Round
public class Round {
    private int roundNumber=1;
    private Board board;
    private Set<Player> players;
    private static Round instance;

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    //Singleton design applied on Round
    public static Round getInstance(){
        if (instance == null){
            instance = new Round();
        }
        return instance;
    }

    public Round() {}

    //Setters
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    //Increment round number
    public void incrementRoundNumber(){
        this.roundNumber = roundNumber+1;
    }

    // Not done yet
    public boolean isRoundOver(){
        boolean res = true;
        for (Player plr : players) {
            res = res && (plr.getHandSize() == 5-this.roundNumber);
        }
        return res;
    }


    //Getters
    public int getRoundNumber() {
        return roundNumber;
    }

}
