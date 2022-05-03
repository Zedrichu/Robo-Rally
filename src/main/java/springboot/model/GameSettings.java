package springboot.model;

import springboot.model.players.Player;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class denoting the general settings in the game.
 */
public class GameSettings {

    private Complexity complexity;
    private Set<Player> sps = new HashSet<>();
    private int amountOfPlayers;

    /**
     * Getter for the set of players in game
     */
    public Set<Player> getPlayers() {
        return sps;
    }

    /**
     * Setter for the set of players in game
     */
    public void setPlayers(Set<Player> sps) {
        this.sps = sps;
    }

    /**
     * Setter for the number of players
     */
    public void setAmountOfPlayers(int amountOfPlayers) {
        this.amountOfPlayers = amountOfPlayers;
    }

    /**
     * Getter for the number of players
     */
    public int getAmountOfPlayers() {
        return this.amountOfPlayers;
    }

    /**
     * Complexity Getter
     */
    public Complexity getComplexity() {
        return complexity;
    }

    /**
     * Complexity Setter
     */
    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

    /**
     * Method to generate board dimensions based on the level of complexity.
     * @return tuple of integers denoting board dimensions
     */
    public int[] getBoardSize(){
        return switch (this.complexity){
            case EASY  -> new int[]{9, 9};
            case MEDIUM  -> new int[]{11, 11};
            case HARD -> new int[]{13, 13};
        };
    }
}
