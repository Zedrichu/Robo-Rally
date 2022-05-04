package springboot.view.setupInterfaces;

import springboot.controller.setup.GameSettingsController;
import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.utils.GridBagUtils;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * View class used in setting up the board used in the game.
 */
public class BoardSetupView extends JFrame {
    private final GameSettingsController gameSettingsController;

    public BoardSetupView(GameSettingsController gameSettingsController){
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

        //Panel for text
        JPanel panelText = new JPanel();
        panelText.setBackground(Color.DARK_GRAY);
        JLabel textLabel = new JLabel("!!!ATTENTION!!! When choosing board above, please choose the board corresponding to the level of difficulty set on the previous view for correct shown board OR choose RANDOM board.");
        textLabel.setForeground(Color.RED);
        panelText.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createRaisedBevelBorder()));
        panelText.setBackground(Color.DARK_GRAY);
        panelText.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createRaisedBevelBorder()));
        panelText.add(textLabel,GridBagUtils.constraint(0,1,5));

        //Panels for board previews
        JPanel panelRandom = new JPanel();
        panelRandom.setBackground(Color.DARK_GRAY);
        JPanel panelEasy = new JPanel();
        panelEasy.setBackground(Color.DARK_GRAY);
        JPanel panelMedium = new JPanel();
        panelMedium.setBackground(Color.DARK_GRAY);
        JPanel panelHard = new JPanel();
        panelHard.setBackground(Color.DARK_GRAY);

        //Button and creation of a random board
        JButton randomBtn = new JButton("RANDOM Board");
        randomBtn.addActionListener(e -> {
            int[] sizes = gameSettings.getBoardSize();
            Board board = new Board(sizes[0], sizes[1]);
            board.loadRandomBoard(gameSettings.getAmountOfPlayers());
            System.out.println(board.getCheckPoints());
            gameSettingsController.setupBoard(board);
            dispose();
        });
        randomBtn.setBackground(Color.decode("#DC47DA"));
        randomBtn.setForeground(Color.BLACK);
        randomBtn.setFont(new Font("MONOSPACED", Font.BOLD, 20));
        randomBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createRaisedBevelBorder()));
        randomBtn.setOpaque(true);

        //Image loader for random map
        BufferedImage imageR;
        try {
            imageR = ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("maps/mapRANDOM.png")));
        } catch (IOException e) {
            imageR = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        }
        ImageIcon imgIcR = new ImageIcon(imageR);
        JLabel mapRandom = new JLabel("", imgIcR, JLabel.CENTER);
        panelRandom.add(mapRandom,BorderLayout.CENTER);
        panelRandom.setBackground(Color.DARK_GRAY);
        panelRandom.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        panelRandom.add(randomBtn);

        // Button for EASY board
        JButton easyBtn = new JButton("EASY board");
        easyBtn.addActionListener(e -> {
            int[] sizes = gameSettings.getBoardSize();
            Board board = new Board(sizes[0], sizes[1]);
            board.loadBoard_Easy();

            gameSettingsController.setupBoard(board);
            dispose();
        });
        easyBtn.setBackground(Color.decode("#DC47DA"));
        easyBtn.setForeground(Color.BLACK);
        easyBtn.setFont(new Font("MONOSPACED", Font.BOLD, 20));
        easyBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createRaisedBevelBorder()));
        easyBtn.setOpaque(true);

        //Image loader for the easy map
        BufferedImage image1;
        try {
            image1 = ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("maps/mapEASY.png")));
        } catch (IOException e) {
            image1 = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        }
        ImageIcon imgIc = new ImageIcon(image1);
        JLabel mapEasy = new JLabel("", imgIc, JLabel.CENTER);
        panelEasy.add(mapEasy,GridBagUtils.constraint(0,0,5));
        panelEasy.setBackground(Color.DARK_GRAY);
        panelEasy.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        panelEasy.add(easyBtn,GridBagUtils.constraint(0,1,5));

        // Button for MEDIUM board
        JButton mediumBtn = new JButton("MEDIUM board");
        mediumBtn.addActionListener(e -> {
            int[] sizes = gameSettings.getBoardSize();
            Board board = new Board(sizes[0], sizes[1]);
            board.loadBoard_Medium();
            gameSettingsController.setupBoard(board);
            dispose();
        });
        mediumBtn.setBackground(Color.decode("#DC47DA"));
        mediumBtn.setForeground(Color.BLACK);
        mediumBtn.setFont(new Font("MONOSPACED", Font.BOLD, 20));
        mediumBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createRaisedBevelBorder()));
        mediumBtn.setOpaque(true);

        //Image loader for the medium map
        BufferedImage image2;
        try {
            image2 = ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("maps/mapMEDIUM.png")));
        } catch (IOException e) {
            image2 = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        }
        ImageIcon imgIc2 = new ImageIcon(image2);
        JLabel mapMedium = new JLabel("", imgIc2, JLabel.CENTER);
        panelMedium.add(mapMedium,BorderLayout.CENTER);
        panelMedium.setBackground(Color.DARK_GRAY);
        panelMedium.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        panelMedium.add(mediumBtn);

        // Button for HARD board
        JButton hardBtn = new JButton("HARD board");
        hardBtn.addActionListener(e -> {
            int[] sizes = gameSettings.getBoardSize();
            Board board = new Board(sizes[0], sizes[1]);
            board.loadBoard_Hard();
            gameSettingsController.setupBoard(board);
            dispose();
        });
        hardBtn.setBackground(Color.decode("#DC47DA"));
        hardBtn.setForeground(Color.BLACK);
        hardBtn.setFont(new Font("MONOSPACED", Font.BOLD, 20));
        hardBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createRaisedBevelBorder()));
        hardBtn.setOpaque(true);

        //Image loader for the hard map
        BufferedImage image3;
        try {
            image3 = ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("maps/mapHARD.png")));
        } catch (IOException e) {
            image3 = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        }
        ImageIcon imgIc3 = new ImageIcon(image3);
        JLabel mapHard = new JLabel("", imgIc3, JLabel.CENTER);
        panelHard.add(mapHard,BorderLayout.CENTER);
        panelHard.setBackground(Color.DARK_GRAY);
        panelHard.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createRaisedBevelBorder()));
        panelHard.add(hardBtn);

        JPanel panelTotal = new JPanel();
        panelTotal.setBackground(Color.DARK_GRAY);
        panelTotal.setLayout(new GridBagLayout());
        panelTotal.add(panelRandom, GridBagUtils.constraint(0,0,5));
        panelTotal.add(panelEasy, GridBagUtils.constraint(1,0,5));
        panelTotal.add(panelMedium, GridBagUtils.constraint(0,1,5));
        panelTotal.add(panelHard, GridBagUtils.constraint(1,1,5));

        add(panelOne, GridBagUtils.constraint(0,0,5));
        add(panelTotal, GridBagUtils.constraint(0,1,5));
        add(panelText, GridBagUtils.constraint(0,2,5));

        pack();
        setLocationRelativeTo(null);
    }

}
