package springboot.view;

import springboot.controller.CardController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardView extends JFrame implements ActionListener {

    private static CardLayout cardL = new CardLayout(40,30);
    //JPanel frame
    private void CardGUI(){


        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(cardL);
        cardPanel.setBounds(300,300,250,500);



        //Not completed need more r
       // JPanel panel = new JPanel();
       // JButton button = new JButton("Card");
       // panel.add(button);

       // button.addActionListener(new CardController());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}


