package game;

import java.awt.FlowLayout;
import java.io.IOException;
import java.util.Set;
import javax.swing.JFrame;

import springboot.model.Complexity;
import springboot.model.Direction;
import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.model.cards.Card;
import springboot.model.cards.CardDeck;
import springboot.model.cards.CardHand;
import springboot.model.players.Player;
import springboot.model.round.Round;


// Facade class for our game
public class RoboRally {
    private static RoboRally instance;
//    public static void main(String[] args) throws IOException{
//        int initialRow = 2;
//        int initialColumn = 2;
//        Direction currentDirection = Direction.N;
//
//        Board board = new Board(8, 13,2);
//        board.setRobot(initialRow, initialColumn, currentDirection);
//
//        JFrame f = new JFrame("RoboRally Demo - v.0.1");
//        f.setLayout(new FlowLayout(FlowLayout.CENTER));
//        f.add(board);
//        f.setSize(900, 700);
//        f.setVisible(true);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        RoboRally game = RoboRally.getInstance();
//        game.newGame(2);
//        Set<Player> plrs = game.gameSettings.getPlayers();
//        System.out.println(game.gameSettings.getComplexity());
//        for (Player plr : plrs) {
//            System.out.println(plr.getPlayerName()+" "+plr.getPosition()+" "+plr.getDirection().getAbbr());
//            plr.drawCardHand(game.deck);
//            plr.chooseCards(2);
//            for (Card card : plr.getHand().getHand()){
//                System.out.println(card.getName());
//            }
//        }
//        for (Player plr:plrs){
//            CardHand hand = plr.getHand();
//            for (Card c : hand.getHand()) {
//                plr.playCard(c,new Board(6,6,plrs.size()));
//            }
//            System.out.println(plr.getPlayerName()+" "+plr.getPosition()+" "+plr.getDirection().getAbbr());
//
//        }
//    }
//    private GameSettings gameSettings;
//    private CardDeck deck;
//    private Board board;
//
//    public static RoboRally getInstance(){
//        if (instance == null) {
//            instance = new RoboRally();
//        }
//        return instance;
//    }
//
//    // Constructor for our game, using facade pattern
//    public void newGame(int noPlayers){
//        gameSettings = new GameSettings();
//        gameSettings.setComplexity(Complexity.EASY);
//        gameSettings.setAmountOfPlayers(noPlayers);
//
//        deck = new CardDeck();
//        int[] size = gameSettings.getBoardSize();
//        board = new Board(size[0], size[1],gameSettings.getAmountOfPlayers());
//        for (Player plr : gameSettings.getPlayers()){
//            plr.setPosition(board.getRandomStartPosition());
//        }
//        observer = new State(board,Round.getInstance());
//        observable.addPCL(observer);
//        observable.setRound(Round.getInstance());
//        observable.setBoard(board);
//
//    }

//    public GameSettings getGameSettings() {
//        return gameSettings;
//    }
}

