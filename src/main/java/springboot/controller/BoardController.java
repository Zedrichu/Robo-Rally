package springboot.controller;

import springboot.controller.gameSetup.GameSettingsFacadeController;
import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.model.players.Player;
import springboot.view.boardViews.BoardView;

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
