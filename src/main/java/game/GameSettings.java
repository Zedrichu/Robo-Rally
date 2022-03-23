package game;

import game.players.Player;
import view.widgets.Board;

import java.util.Set;

public class GameSettings {
    private long boardId;
    private Complexity complexity;
    private Set<Player> sps;


    public GameSettings(long boardId, Complexity comp, Set<Player> sps) {
        this.boardId = boardId;
        this.complexity = comp;
        this.sps = sps;
    }

    public long getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public Set<Player> getSps() {
        return sps;
    }

    public void setSps(Set<Player> sps) {
        this.sps = sps;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity comp) {
        this.complexity = comp;
    }
}
