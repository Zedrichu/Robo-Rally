package springboot.view.setupInterfaces;

import springboot.controller.setup.GameSettingsFacadeController;
import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.utils.GridBagUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;

import static java.lang.String.valueOf;

public class BoardSetupView extends JFrame {
    private final GameSettingsFacadeController gameSettingsController;

    public BoardSetupView(GameSettingsFacadeController gameSettingsController){
        this.gameSettingsController = gameSettingsController;
        initGUI();
    }

    private void initGUI(){
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
        JButton randomBtn = new JButton("Random Board");
        randomBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] sizes = gameSettings.getBoardSize();
                Board board = new Board(sizes[0], sizes[1]);
                board.loadRandomBoard(gameSettings.getAmountOfPlayers());

                gameSettingsController.setupBoard(board);
                dispose();
            }
        });

        // Button for easy board
//        easyBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String fileName = "Maps/MapEASY.json";
//                Board board = new Board(9, 9);
//                ClassLoader classLoader = getClass().getClassLoader();
//                InputStream inputStream = classLoader.getResourceAsStream(fileName);
//
//               // app.getFileFromResourceAsStream(fileName)
//                // "src/main/resources/Maps/MapEASY.json"
//
//                gameSettingsController.setupBoard(board);
//                dispose();
//
//            }
//        });

        // Button for EASY board
        JButton easyBtn = new JButton("EASY board");
        easyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] sizes = gameSettings.getBoardSize();
                Board board = new Board(sizes[0], sizes[1]);
                board.loadBoard_Easy();

                gameSettingsController.setupBoard(board);
                dispose();
            }
        });
        // Button for MEDIUM board
        JButton mediumBtn = new JButton("MEDIUM board");
        mediumBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] sizes = gameSettings.getBoardSize();
                Board board = new Board(sizes[0], sizes[1]);
                board.loadBoard_Medium();
                gameSettingsController.setupBoard(board);
                dispose();
            }
        });

        // Button for HARD board
        JButton hardBtn = new JButton("HARD board");
        hardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] sizes = gameSettings.getBoardSize();
                Board board = new Board(sizes[0], sizes[1]);
                board.loadBoard_Hard();
                gameSettingsController.setupBoard(board);
                dispose();
            }
        });

        randomBtn.setBackground(Color.decode("#DC47DA"));
        randomBtn.setForeground(Color.BLACK);
        randomBtn.setFont(new Font("MONOSPACED", Font.BOLD, 20));
        randomBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createRaisedBevelBorder()));
        randomBtn.setOpaque(true);

        easyBtn.setBackground(Color.decode("#DC47DA"));
        easyBtn.setForeground(Color.BLACK);
        easyBtn.setFont(new Font("MONOSPACED", Font.BOLD, 20));
        easyBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createRaisedBevelBorder()));
        easyBtn.setOpaque(true);

        mediumBtn.setBackground(Color.decode("#DC47DA"));
        mediumBtn.setForeground(Color.BLACK);
        mediumBtn.setFont(new Font("MONOSPACED", Font.BOLD, 20));
        mediumBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createRaisedBevelBorder()));
        mediumBtn.setOpaque(true);

        hardBtn.setBackground(Color.decode("#DC47DA"));
        hardBtn.setForeground(Color.BLACK);
        hardBtn.setFont(new Font("MONOSPACED", Font.BOLD, 20));
        hardBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createRaisedBevelBorder()));
        hardBtn.setOpaque(true);

        panelTwo.setBackground(Color.DARK_GRAY);
        panelTwo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createRaisedBevelBorder()));

        panelTwo.setBackground(Color.DARK_GRAY);
        panelTwo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createRaisedBevelBorder()));

        panelTwo.add(randomBtn);
        panelTwo.add(easyBtn);
        panelTwo.add(mediumBtn);
        panelTwo.add(hardBtn);


        add(panelOne, GridBagUtils.constraint(0,0,5));
        add(panelTwo, GridBagUtils.constraint(0,1,5));
        pack();
        setLocationRelativeTo(null);

    }

}
