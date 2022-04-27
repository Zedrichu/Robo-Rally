package springboot.model.round;

import springboot.model.players.Player;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Set;

// Singleton design applied on Round
public class Round implements PropertyChangeListener {
    private PropertyChangeSupport support;
    private int roundNumber;
    private Set<Player> players;
    private static Round instance;

//    public void setBoard(Board board) {
//        this.board = board;
//    }

    private Round(PropertyChangeSupport support, Set<Player> players){
        this.support = support;
        this.players = players;
        this.roundNumber = 1;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
        support.firePropertyChange("players",Set.of(), players);
    }

    //Checks that all players have no cards in hand
    public boolean checkNoCardsInHand() {
        for (Player player : players) {
            if (player.getHand() == null) {
                return false;
            }
        }
        return true;
    }

    //Checks that all Players have played
    public boolean haveAllPlayed() {
        boolean res=true;
        for (Player plr : players) {
            if (plr.getHandSize() != 5-roundNumber) {
                res = false;
                break;
            }
        }
        return res;
    }

    //Singleton design applied on Round
    public static Round getInstance(PropertyChangeSupport support, Set<Player> players){
        if (instance == null){
            instance = new Round(support, players);
        }
        return instance;
    }

    //Setters
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
        support.firePropertyChange("round",0, roundNumber);
    }

    //Increment round number
    public void incrementRoundNumber(){
        this.roundNumber = roundNumber+1;
        support.firePropertyChange("round",roundNumber-1, roundNumber);
    }

    //Reset Round
    public void resetRound(){
        this.roundNumber=1;
        support.firePropertyChange("round",5, roundNumber);
    }

    //Getters
    public int getRoundNumber() {
        return roundNumber;
    }

}
