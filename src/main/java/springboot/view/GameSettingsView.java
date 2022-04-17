package springboot.view;

import game.Complexity;
import springboot.controller.GameSettingsController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;

public class GameSettingsView extends JFrame {

    private JButton btnStart;
    private JComboBox comboComplex;
    private JComboBox comboNumber;
    private GameSettingsController controller;

    public static void main(String[] args) {

    }

    public GameSettingsView(GameSettingsController controller) {
        this.controller = controller;
        this.setSize(500,500);
        initGUI();
    }

    private void initGUI() {
        setSize(300,400);
        setResizable(true);
        setTitle("Game settings menu!");
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        comboComplex = new JComboBox(Complexity.values());
        Integer[] range = {1,2,3,4,5,6,7,8,9};
        comboNumber = new JComboBox(range);
        btnStart = new JButton("Start Robo-Rally");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setupBoard((Complexity) comboComplex.getSelectedItem(),(Integer) comboNumber.getSelectedItem());
                setVisible(false);
            }
        });

        add(new JLabel("Level of difficulty:"), GridBagUtils.constraint(0,0,5));
        add(comboComplex, GridBagUtils.constraint(1,0,5));
        add(new JLabel("Number of participants:"), GridBagUtils.constraint(0,1,5));
        add(comboNumber, GridBagUtils.constraint(1,1,5));
        add(btnStart, GridBagUtils.constraint(1,2,5));

        pack();
        setLocationRelativeTo(null);
    }

    public void showError() {
        JOptionPane.showMessageDialog(this, "Not a valid selection",
                "Settings error", JOptionPane.ERROR_MESSAGE);
    }
}

class GridBagUtils {
    public static GridBagConstraints constraint(int x, int y,int inset) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.insets = new Insets(inset,inset,inset,inset);
        return c;
    }
}
