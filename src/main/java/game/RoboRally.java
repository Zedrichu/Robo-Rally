package game;

import java.awt.FlowLayout;
import java.io.IOException;
import javax.swing.JFrame;
import view.*;
import view.widgets.*;
public class RoboRally {

    public static void main(String[] args) throws IOException{
        int initialRow = 2;
        int initialColumn = 2;
        CardinalPoints currentDirection = CardinalPoints.N;

        Board board = new Board(8, 13);
        board.setRobot(initialRow, initialColumn, currentDirection);

        ControlPanel control = new ControlPanel(board, initialRow, initialColumn, currentDirection);

        JFrame f = new JFrame("game.RoboRally Demo - v.0.1");
        f.setLayout(new FlowLayout(FlowLayout.CENTER));
        f.add(board);
        f.add(control);
        f.setSize(900, 700);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
