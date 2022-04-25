package springboot.view;

import springboot.controller.gameplay.GameController;
import springboot.model.GameSettings;
import springboot.model.players.Player;
import springboot.utils.GridBagUtils;

import java.util.ArrayList;
import java.util.Set;
import javax.swing.*;
import java.awt.*;


public class HealthView extends JFrame {

    private GameController gameController;
    private GameSettings gameSettings;
    float current_health;
    float max_health;
    float percentage;

    JPanel HealthBarPanel;
    public HealthView(GameController gameController, GameSettings gameSettings){
        this.gameSettings = gameSettings;
        this.gameController = gameController;
        initGUI(gameSettings.getPlayers());
    }

    private void initGUI(Set<Player> players) {
        setMinimumSize(new Dimension(300,300));
        setResizable(false);
        setTitle("Player Setup");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setTitle("Health");



        add(new JLabel("Health bar overview"),GridBagUtils.constraint(1,0,10));
        int i =1;
        for (Player player : gameSettings.getPlayers()) {
            add(new JLabel("Player " + (player.getPlayerName()) + "'s Health : " + (player.getLives()) + " lives"), GridBagUtils.constraint(0, i, 5));
            JProgressBar healthBar = new JProgressBar(0, 10);
            healthBar.setValue(player.getLives());
            if (player.getLives() < 4) {
                healthBar.setForeground(Color.RED);
            }
            else if (player.getLives() < 8) {
                healthBar.setForeground(Color.ORANGE);
            }
            else if (player.getLives() >= 8) {
                healthBar.setForeground(Color.GREEN);
            }
            add(healthBar, GridBagUtils.constraint(1, i, 10));
            i++;
        }




        pack();
        setLocationRelativeTo(null);

    }

}