package springboot.view.boardInterface;

import springboot.model.board.Tile;
import springboot.model.board.TileType;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 * View class presenting the tiles of the board on GUI
 */
public class TileView extends JPanel {

    public static final int PIXEL_SIZE = 66;
    private final Tile tile;
    private BufferedImage image;
    private BufferedImage robImage;

    public TileView(Tile tile){
        super(true);
        this.tile = tile;
        TileType type = tile.getType();
        try {
            this.image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(type.getPictureFile()));
            //this.image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(type.getPictureFile())));
            if (tile.getRobotOnTop()) {
                System.out.println(tile.getRobotIcon());
                this.robImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(tile.getRobotIcon()));
                //this.robImage = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(tile.getRobotIcon())));
            }
        } catch (IOException e){
            this.image = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
            this.robImage = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        }

        if (type == TileType.CHECKPOINT ||
                tile.getRobotOnTop())
            setOpaque(false);
        setMinimumSize(new Dimension(PIXEL_SIZE, PIXEL_SIZE));
        setMaximumSize(getMinimumSize());
        setPreferredSize(getMinimumSize());
    }

    public void paint(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(image,0,0,null);

        if (tile.getType().equals(TileType.STARTING)) {
            Image img = image.getScaledInstance(PIXEL_SIZE, PIXEL_SIZE, 4);
            g2d.drawImage(img, 0,0,null);
        }

        if (tile.getType().equals(TileType.LIFETOKEN)) {
            Image img = image.getScaledInstance(PIXEL_SIZE, PIXEL_SIZE, 4);
            g2d.drawImage(img, 0,0,null);
        }

        if (tile.getType().equals(TileType.CHECKPOINT)) {
            Image img = image.getScaledInstance(PIXEL_SIZE, PIXEL_SIZE, 4);
            g2d.drawImage(img, 0,0,null);
        }

        if (tile.getRobotOnTop()) {
            AffineTransform old2 = g2d.getTransform();
            g2d.rotate(Math.toRadians(tile.getDirection().getAngle()),33,33);
            g2d.drawImage(robImage, 0, 0, null);
            g2d.setTransform(old2);
        }

    }
}

