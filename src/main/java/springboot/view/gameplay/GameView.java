package springboot.view.gameplay;

import springboot.controller.tableController;
import springboot.controller.GameController;
import springboot.model.GameSettings;
import springboot.utils.GridBagUtils;
import springboot.view.HealthView;
import springboot.view.boardViews.BoardView;
import springboot.view.cardViews.CardTableView;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private GameController gameController;
    private GameSettings gameSettings;
    private JButton playCards;


    public GameView(GameController gameController, tableController tableController, HealthView healthView, BoardView boardView) {
        this.gameController = gameController;
        initGUI(healthView,boardView, tableController.getView());
    }

    private void initGUI(HealthView healthView,BoardView boardView, CardTableView cardTableView) {
        setMinimumSize(new Dimension(600, 700));
        setResizable(true); //false
        setTitle("Game on!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        add(healthView, GridBagUtils.constraint(1,0,10));
        add(boardView, GridBagUtils.constraint(0,0,10));
        add(cardTableView, GridBagUtils.constraint(0,1,10));

        pack();
        setLocationRelativeTo(null);
    }
}