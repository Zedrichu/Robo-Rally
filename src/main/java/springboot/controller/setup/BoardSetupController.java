package springboot.controller.setup;

import springboot.view.setupInterfaces.BoardSetupView;

/**
 * Controller class handling the selection of the board to be played.
 */
public class BoardSetupController {
    private final BoardSetupView view; //Link to corresponding view.

    /**
     * Class constructor creating the view to be handled.
     * @param settingsController - Link to the facade settings controller, used for application flow.
     */
    public BoardSetupController(GameSettingsController settingsController){
        this.view = new BoardSetupView(settingsController);
    }

    /**
     * Method to make the corresponding view of the controller visible.
     */
    public void display(){
        view.setVisible(true);
    }
}
