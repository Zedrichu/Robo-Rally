package springboot.view.setupInterfaces;

import springboot.model.Complexity;
import springboot.controller.setup.GameSettingsFacadeController;
import springboot.utils.GridBagUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameSettingsView extends JFrame {

    private JButton btnStart;
    private JComboBox comboComplex;
    private JComboBox comboNumber;
    private GameSettingsFacadeController controller;


    public static void main(String[] args) {

    }

    public GameSettingsView(GameSettingsFacadeController controller) {
        this.controller = controller;
        this.setSize(500,500);
        initGUI();
    }

    private void initGUI() {
        setMinimumSize(new Dimension(300,250));
        setResizable(true);
        setTitle("Game Settings Menu");
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground( Color.DARK_GRAY );


        //Panel 1
        JPanel panelOne = new JPanel();

        //Image loader
        BufferedImage image;
        try {
            image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("roborally/welcome.png"));
        } catch (IOException e) {
            image = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        }
        ImageIcon img = new ImageIcon(image);
        JLabel roboRally = new JLabel("", img, JLabel.CENTER);
        panelOne.add(roboRally,BorderLayout.CENTER);
        panelOne.setBackground(Color.DARK_GRAY);
        panelOne.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createRaisedBevelBorder()));


        //Panel 2 for the combo boxes set up
        JPanel panelTwo = new JPanel();
        panelTwo.setBackground(Color.DARK_GRAY);
        panelTwo.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        //Combo boxes
        comboComplex = new JComboBox(Complexity.values());
        Integer[] range = {1,2,3,4,5,6,7,8};
        comboNumber = new JComboBox(range);
        btnStart = new JButton("Go to Board Selection");
        btnStart.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createRaisedBevelBorder()));
        btnStart.setBackground(Color.decode("#DC47DA"));
        btnStart.setForeground(Color.BLACK);
        btnStart.setOpaque(true);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setupGame((Complexity) comboComplex.getSelectedItem(),(Integer) comboNumber.getSelectedItem());
                dispose();
            }
        });

        //Adding to panel 2
        JLabel lvlDiff = new JLabel("Level of difficulty");
        lvlDiff.setForeground(Color.RED);
        panelTwo.add(lvlDiff, GridBagUtils.constraint(0,1,5));
        panelTwo.add(comboComplex, GridBagUtils.constraint(1,1,5));
        JLabel numPlayers = new JLabel("Number of Players");
        numPlayers.setForeground(Color.RED);
        panelTwo.add(numPlayers, GridBagUtils.constraint(0,2,5));
        panelTwo.add(comboNumber, GridBagUtils.constraint(1,2,5));
        panelTwo.add(btnStart, GridBagUtils.constraint(1,3,5));

        //Adding to the frame
        add(panelOne,GridBagUtils.constraint(0,0,5));
        add(panelTwo,GridBagUtils.constraint(0,1,5));

        pack();
        setLocationRelativeTo(null);
    }

    public void showError() {
        JOptionPane.showMessageDialog(this, "Not a valid selection",
                "Settings error", JOptionPane.ERROR_MESSAGE);
    }
}

