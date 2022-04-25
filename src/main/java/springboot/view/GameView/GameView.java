package springboot.view.GameView;

import springboot.controller.GameSettingsController;
import springboot.utils.GridBagUtils;
import game.players.Player;
import springboot.controller.BoardPositionController;
import springboot.controller.GameSettingsController;
import springboot.model.Position;
import springboot.utils.GridBagUtils;
import view.widgets.Board;
import view.widgets.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.*;
import java.awt.*;
import java.springboot.model.cards.*;


public class GameView extends JFrame {
    private GameSettingsController gameSettingsController;
    private GameViewController gameViewController;
    private JButton playCards;


    public GameView(GameSettingsController gameSettingsController,GameViewController gameViewController, CardDeck cardDeck, Set<Player> sps,Board board) {
        this.gameSettingsController = gameSettingsController;
        this.gameViewController = gameSettingsController;
        initGUI(board, cardDeck, sps);
    }
}

    private void initGUI(Board board, CardDeck cardDeck, Set<Player> sps) {
        setMinimumSize(new Dimension(600,700));
        setResizable(false);
        setTitle("Players pick positions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        JPanel health = new JPanel();
        JLabel healthLabel = new JLabel("Healthbar of players");
        health.add(healthLabel, GridBagUtils.constraint(1,0,5));
        for (Player player : sps) {

        }
    }