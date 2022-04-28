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
        getContentPane().setBackground( Color.DARK_GRAY );
        JButton GameButton = new JButton("Go to Game!");
        GameButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createRaisedBevelBorder()));
        GameButton.setBackground(Color.decode("#DC47DA"));
        GameButton.setForeground(Color.BLACK);
        GameButton.setOpaque(true);
        //JPanel mainPanel = new JPanel(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        //Panel one shows the board
        JPanel panelOne = new JPanel(new GridBagLayout());
        panelOne.add(boardController.getView());
        panelOne.setBackground(Color.DARK_GRAY);
        panelOne.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createRaisedBevelBorder()));


        //Panel drop down menu to pick starting tile
        //comboPosition = new JCombobox();
        JPanel panelTwo = new JPanel(new GridBagLayout());
        JLabel pickPos = new JLabel("Pick starting tile");
        pickPos.setFont(new Font("Serif", Font.BOLD, 20));
        pickPos.setForeground(Color.decode("#DC47DA"));
        panelTwo.add(pickPos,GridBagUtils.constraint(0,0,5));
        panelTwo.setBackground(Color.DARK_GRAY);
        panelTwo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createRaisedBevelBorder()));

        ArrayList<Object[]> selections = new ArrayList<>();

        int i=2;
        for (Player player : sps) {

            JLabel setStartPos = new JLabel("Player " + (player.getPlayerName()) + ":");
            setStartPos.setForeground(Color.decode("#DC47DA"));
            panelTwo.add(setStartPos, GridBagUtils.constraint(2*(i%2),2*(i/2),5));
            JComboBox inputPos = new JComboBox(boardController.getBoard().getStartTiles());
            JComboBox inputDir = new JComboBox(Direction.values());
            selections.add(new Object[]{player, inputPos, inputDir});
            panelTwo.add(inputPos, GridBagUtils.constraint(2*(i%2),2*(i/2)+1,5));
            panelTwo.add(inputDir, GridBagUtils.constraint(2*(i%2)+1,2*(i/2)+1,5));
            i++;
        }



        panelTwo.add(GameButton,GridBagUtils.constraint(2*(i%2)+7,2*(i/2)+5,5));
        GameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Object[] pair : selections){
                    Player plr = (Player) pair[0];
                    Position pos = ((Tile)((JComboBox) pair[1]).getSelectedItem()).getPosition();
                    Direction dir = (Direction) ((JComboBox) pair[2]).getSelectedItem();
                    plr.setDirection(dir);
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
        add(panelTwo, GridBagUtils.constraint(1,0,5));

        pack();
        setLocationRelativeTo(null);
    }

    private void showErr(){
        JOptionPane.showMessageDialog(null,"All positions must be different!","Invalid positions",JOptionPane.ERROR_MESSAGE);

    }

}
