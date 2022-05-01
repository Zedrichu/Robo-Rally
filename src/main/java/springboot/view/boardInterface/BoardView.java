package springboot.view.boardInterface;

import springboot.model.board.Board;
import springboot.model.players.Player;
import springboot.model.round.Round;
import springboot.utils.GridBagUtils;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Set;

public class BoardView extends JLayeredPane implements PropertyChangeListener {
    private Board board;
    private Set<Player> players;

    public BoardView( Board board, Set<Player> players){
        this.board = board;
        this.players = players;
        initGUI(this.board, this.players);
    }

    public void initGUI(Board board, Set<Player> sps){
        int cols = board.getCols();
        int rows = board.getRows();

        board.placePlayers(sps);

        setLayout(new GridLayout(rows,cols));
        setMinimumSize(new Dimension(cols*TileView.PIXEL_SIZE,rows*TileView.PIXEL_SIZE));
        setMaximumSize(getMinimumSize());
        setPreferredSize(getMinimumSize());
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createRaisedBevelBorder()));



        for (int j=0; j<rows; j++){
            for (int i=0;i<cols;i++){
                TileView tw = new TileView(board.getBoard()[j][i]);
                add(tw, GridBagUtils.constraint(i,j,0));
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("board")){
            this.board = ((Board) evt.getNewValue());
            revalidate();
        } else if (evt.getPropertyName().equals("round")) {
            this.players = ((Round) evt.getNewValue()).getPlayers();
        }
    }
}
