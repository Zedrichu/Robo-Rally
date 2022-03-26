package game.cards;

import game.Position;
import game.players.Player;
import io.cucumber.java.hu.Ha;
import view.CardinalPoints;

import javax.swing.*;
import java.util.*;
//CardFactory design pattern
class CardFactory {

    public Card getCard(CardType type, int intensifier) {
        return switch (type) {
            case MOVE -> new MovingCard(intensifier);
            case ROTATE -> new RotatingCard(intensifier*90);
        };
    }
    //getCard method to be implemented
}

class CardDeck {
    //Client of CardFactory
}