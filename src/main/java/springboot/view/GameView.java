package springboot.view;

import springboot.controller.gameplay.GameController;
import springboot.utils.GridBagUtils;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private GameController controller;

    public GameView(GameController controller) {
        this.controller = controller;
    }

    private void initGUI(HealthBarView healthBarView){
        setMinimumSize(new Dimension(300,300));
        setResizable(false);
        setTitle("Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        add(healthBarView, GridBagUtils.constraint(1,0,5));

        pack();
        setLocationRelativeTo(null);
    }

}
