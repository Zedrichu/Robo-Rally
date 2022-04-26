package springboot.view.boardViews;

import springboot.controller.BoardController;
import springboot.model.board.Board;
import springboot.utils.GridBagUtils;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JPanel {
    private Board board;
    private BoardController controller;



    public BoardView(BoardController controller, Board board){
        this.controller = controller;
        this.board = board;
        initGUI(board);
    }

    public void initGUI(Board board){
        int cols = board.getCols();
        int rows = board.getRows();
        setLayout(new GridLayout(rows,cols));
        setMinimumSize(new Dimension(cols*TileView.PIXEL_SIZE,rows*TileView.PIXEL_SIZE));
        setMaximumSize(getMinimumSize());
        setPreferredSize(getMinimumSize());

        for (int j=0; j<rows; j++){
            for (int i=0;i<cols;i++){
                TileView tw = new TileView(board.getBoard()[j][i].getType());
                add(tw, GridBagUtils.constraint(i,j,0));
            }
        }
    }

    public Board getBoard() {
        return board;
    }

}
