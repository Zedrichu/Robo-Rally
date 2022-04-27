package springboot.view.gameplay;

import springboot.controller.TableController;
import springboot.model.players.Player;
import springboot.utils.GridBagUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PromptView extends JPanel{

    TableController controller;

    public PromptView(TableController controller, Player player) {
        super(true);
        this.controller = controller;
        initGUI(player);
    }

    public void initGUI(Player player) {
        setForeground(Color.RED);
        add(new JTextField("Player "+player.getPlayerName()+" has to select cards in order!"),GridBagUtils.constraint(0,0,5));
        setBackground( Color.DARK_GRAY );
        JButton ready = new JButton("Ready");
        ready.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showTable(player);
            }
        });
        add(ready, GridBagUtils.constraint(0,1,5));
    }

}
