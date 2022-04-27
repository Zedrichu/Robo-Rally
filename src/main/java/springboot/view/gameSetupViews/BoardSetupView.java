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

        //Gets information from the game settings controller
        GameSettings gameSettings = gameSettingsController.getGameSettings();

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

        add(randomBtn, GridBagUtils.constraint(0,0,5));
        pack();
        setLocationRelativeTo(null);

    }

}
