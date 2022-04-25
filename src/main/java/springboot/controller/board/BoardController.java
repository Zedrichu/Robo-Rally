package springboot.controller.board;

import springboot.controller.gameSetup.GameSettingsFacadeController;
import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.view.boardViews.BoardView;

//Singleton pattern being used maybe
public class BoardController {
    private BoardView view;
    private GameSettingsFacadeController gameSettingsController;
    private Board board;

    public BoardController(GameSettingsFacadeController gameSettingsController){
        this.gameSettingsController = gameSettingsController;
        GameSettings settings = gameSettingsController.getGameSettings();
        int[] sizes = settings.getBoardSize();
        board = new Board(sizes[0],sizes[1]);
        board.loadBoard(settings.getAmountOfPlayers());
        this.view = new BoardView(this, board);
    }

    public Board getBoard() {
        return board;
    }

    public BoardView getView() {
        return view;
    }
}
