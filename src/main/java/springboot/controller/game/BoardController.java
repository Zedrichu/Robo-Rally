package springboot.controller.game;

import springboot.model.board.Board;
import springboot.model.players.Player;
import springboot.view.boardInterface.BoardView;

import java.util.Set;

/**
 * Controller class defining the controls of the game board
 * @TODO - needs to be deprecated, not a very useful controller
 */
public class BoardController {

    private BoardView view;
    private Board board;

    /**
     * Class constructor holding the board and creating a view to be controlled.
     * @param board - Board, defining the model of the game board.
     * @param players - Set of players registered in game.
     */
    public BoardController(Board board, Set<Player> players){
        this.board = board;
        this.view = new BoardView(board, players);
    }

    /**
     * Board Getter
     * @return object of class Board denoting the game board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * View Getter
     * @return BoardView - the controlled view.
     */
    public BoardView getView() {
        return view;
    }
}
