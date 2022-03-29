package game.cards;

import game.Position;
import game.players.Player;
import io.cucumber.java.hu.Ha;
import view.CardinalPoints;

import javax.swing.*;
import java.util.*;

public class CardDeck {
    //Client of CardFactory - Singleton Design Pattern
    private static CardDeck instance;
    private Set<Card> deck = new HashSet<>();
    private int deckSize = 84;

    private CardDeck() {

    }

    public CardDeck getInstance() {
        if (instance == null) {
            instance = new CardDeck();
        }
        return  instance;
    }

    public void setDeckSize(int deckSize) {
        this.deckSize = deckSize;
    }

    public int getDeckSize() {
        return deckSize;
    }
}