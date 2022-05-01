package springboot.view.gameplay;

import springboot.model.players.Player;
import springboot.model.round.Round;
import springboot.utils.GridBagUtils;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Set;
import javax.swing.*;
import java.awt.*;


public class HealthView extends JPanel implements PropertyChangeListener {

    private Round round;

    public HealthView(Round round){
        super();
        this.round = round;
        initGUI(round.getPlayers());
    }

    private void initGUI(Set<Player> players) {
        setMinimumSize(new Dimension(400,300));
        setLayout(new GridBagLayout());
        setBackground( Color.DARK_GRAY );
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.decode("#DC47DA")), BorderFactory.createRaisedBevelBorder()));


        JLabel healthTitle = new JLabel("Health bar overview");
        healthTitle.setFont(new Font("Arial", Font.BOLD, 20));
        healthTitle.setForeground(Color.ORANGE);
        add(healthTitle,GridBagUtils.constraint(1,0,10));
        int i =1;
        for (Player player : players) {
            JLabel plrtitle = new JLabel("Player " + (player.getPlayerName()) + "'s Health: " + (player.getLives()) + " lives");
            plrtitle.setForeground(Color.ORANGE);
            add(plrtitle, GridBagUtils.constraint(0, i, 5));
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("nextRound")) {
            this.round = (Round) evt.getNewValue();
            revalidate();
        }
    }
}