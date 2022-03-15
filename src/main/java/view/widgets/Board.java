package view.widgets;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;

import view.CardinalPoints;
import view.TyleType;

public class Board extends JPanel {

	private static final long serialVersionUID = 5384602441603297852L;
	
	private Random rnd = new Random();
	private Tile[][] board;
	private int rows;
	private int cols;
	
	public Board(int rows, int cols) {
		this.board = new Tile[rows][cols];
		this.rows = rows;
		this.cols = cols;
		
		setLayout(new GridLayout(rows, cols));
		
		setMinimumSize(new Dimension(cols * Tile.PIXEL_SIZE, rows * Tile.PIXEL_SIZE));
		setMaximumSize(getMinimumSize());
		setPreferredSize(getMinimumSize());
		
		loadBoard();
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return cols;
	}
	
	public Random getRandom() {
		return rnd;
	}
	
	public void setRobot(int row, int col, CardinalPoints direction) {
		board[row][col].setRobot(direction);
	}
	
	public void unsetRobot(int row, int col) {
		board[row][col].unsetRobot();
	}
	
	private void loadBoard() {
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				Tile t = new Tile(getRandomTyleType());
				board[j][i] = t;
				add(t);
			}
		}
	}
	
	private TyleType getRandomTyleType() {
		double val = rnd.nextDouble();
		if (val < 0.88) {
			return TyleType.OPEN_FLOOR;
		} else if (val < 0.92) {
			return TyleType.PIT;
		} else if (val < 0.96) {
			return TyleType.ACID;
		} else {
			return TyleType.RADIATION;
		}
	}
}
