package springboot.view.gameSetupViews;

import springboot.controller.gameSetup.GameSettingsFacadeController;
import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.utils.GridBagUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeSupport;

public class BoardSetupView extends JFrame {
    private GameSettingsFacadeController gameSettingsController;
    private JButton randomBtn;


    public BoardSetupView(GameSettingsFacadeController gameSettingsController, PropertyChangeSupport support){
        this.gameSettingsController = gameSettingsController;
        initGUI(support);
    }


    private void initGUI(PropertyChangeSupport support){
        //add(new JLabel(new ImageIcon("Path/To/Your/Image.png")));
        setMinimumSize(new Dimension(300,300));
        setResizable(false);
        setTitle("Board Selection");
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground( Color.DARK_GRAY );

        //Panel 1 with label
        JPanel panelOne = new JPanel();
        JLabel boardOverview = new JLabel("Board Overview");
        boardOverview.setFont(new Font("MONOSPACED", Font.BOLD, 40));
        boardOverview.setForeground(Color.decode("#DC47DA"));
        panelOne.add(boardOverview);
        panelOne.setBackground(Color.DARK_GRAY);


        //Gets information from the game settings controller
        GameSettings gameSettings = gameSettingsController.getGameSettings();

        //Panel 2 with board preview
        JPanel panelTwo = new JPanel();
        panelOne.setBackground(Color.DARK_GRAY);


        //Button and creation of a random board
        randomBtn = new JButton("Random Board");
        randomBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] sizes = gameSettings.getBoardSize();
                Board board = new Board(support, sizes[0], sizes[1]);
                board.loadRandomBoard(gameSettings.getAmountOfPlayers());

                gameSettingsController.setupBoard(board);
                dispose();
            }
        });
        randomBtn.setBackground(Color.decode("#DC47DA"));
        randomBtn.setForeground(Color.BLACK);
        randomBtn.setFont(new Font("MONOSPACED", Font.BOLD, 20));
        randomBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createRaisedBevelBorder()));
        randomBtn.setOpaque(true);
        panelTwo.setBackground(Color.DARK_GRAY);
        panelTwo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createRaisedBevelBorder()));

        panelTwo.add(randomBtn);


        add(panelOne, GridBagUtils.constraint(0,0,5));
        add(panelTwo, GridBagUtils.constraint(0,1,5));
        pack();
        setLocationRelativeTo(null);

    }

}
