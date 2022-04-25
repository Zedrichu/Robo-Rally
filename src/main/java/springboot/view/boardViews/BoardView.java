package springboot.view.boardViews;

import springboot.controller.board.BoardController;
import springboot.model.board.Board;

import javax.swing.*;

public class BoardView extends JPanel {
    private Board board;
    private BoardController controller;

    public BoardView(BoardController controller, Board board){
        this.controller = controller;

    }

    public void initGUI(Board board){

    }

    public Board getBoard() {
        return board;
    }

}
