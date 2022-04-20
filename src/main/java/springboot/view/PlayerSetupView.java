package springboot.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import game.players.Player;
import io.cucumber.java.en_old.Ac;
import springboot.controller.GameSettingsController;
import springboot.controller.PlayerSetupController;
import springboot.utils.GridBagUtils;

public class PlayerSetupView extends JFrame {
    private GameSettingsController controller;
    private Set<String> names = new HashSet<>();
    private JButton submitBtn;


    public static void main(String[] args) {

    }

    public PlayerSetupView(GameSettingsController controller, int noPlayers) {
        this.controller = controller;
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

                controller.setupPlayers(names);
            }
        });

        add(submitBtn, GridBagUtils.constraint(1,noPlayers+1,5));
        pack();
        setLocationRelativeTo(null);






     //   JButton submit = new JButton("Submit");
        //  submit.addActionListener(new ActionListener() {
        //    @Override
        //   public void actionPerformed(ActionEvent e) {
        //     System.out.println("Names have been picked");
        //      controller.setPlayerNames();
        //      controller.setPlayerSetup(true);

        //});


    }



}