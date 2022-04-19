package game;

import game.players.Player;
import springboot.model.Direction;

import java.util.HashSet;
import java.util.Set;

public class GameSettings {
    private long boardId;
    private Complexity complexity;
    private Set<Player> sps = new HashSet<>();
    private int amountOfPlayers;

    public GameSettings() {
    }

    public Set<Player> getPlayers() {
        return sps;
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

    //selectSettings, needs modification to GUI later.
    public void setSettings(Complexity complexity, int number){
        for (int i=0;i<amountOfPlayers;i++) {
            Player player = new Player("Player");
            player.setDirection(Direction.getRandomDirection());
            sps.add(player);
        }
        this.complexity = complexity;
    }
// Move to Controller
    //GetBoardSize depending on complexity
    public int[] getBoardSize(){
        return switch (this.complexity){
            case EASY  -> new int[]{7, 7};
            case MEDIUM  -> new int[]{9, 9};
            case HARD -> new int[]{11, 11};
        };
    }


}
