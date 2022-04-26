package springboot.view;

import springboot.controller.CardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardView extends JFrame implements ActionListener {


    public CardView(){

       // for (Player player /: players) {
       //     initGUI(player);
     //   }
    }


    private void initGUI(){
        setMinimumSize(new Dimension(400,300));
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}


