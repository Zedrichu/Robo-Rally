package springboot.controller.game;

import springboot.model.board.Board;
import springboot.model.players.Player;
import springboot.view.boardInterface.BoardView;

import java.util.Set;

// Singleton design pattern
public class BoardController {

    private BoardView view;
    private Board board;

    public BoardController(Board board, Set<Player> players){
        this.board = board;
        this.view = new BoardView(board, players);
    }

    public Board getBoard() {
        return board;
    }

    public BoardView getView() {
        return view;
    }

}
