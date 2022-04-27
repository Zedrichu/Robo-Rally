package springboot.view.gameSetupViews;

import springboot.controller.BoardController;
import springboot.model.Direction;
import springboot.model.players.Player;
import springboot.controller.gameSetup.StartPositionController;
import springboot.controller.gameSetup.GameSettingsFacadeController;
import springboot.model.Position;
import springboot.utils.GridBagUtils;
import springboot.model.board.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

public class StartPositionView extends JFrame {
    private GameSettingsFacadeController gameSettingsController;
    private StartPositionController startPositionController;

    public StartPositionView(GameSettingsFacadeController gameSettingsController, StartPositionController startPositionController,
                             BoardController boardController, int noPlayers, Set<Player> sps) {
        this.gameSettingsController = gameSettingsController;
        this.startPositionController = startPositionController;

        initGUI(boardController, noPlayers, sps);
    }


    private void initGUI(BoardController boardController,int noPlayers, Set<Player> sps) {
        setMinimumSize(new Dimension(600,700));
        setResizable(false);
        setTitle("Players pick positions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setResizable(true);
        JButton GameButton = new JButton("Go to Game!");

        //JPanel mainPanel = new JPanel(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        //Panel one shows the board
        JPanel panelOne = new JPanel(new GridBagLayout());
        panelOne.add(boardController.getView());

        //Panel drop down menu to pick starting tile
        //comboPosition = new JCombobox();
        JPanel panelTwo = new JPanel(new GridBagLayout());
        JLabel label = new JLabel("Pick starting tile");
        panelTwo.add(label,GridBagUtils.constraint(0,0,5));

        ArrayList<Object[]> selections = new ArrayList<>();

        int i=0;
        for (Player player : sps) {
            panelTwo.add(new JLabel("Player " + (player.getPlayerName()) + ":"), GridBagUtils.constraint(i,1,5));
            JComboBox input = new JComboBox(boardController.getBoard().getStartTiles());
            selections.add(new Object[]{player, input});
            panelTwo.add(input, GridBagUtils.constraint(i,2,5));
            i++;
        }
        panelTwo.add(GameButton,GridBagUtils.constraint(noPlayers,2,5));
        GameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Object[] pair : selections){
                    Player plr = (Player) pair[0];
                    Position pos = ((Tile)((JComboBox) pair[1]).getSelectedItem()).getPosition();
                    plr.setDirection(Direction.getRandomDirection());
                    plr.setPosition(pos);

                }
                if (startPositionController.validatePositions(sps)){
                    System.out.println("Entire game setup is completed!");
                    gameSettingsController.selectPositions(sps, boardController);
                    dispose();
                }
                else {
                    showErr();
                }
            }

        });

        add(panelOne, GridBagUtils.constraint(0,0,5));
        add(panelTwo, GridBagUtils.constraint(0,1,5));

        pack();
        setLocationRelativeTo(null);
    }

    private void showErr(){
        JOptionPane.showMessageDialog(null,"All positions must be different!","Invalid positions",JOptionPane.ERROR_MESSAGE);

    }

}
