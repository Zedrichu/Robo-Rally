package springboot.view.cardViews;

import springboot.model.cards.Card;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class CardView extends JButton {

    BufferedImage image;

    CardView(Card card){
        super();
        String path = "cards/"+card.getName()+".png";

        try {
            image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(path));
        } catch (IOException e) {
            image = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        }
        Image img = image.getScaledInstance(80,120,4);
        ImageIcon icon = new ImageIcon(img);
        setText(card.getName());
        setIcon(icon);
        setBackground( Color.RED );

        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setMinimumSize(new Dimension(90,140));
    }
}
