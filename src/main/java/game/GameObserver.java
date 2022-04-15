package game;

import game.round.Round;
import view.widgets.Board;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

//Observer Pattern with PropertyChangeListener for the game Robot Rally
public class GameObserver {
    private final PropertyChangeSupport support;
    private Board board;
    private Round round;

    public GameObserver(){
        support = new PropertyChangeSupport(this);
    }

    public void addPCL(PropertyChangeListener pcl) {
            support.addPropertyChangeListener(pcl);
    }
    public void removePCL(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setBoard(Board value){
        support.firePropertyChange("board", this.board, value);
        System.out.println("Board updated!");
        this.board = value;
    }

    public void setRound(Round value) {
        support.firePropertyChange("round", this.round, value);
        System.out.println("Round updated!");
        this.round = value;
    }

}
