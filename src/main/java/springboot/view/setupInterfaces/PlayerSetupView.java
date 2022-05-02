package springboot.view.setupInterfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import springboot.controller.setup.GameSettingsController;
import springboot.controller.setup.PlayerSetupController;
import springboot.utils.GridBagUtils;

public class PlayerSetupView extends JFrame {
    private GameSettingsController controller;
    private PlayerSetupController playerSetupController;
    private Set<String> names = new HashSet<>();

    public PlayerSetupView(GameSettingsController controller, PlayerSetupController playerSetupController, int noPlayers) {
        this.controller = controller;
        this.playerSetupController = playerSetupController;
        initGUI(noPlayers);
    }

    //Generates the GUI for the player setup, here you can pick names of players
    private void initGUI(int noPlayers) {
        setMinimumSize(new Dimension(500,600));
        setResizable(true);
        setTitle("Player Setup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        getContentPane().setBackground( Color.DARK_GRAY );

        ArrayList<JTextField> inputs = new ArrayList<>(noPlayers);

        for (int i = 0; i < noPlayers; i++) {
            JLabel setName = new JLabel ("Player " + (i + 1)+"'s" + " name: ");
            setName.setForeground(Color.decode("#DC47DA"));
            add(setName, GridBagUtils.constraint(0,i,5));
            JTextField input = new JTextField(15);
            inputs.add(input);
            add(input, GridBagUtils.constraint(1,i,5));
        }

        JButton submitBtn = new JButton("Submit");
        submitBtn.setForeground(Color.BLACK);
        submitBtn.setBackground(Color.decode("#DC47DA"));
        submitBtn.setOpaque(true);
        submitBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<noPlayers;i++) {
                    names.add(inputs.get(i).getText());
                }
                // Validation at some point "Jeppe" = "Jeppe" not good ;(

                if (playerSetupController.validateNames(names, noPlayers)){
                    controller.setupPlayers(names);
                    dispose();
                } else {
                    showErr();
                };

            }
        });

        add(submitBtn, GridBagUtils.constraint(1,noPlayers+1,5));
        pack();
        setLocationRelativeTo(null);
    }

    private void showErr(){
        JOptionPane.showMessageDialog(null,"All names must be different!","Invalid names",JOptionPane.ERROR_MESSAGE);

    }

}