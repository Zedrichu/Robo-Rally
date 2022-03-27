package game.round;

import game.players.Player;
import view.widgets.Board;

// Singleton design applied on Round
public class Round {
    private int roundNumber=1;
    private Board board;
    private Player[] players;
    private static Round instance;


    //Singleton design applied on Round
    public static Round getInstance(){
        if (instance == null){
            //instance = new Round();
        }
        return instance;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    //Constructor
    public Round(Player[] players, Board board) {
        this.board = board;
        this.players = players;
    }



    public void incrementRoundNumber(){
        this.roundNumber = roundNumber+1;
    }
    //Getters
    public int getRoundNumber() {
        return roundNumber;
    }

}
