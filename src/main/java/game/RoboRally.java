package game;

import java.awt.FlowLayout;
import java.io.IOException;
import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JFrame;

import game.cards.Card;
import game.cards.CardDeck;
import game.cards.CardHand;
import game.players.Player;
import view.*;
import view.widgets.*;


// Facade class for our game
public class RoboRally {
    private static RoboRally instance;
    public static void main(String[] args) throws IOException{
//        int initialRow = 2;
//        int initialColumn = 2;
//        CardinalPoints currentDirection = CardinalPoints.N;
//
//        Board board = new Board(8, 13);
//        board.setRobot(initialRow, initialColumn, currentDirection);
//
//        ControlPanel control = new ControlPanel(board, initialRow, initialColumn, currentDirection);
//
//        JFrame f = new JFrame("game.RoboRally Demo - v.0.1");
//        f.setLayout(new FlowLayout(FlowLayout.CENTER));
//        f.add(board);
//        f.add(control);
//        f.setSize(900, 700);
//        f.setVisible(true);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RoboRally game = RoboRally.getInstance();
        game.newGame();
        Set<Player> plrs = game.gameSettings.getPlayers();
        System.out.println(game.gameSettings.getComplexity());
        for (Player plr : plrs) {
            System.out.println(plr.getPlayerName()+" "+plr.getPosition()+" "+plr.getDirection().getAbbr());
            plr.drawCardHand(game.deck);
            plr.chooseCards(2);
            plr.getHand().printHand();
        }
        for (Player plr:plrs){
            CardHand hand = plr.getHand();
            for (Card c : hand.getHand()) {
                plr.playCard(c);
            }
            System.out.println(plr.getPlayerName()+" "+plr.getPosition()+" "+plr.getDirection().getAbbr());

        }
    }
    private GameSettings gameSettings;
    private CardDeck deck;
    private Board board;

    public static RoboRally getInstance(){
        if (instance == null) {
            instance = new RoboRally();
        }
        return instance;
    }

    // Constructor for our game, using facade pattern
    public void newGame(){
        gameSettings = new GameSettings();
        gameSettings.selectSettings();
        deck = CardDeck.getInstance();
        int[] size = gameSettings.getBoardSize();
        board = new Board(size[0], size[1],gameSettings.getAmountOfPlayers());
        for (Player plr : gameSettings.getPlayers()){
            plr.setStartPosition(board.getRandomStartPosition());
        }

    }

    public GameSettings getGameSettings() {
        return gameSettings;
    }
}

