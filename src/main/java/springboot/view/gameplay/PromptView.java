package springboot.view.gameplay;

import springboot.controller.game.TableController;
import springboot.model.players.Player;
import springboot.model.Round;
import springboot.utils.GridBagUtils;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PromptView extends JPanel implements PropertyChangeListener {

    JButton ready;
    JLabel textField;
    Player player;
    TableController controller;

    public PromptView(TableController controller, Player player) {
        super(true);
        this.player = player;
        this.controller = controller;
        initGUI(this.controller.getRound());
    }

    public void initGUI(Round round) {
        setMinimumSize(new Dimension(400,300));
        setPreferredSize(getMinimumSize());
        setBorder(new BevelBorder(BevelBorder.LOWERED,new Color(255,230,100), new Color(3,1,77)));
        this.textField = new JLabel("Round: "+round.getRoundNumber()+"| Player "+this.player.getPlayerName()
                + " has to select cards in order!");
        this.textField.setVerticalTextPosition(SwingConstants.CENTER);
        this.textField.setMinimumSize(new Dimension(100,100));
        this.textField.setForeground(Color.RED);
        this.textField.setVerticalAlignment(SwingConstants.CENTER);
        add(textField, GridBagUtils.constraint(0,0,5));
        setBackground(new Color(255,230,100) );
        ready = new JButton("Ready");
        this.ready.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.select(false);
            }
        });
        this.ready.setVerticalAlignment(SwingConstants.CENTER);
        this.ready.setVerticalTextPosition(SwingConstants.CENTER);
        add(ready, GridBagUtils.constraint(0,1,5));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("player")) {
            this.player = (Player) evt.getNewValue();
            this.removeAll();
            initGUI(this.controller.getRound());
            revalidate();
        } else if (evt.getPropertyName().equals("selection")
                && (boolean) evt.getNewValue() ) {
            this.controller.setView(this);
            revalidate();
        }
        if (evt.getPropertyName().equals("nextRound")){
            //initGUI(this.controller.getRound());
            this.controller.setView(this);
            revalidate();

        }
    }
}
