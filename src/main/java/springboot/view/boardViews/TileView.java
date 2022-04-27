package springboot.view.boardViews;

import springboot.model.board.TileType;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class TileView extends JPanel {

    public static final int PIXEL_SIZE = 66;
    private TileType type;
    private BufferedImage image;

    public TileView(TileType type){
        super(true);

        this.type = type;
        try {

            this.image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(this.type.getPictureFile()));
        } catch (IOException e){
            this.image = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        }

        if (this.type == TileType.CHECKPOINT)
            setOpaque(false);
        setMinimumSize(new Dimension(PIXEL_SIZE, PIXEL_SIZE));
        setMaximumSize(getMinimumSize());
        setPreferredSize(getMinimumSize());

    }

    public void paint(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(image, 0, 0,null);

    }
}
//
//        if (containsRobot) {
//            AffineTransform old2 = g2d.getTransform();
//            g2d.rotate(Math.toRadians(direction.getAngle()), 33, 33);
//            g2d.drawImage(imageRobot, 0, 0, null);
//            g2d.setTransform(old2);
//        }
