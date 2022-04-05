package game;

import game.players.Player;
import view.CardinalPoints;
import view.widgets.Board;

import java.util.HashSet;
import java.util.Set;

public class GameSettings {
    private long boardId;
    private Complexity complexity;
    private Set<Player> sps = new HashSet<>();
    private int amountOfPlayers;


    public int getAmountOfPlayers() {
        return this.amountOfPlayers;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    //selectSettings, needs modification to GUI later.
    public void selectSettings(){
        this.amountOfPlayers = 2;
        for (int i=0;i<amountOfPlayers;i++) {
            Player player = new Player("Player");
            player.setPosition(0,0);
            player.setDirection(CardinalPoints.E);
            sps.add(player);
        }
        complexity = Complexity.EASY;

    }
}
