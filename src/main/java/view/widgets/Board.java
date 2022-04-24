package view.widgets;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.*;

import javax.swing.JPanel;

import springboot.model.Position;
import springboot.model.Direction;
import view.TileType;

public class Board extends JPanel {

	private static final long serialVersionUID = 5384602441603297852L;

	private Random rnd = new Random();
	private Tile[][] board;
	private int rows;
	private int cols;
	private Set<Tile> startTiles = new HashSet<>();

	
	public Board(int rows, int cols, int noPlrs) {
		this.board = new Tile[rows][cols];
		this.rows = rows;
		this.cols = cols;
		
		setLayout(new GridLayout(rows, cols));
		
		setMinimumSize(new Dimension(cols * Tile.PIXEL_SIZE, rows * Tile.PIXEL_SIZE));
		setMaximumSize(getMinimumSize());
		setPreferredSize(getMinimumSize());
		
		loadBoard(noPlrs);
	}

	//Getter for board
	public Tile[][] getBoard() {
		return board;
	}

	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return cols;
	}


	// These 2 should take a robotID to know which robot to move where #TODO
	public void setRobot(int row, int col, Direction direction) {
		board[row][col].setRobot(direction);
	}
	
	public void unsetRobot(int row, int col) {
		board[row][col].unsetRobot();
	}
	
	private void loadBoard(int noPlrs) {
		Random rnd = new Random();
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				Tile t = getRandomTile();
				if (noPlrs>0) {
					double val = rnd.nextDouble();
					if (val<0.20) {
						t = new Tile(TileType.STARTING);
						noPlrs--;}
				}
				t.position = new Position(i, j);

				if (t.getType().equals(TileType.STARTING)) {
					startTiles.add(t);
				}
				board[j][i] = t;
				add(t);
			}

		}
	}

	public Object[] getStartTiles() {
		return startTiles.toArray();
	}

	//Finds a random tile that is a starting tile
	public Position getRandomStartPosition() {
		int val = rnd.nextInt(1, startTiles.size());
		int i = 1;
		for (Tile tile : startTiles) {
			if (i == val) {
				return tile.position;
			}
			i++;
		}
		return null;

	}

	public boolean checkPositionInBounds(Position position) {
		return (0 <= position.x && position.x <= cols-1
				&& 0<=position.y && position.y <=rows-1);

	}

	private Tile getRandomTile() {
		double val = rnd.nextDouble();
		if (val <0.80) {
			return new Tile(TileType.EMPTY);
		} else if (val < 0.92) {
			return new Tile(TileType.PIT);
		} else if (val < 0.96) {
			return new Tile(TileType.ACID);
		} else {
			return new Tile(TileType.RADIATION);
		}
	}

	public static long getBoardID() {
		return serialVersionUID;
	}
}
