package springboot.view;

import ch.qos.logback.core.pattern.color.BoldYellowCompositeConverter;
import springboot.controller.GameSettingsController;
import springboot.model.Position;
import springboot.utils.GridBagUtils;
import view.widgets.Board;
import view.widgets.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BoardPositionView extends JFrame {
    private GameSettingsController gameSettingsController;
    private JButton SubmitButton;


    public static void main(String[] args) {

    }

    public BoardPositionView(GameSettingsController gameSettingsController, Board board, int noPlayers) {
        this.gameSettingsController = gameSettingsController;
        initGUI(board, noPlayers);
    }


    private void initGUI(Board board,int noPlayers) {
        setMinimumSize(new Dimension(600,700));
        setResizable(false);
        setTitle("Player pick positions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        JButton GameButton = new JButton("Go to Game!");

        //JPanel mainPanel = new JPanel(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        //Panel one shows the board
        JPanel panelOne = new JPanel(new GridBagLayout());
        add(board);





        //Panel drop down menu to pick starting tile
        //comboPosition = new JCombobox();
        JPanel panelTwo = new JPanel(new GridBagLayout());
        JLabel label = new JLabel("Pick starting tile");
        for (int i = 0; i < noPlayers; i++) {
            add(new JLabel("Player " + (i) + ":"), GridBagUtils.constraint(i,0,5));
            //add(new JComboBox(Position board.getRandomStartPosition(), GridBagUtils.constraint(i,1,5)));

        }
        panelTwo.add(GameButton);
        GameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });


        pack();
        setLocationRelativeTo(null);
    }

}
