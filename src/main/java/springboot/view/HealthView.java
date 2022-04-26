package springboot.view;

import springboot.model.players.Player;
import springboot.utils.GridBagUtils;

import java.util.Set;
import javax.swing.*;
import java.awt.*;


public class HealthView extends JPanel {

    private Set<Player> players;

    public HealthView(Set<Player> players){
        super();
        initGUI(players);
    }

    private void initGUI(Set<Player> players) {
        setMinimumSize(new Dimension(300,300));
        setLayout(new GridBagLayout());

        add(new JLabel("Health bar overview"),GridBagUtils.constraint(1,0,10));
        int i =1;
        for (Player player : players) {
            add(new JLabel("Player " + (player.getPlayerName()) + "'s Health: " + (player.getLives()) + " lives"), GridBagUtils.constraint(0, i, 5));
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
    }

}