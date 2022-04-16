package springboot.controller;

public class ApplicationController {

    private GameSettingsController settingsController;

    public void settings() {
        settingsController = new GameSettingsController(this);
        settingsController.display();
    }

    public static void main(String[] args) {
        ApplicationController app = new ApplicationController();
        app.settings();
    }

}
