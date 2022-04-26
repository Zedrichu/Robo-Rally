package springboot.controller;

import springboot.controller.gameSetup.GameSettingsFacadeController;
import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.view.boardViews.BoardView;

import java.util.Set;

// Singleton design pattern
public class BoardController {
    private BoardView view;
    private Board board;
    private static BoardController instance;

    public static BoardController getInstance(GameSettingsFacadeController gameSettingsFacadeController) {
        if (instance == null)
            return new BoardController(gameSettingsFacadeController);
        return instance;
    }

    public static BoardController getInstance(GameController gameController) {
        if (instance == null)
            return new BoardController(gameController);
        return instance;
    }

    private BoardController(GameSettingsFacadeController gameSettingsController) {
        GameSettings settings = gameSettingsController.getGameSettings();
        int[] sizes = settings.getBoardSize();
        board = new Board(sizes[0],sizes[1]);
        board.loadBoard(settings.getAmountOfPlayers());
        this.view = new BoardView(this, board, Set.of());
    }

    private BoardController(GameController gameController){
        this.board = gameController.getBoard();
        this.view = new BoardView(this, gameController.getBoard(), gameController.getRound().getPlayers());
    }

    public Board getBoard() {
        return board;
    }

    public BoardView getView() {
        return view;
    }
}
