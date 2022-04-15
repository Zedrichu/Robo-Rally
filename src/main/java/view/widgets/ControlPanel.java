package view.widgets;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import springboot.model.Direction;

public class ControlPanel extends JPanel {

	private static final long serialVersionUID = 3023910913543183787L;
	private Board board;
	private int currentRow, currentColumn;
	private Direction currentDirection;
	
	private JButton moveN = new JButton("\u2b9d");
	private JButton moveS = new JButton("\u2b9f");
	private JButton moveW = new JButton("\u2b9c");
	private JButton moveE = new JButton("\u2b9e");
	private JButton rotate = new JButton("\u2b6e");

	public ControlPanel(Board board, int currentRow, int currentColumn, Direction currentDirection) {
		this.board = board;
		this.currentRow = currentRow;
		this.currentColumn = currentColumn;
		this.currentDirection = currentDirection;
		
		configure();
		addListeners();
	}
	
	private void configure() {
		setLayout(new GridLayout(3, 3));
		add(new JPanel()); add(moveN); add(new JPanel());
		add(moveW); add(rotate); add(moveE);
		add(new JPanel()); add(moveS); add(new JPanel());
	}
	
	private void addListeners() {
		rotate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (currentDirection) {
				case N:
					currentDirection = Direction.E;
					break;
				case E:
					currentDirection = Direction.S;
					break;
				case S:
					currentDirection = Direction.W;
					break;
				case W:
					currentDirection = Direction.N;
					break;

				}
				board.setRobot(currentRow, currentColumn, currentDirection);
				board.repaint();
			}
		});
		moveN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentRow > 0) {
					board.unsetRobot(currentRow, currentColumn);
					currentRow--;
				}
				board.setRobot(currentRow, currentColumn, currentDirection);
				board.repaint();
			}
		});
		moveS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentRow < board.getRows() - 1) {
					board.unsetRobot(currentRow, currentColumn);
					currentRow++;
				}
				board.setRobot(currentRow, currentColumn, currentDirection);
				board.repaint();
			}
		});
		moveW.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentColumn > 0) {
					board.unsetRobot(currentRow, currentColumn);
					currentColumn--;
				}
				board.setRobot(currentRow, currentColumn, currentDirection);
				board.repaint();
			}
		});
		moveE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentColumn < board.getColumns() - 1) {
					board.unsetRobot(currentRow, currentColumn);
					currentColumn++;
				}
				board.setRobot(currentRow, currentColumn, currentDirection);
				board.repaint();
			}
		});
	}
}
