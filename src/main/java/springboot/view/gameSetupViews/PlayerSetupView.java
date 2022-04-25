package springboot.view.gameSetupViews;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import springboot.controller.gameSetup.GameSettingsFacadeController;
import springboot.controller.gameSetup.PlayerSetupController;
import springboot.utils.GridBagUtils;

public class PlayerSetupView extends JFrame {
    private GameSettingsFacadeController controller;
    private PlayerSetupController playerSetupController;
    private Set<String> names = new HashSet<>();
    private JButton submitBtn;


    public static void main(String[] args) {

    }

    public PlayerSetupView(GameSettingsFacadeController controller, PlayerSetupController playerSetupController, int noPlayers) {
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

        ArrayList<JTextField> inputs = new ArrayList<>(noPlayers);

        for (int i = 0; i < noPlayers; i++) {
            add(new JLabel ("Player " + (i + 1)+"'s" + " name: "), GridBagUtils.constraint(0,i,5));
            JTextField input = new JTextField(15);
            inputs.add(input);
            add(input, GridBagUtils.constraint(1,i,5));
        }

        submitBtn = new JButton("Submit");
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