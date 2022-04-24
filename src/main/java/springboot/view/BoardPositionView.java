package springboot.view;

import ch.qos.logback.core.pattern.color.BoldYellowCompositeConverter;
import game.players.Player;
import springboot.controller.BoardPositionController;
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
import java.util.Set;

public class BoardPositionView extends JFrame {
    private GameSettingsController gameSettingsController;
    private BoardPositionController boardPositionController;
    private JButton SubmitButton;

    public BoardPositionView(GameSettingsController gameSettingsController, Board board, int noPlayers) {
        this.gameSettingsController = gameSettingsController;
        this.boardPositionController = boardPositionController;
        initGUI(board, noPlayers, sps);
    }


    private void initGUI(Board board,int noPlayers, Set<Player> sps) {
        setMinimumSize(new Dimension(600,700));
        setResizable(false);
        setTitle("Players pick positions");
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
        panelTwo.add(label,GridBagUtils.constraint(0,0,5));

        ArrayList<Object[]> selections = new ArrayList<>();

        int i=0;
        for (Player player : sps) {
            panelTwo.add(new JLabel("Player " + (player.getPlayerName()) + ":"), GridBagUtils.constraint(i,1,5));
            JComboBox input = new JComboBox(board.getStartTiles());
            selections.add(new Object[]{player, input});
            panelTwo.add(input, GridBagUtils.constraint(i,2,5));
            i++;
        }
        panelTwo.add(GameButton);
        GameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });

        add(panelOne, GridBagUtils.constraint(0,0,5));
        add(panelTwo, GridBagUtils.constraint(0,1,5));

        pack();
        setLocationRelativeTo(null);
    }

}
