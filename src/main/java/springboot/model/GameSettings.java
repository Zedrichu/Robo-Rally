package springboot.model;

import springboot.model.players.Player;

import java.beans.PropertyChangeSupport;
import java.util.HashSet;
import java.util.Set;

public class GameSettings {
    private long boardId;
    private Complexity complexity;
    private Set<Player> sps = new HashSet<>();
    private int amountOfPlayers;


    public Set<Player> getPlayers() {
        return sps;
    }

    public void setPlayers(Set<Player> sps) {
        this.sps = sps;
    }

    public void setAmountOfPlayers(int amountOfPlayers) {
        this.amountOfPlayers = amountOfPlayers;
    }

    public int getAmountOfPlayers() {
        return this.amountOfPlayers;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

// Move to Controller
    //GetBoardSize depending on complexity
    public int[] getBoardSize(){
        return switch (this.complexity){
            case EASY  -> new int[]{9, 9};
            case MEDIUM  -> new int[]{11, 11};
            case HARD -> new int[]{13, 13};
        };
    }
}
