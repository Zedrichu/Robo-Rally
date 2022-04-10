package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SimpleFrame extends JFrame {
    public SimpleFrame(String title) {
        super(title);
        setSize(300,400);
    }
}

class SimplePaint extends  JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (g instanceof Graphics2D){
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.GREEN);
            g2.fillOval(40,30,120,120);

            g2.setColor(Color.RED);
            g2.drawRect(60,50,60,60);
        }
    }
}

class ButtonListener implements ActionListener {
    private int c=0;
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!"+c+e.getActionCommand());
        c++;
    }
}

public class testGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("App title");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton b1 = new JButton("BUTTONARO");
        JButton b2 = new JButton("BUTTONI");

        ButtonListener listener = new ButtonListener();

        b1.setActionCommand("CMD~1");
        b2.setActionCommand("CMD~2");

        b1.addActionListener(listener);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked!");
            }
        });


        frame.setLayout(new FlowLayout());
        frame.add(b1);
        frame.add(b2);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
