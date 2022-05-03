package springboot.view.cardInterface;

import springboot.model.cards.Card;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * View class presenting each of the cards on GUI.
 */
public class CardView extends JButton {

    public int choice;
    private BufferedImage image;

    CardView(Card card){
        super();
        // Defining path for the image resource of each card
        String path = "cards/"+card.getName()+".png";
        choice = 0;
        setForeground(Color.BLACK);
        // Loading the card image as button icon
        try {
            image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(path));
        } catch (IOException e) {
            image = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        }
        Image img = image.getScaledInstance(60,100,4);
        ImageIcon icon = new ImageIcon(img);
        setOpaque(true);
        setSelected(false);
        setText(card.getName());
        setIcon(icon);
        setBackground( Color.RED );

        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setMinimumSize(new Dimension(90,140));
    }

    /**
     * Method to change color and label on selection of a card, triggered by button listeners.
     */
    public void select(int number) {
        // If selected, make frame around GREEN
        if (number>0) {
            setSelected(true);
            setBackground(Color.GREEN);
            this.choice = number;
            setText(getText()+"✅"+number);
            setOpaque(true);
            // Else make the frame back RED
        } else {
            setSelected(false);
            setBackground(Color.RED);
            this.choice = 0;
            String[] str = getText().split("✅");
            setText(str[0]);
            setOpaque(true);
        }
    }

}
