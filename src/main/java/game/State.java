package game;

import springboot.model.round.Round;
import view.widgets.Board;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class State implements PropertyChangeListener {
    private Board board;
    private Round round;

    public State(Board board, Round round){
        this.board = board;
        this.round = round;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("board")) {
            this.setBoard((Board) evt.getNewValue());
        } else {
            this.setRound((Round) evt.getNewValue());
        }
    }
}
