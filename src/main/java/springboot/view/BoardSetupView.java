package springboot.view;

import springboot.controller.BoardSetupController;
import springboot.controller.GameSettingsController;
import springboot.utils.GridBagUtils;
import view.widgets.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardSetupView extends JFrame {
    private GameSettingsController gameSettingsController;
    private JButton randomBtn;

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


        randomBtn = new JButton("Random Board");
        randomBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameSettingsController.setupBoard();
                dispose();
            }
        });

        add(randomBtn, GridBagUtils.constraint(0,0,5));
        pack();
        setLocationRelativeTo(null);

    }

}
