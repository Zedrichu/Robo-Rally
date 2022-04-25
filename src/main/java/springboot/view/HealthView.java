package springboot.view;

import springboot.controller.gameplay.GameController;

import javax.swing.*;
import java.awt.*;

public class HealthView extends JFrame {

    private GameController gameController;
    float current_health;
    float max_health;
    float percentage;

    JPanel HealthBarPanel;
    public HealthView(GameController gameController){
        this.gameController = gameController;
        initGUI();
    }

    private void initGUI(){
        JProgressBar healthBar;
        setMinimumSize(new Dimension(300,300));
        setResizable(false);
        setTitle("Player Setup");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setTitle("Health");

        healthBar = new JProgressBar(0, 10);
        healthBar.setValue(5);
        // healthBar.addActionListener();


        pack();
        setLocationRelativeTo(null);

    }

}