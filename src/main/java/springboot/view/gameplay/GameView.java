package springboot.view.gameplay;

import springboot.controller.TableController;
import springboot.controller.GameController;
import springboot.model.GameSettings;
import springboot.utils.GridBagUtils;
import springboot.view.HealthView;
import springboot.view.boardViews.BoardView;
import springboot.view.cardViews.CardTableView;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GameView extends JFrame implements PropertyChangeListener {
    private GameController gameController;
    private GameSettings gameSettings;
    private JButton playCards;


    public GameView(GameController gameController, TableController tableController, HealthView healthView, BoardView boardView) {
        this.gameController = gameController;
        initGUI(healthView,boardView, tableController.getView());
    }

    private void initGUI(HealthView healthView,BoardView boardView, JPanel cardTableView) {
        setMinimumSize(new Dimension(900, 800));
        setPreferredSize(getMaximumSize());
        setResizable(true); //false
        setTitle("Game on!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        getContentPane().setBackground( Color.DARK_GRAY );

        add(healthView, GridBagUtils.constraint(1,0,10));
        add(boardView, GridBagUtils.constraint(0,0,10));
        add(cardTableView, GridBagUtils.constraint(0,1,10));

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("settings")) {
            this.gameSettings = (GameSettings) evt.getNewValue();
            revalidate();
        }
    }
}