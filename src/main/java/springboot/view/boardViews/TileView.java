package springboot.view.boardViews;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TileView extends JPanel {
//
//    setMinimumSize(new Dimension(PIXEL_SIZE, PIXEL_SIZE));
//    setMaximumSize(getMinimumSize());
//    setPreferredSize(getMinimumSize());
// try {
//        this.image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(this.type.getPictureFile()));
//        this.imageRobot = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/robot.png"));
//    } catch (
//    IOException e) {
//        this.image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
//        this.imageRobot = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
//    }
//
//    @Override
//    public void paint(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g;
//
//        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2d.drawImage(image, 0, 0, null);
//
//        if (containsRobot) {
//            AffineTransform old2 = g2d.getTransform();
//            g2d.rotate(Math.toRadians(direction.getAngle()), 33, 33);
//            g2d.drawImage(imageRobot, 0, 0, null);
//            g2d.setTransform(old2);
//        }
//    }
}
