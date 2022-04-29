package springboot.view.gameplay;

import springboot.controller.game.TableController;
import springboot.model.players.Player;
import springboot.utils.GridBagUtils;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PromptView extends JPanel implements PropertyChangeListener {

    JLabel textField;
    Player player;
    TableController controller;

    public PromptView(TableController controller, Player player) {
        super(true);
        this.player = player;
        this.controller = controller;
        initGUI();
    }

    public void initGUI() {
        setMinimumSize(new Dimension(300,150));
        setPreferredSize(getMinimumSize());
        setBorder(new BevelBorder(BevelBorder.LOWERED,new Color(255,230,100), new Color(3,1,77)));
        this.textField = new JLabel("Player "+this.player.getPlayerName()
                + " has to select cards in order!"+this.player.getLives());
        this.textField.setMinimumSize(new Dimension(100,100));
        this.textField.setForeground(Color.RED);
        add(textField, GridBagUtils.constraint(0,0,5));
        setBackground(new Color(255,230,100) );
        JButton ready = new JButton("Ready");
        ready.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.select(false);
            }
        });
        add(ready, GridBagUtils.constraint(0,1,5));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("player")
                && controller.isSelected()) {
            this.player = (Player) evt.getNewValue();
            revalidate();
        } else if (evt.getPropertyName().equals("selection")
                && (boolean) evt.getNewValue() ) {
            controller.setView(this);
            revalidate();
        }
    }
}
