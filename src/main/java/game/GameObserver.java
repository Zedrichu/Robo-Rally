package game;

import game.players.Player;
import game.round.Round;
import view.widgets.Board;

import java.beans.PropertyChangeSupport;
import java.util.Set;

//Observer Pattern with PropertyChangeListener for the game Robot Rally
public class GameObserver {
    private PropertyChangeSupport support;

    public GameObserver(){
        support = new PropertyChangeSupport(this);
    }

}
