package springboot.controller;

import springboot.model.GameSettings;
import springboot.model.cards.CardDeck;
import springboot.view.CardView;

public class CardController {

    private ApplicationController application;
    private GameSettings gameSettings;
    private CardDeck deck;
    private CardView view;

    CardController(ApplicationController application) {
        this.application = application;
        //Needs refactoring
        //this.gameSettings = GameSettingsController.getGameSettings();
        this.deck = new CardDeck();
        //this.view = new CardView(this);
    }

}
