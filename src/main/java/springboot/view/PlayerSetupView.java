package springboot.view;
import javax.swing.*;
import java.awt.*;
import game.players.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import springboot.controller.PlayerSetupController;

public class PlayerSetupView extends JFrame {
    private PlayerSetupController controller;

    public static void main(String[] args) {

    }

    public PlayerSetupView(PlayerSetupController controller) {
        this.controller = controller;
        this.setSize(700, 700);
        playerSetupGUI();
    }
    //Generates the GUI for the player setup, here you can pick names of players
    private void playerSetupGUI() {
        setSize(500,600);
        setResizable(true);
        setTitle("Player Setup!");
        setLayout(new SpringLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Jpanel panel = new JPanel();


    }
}