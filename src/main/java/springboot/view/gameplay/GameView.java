package springboot.view.gameplay;

import springboot.controller.game.TableController;
import springboot.controller.game.GameController;
import springboot.model.GameSettings;
import springboot.utils.GridBagUtils;
import springboot.view.boardInterface.BoardView;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GameView extends JFrame implements PropertyChangeListener {
    private final GameController gameController;
    private GameSettings gameSettings;
    private JPanel tableView;
    private HealthView healthView;
    private BoardView boardView;
    private JButton playCards;


    public GameView(GameController gameController, TableController tableController, HealthView healthView, BoardView boardView) {
        this.gameController = gameController;
        this.boardView = boardView;
        this.healthView = healthView;
        initGUI(this.healthView, this.boardView, tableController.getView());
    }

    private void initGUI(HealthView healthView,BoardView boardView, JPanel tableView) {
        setMinimumSize(new Dimension(900, 800));
        setPreferredSize(getMaximumSize());
        setResizable(true); //false
        setTitle("Game on!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.DARK_GRAY );

        add(healthView, GridBagUtils.constraint(1,0,10));
        add(boardView, GridBagUtils.constraint(0,0,10));
        add(tableView, GridBagUtils.constraint(0,1,10));

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("table")) {
            this.tableView = (JPanel) evt.getNewValue();
            gameController.setGameView();
            initGUI(this.healthView, this.boardView, this.tableView);
            revalidate();
        }
    }
}