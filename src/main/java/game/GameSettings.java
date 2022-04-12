package game;

import game.players.Player;
import view.CardinalPoints;
import view.widgets.Board;

import java.util.HashSet;
import java.util.Set;

import static game.Complexity.EASY;

public class GameSettings {
    private long boardId;
    private Complexity complexity;
    private Set<Player> sps = new HashSet<>();
    private int amountOfPlayers = 2;

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

    //selectSettings, needs modification to GUI later.
    public void selectSettings(){
        for (int i=0;i<amountOfPlayers;i++) {
            Player player = new Player("Player");
            player.setDirection(CardinalPoints.getRandomDirection());
            sps.add(player);
        }
        complexity = EASY;
    }

    //GetBoardSize depending on complexity
    public int[] getBoardSize(){
        return switch (this.complexity){
            case EASY  -> new int[]{7, 7};
            case MEDIUM  -> new int[]{9, 9};
            case HARD -> new int[]{11, 11};
        };
    }
}
