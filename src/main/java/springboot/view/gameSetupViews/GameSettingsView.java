package springboot.view.gameSetupViews;

import springboot.model.Complexity;
import springboot.controller.gameSetup.GameSettingsFacadeController;
import springboot.utils.GridBagUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        comboComplex = new JComboBox(Complexity.values());
        Integer[] range = {1,2,3,4,5,6,7,8};
        comboNumber = new JComboBox(range);
        btnStart = new JButton("Go to Board Selection");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setupGame((Complexity) comboComplex.getSelectedItem(),(Integer) comboNumber.getSelectedItem());
                dispose();
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

