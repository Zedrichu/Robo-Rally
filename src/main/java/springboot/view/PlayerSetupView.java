package springboot.view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import springboot.controller.GameSettingsController;
import springboot.controller.PlayerSetupController;

public class PlayerSetupView extends JFrame {
    private GameSettingsController controller;


    public static void main(String[] args) {

    }

    public PlayerSetupView(GameSettingsController controller, int noPlayers) {
        this.controller = controller;
        this.setSize(700, 700);
        playerSetupGUI(noPlayers);
    }
    //Generates the GUI for the player setup, here you can pick names of players
    private void playerSetupGUI(int noPlayers) {
        setSize(500,600);
        setResizable(true);
        setTitle("Player Setup!");
        setLayout(new SpringLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        for (int i = 0; i < noPlayers; i++) {
            add(new JLabel ("Player " + (i + 1)+"'s" + " name: "));
            add(new JTextField(15));

        }
        pack();
        setLocationRelativeTo(null);
        //layout.putConstraint(SpringLayout.WEST, player1, 10, SpringLayout.WEST, this);







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