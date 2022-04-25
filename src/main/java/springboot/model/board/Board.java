package springboot.model.board;

import java.util.*;

import springboot.model.Position;
import springboot.model.checkPoints.CheckPoint;
import springboot.model.tiles.TileType;

public class Board {

	private Random rnd = new Random();
	private Tile[][] board;
	private int rows;
	private int cols;
	private Set<Tile> startTiles = new HashSet<>();
	private Set<CheckPoint> checkPoints = new HashSet<>();

	public Set<CheckPoint> getCheckPoints() {
		return checkPoints;
	}

	public Board(int rows, int cols) {
		this.board = new Tile[rows][cols];
		this.rows = rows;
		this.cols = cols;
	}

	public int getCols() {
		return cols;
	}

	public int getRows() {
		return rows;
	}

	//Getter for board
	public Tile[][] getBoard() {
		return board;
	}

	public void loadBoard(int noPlrs) {
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

				if (t.getType().equals(TileType.CHECKPOINT)) {
					checkPoints.add(new CheckPoint());
				}
				board[j][i] = t;
			}

		}
	}

	public void getTemplate(MapType type) {
		// board = loadJSON(type.getBoardJSON());
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
		if (val < 0.75) {
			return new Tile(TileType.EMPTY);
	 	} else if (val <0.80) {
			return new Tile(TileType.CHECKPOINT);
		} else if (val < 0.92) {
			return new Tile(TileType.PIT);
		} else if (val < 0.96) {
			return new Tile(TileType.ACID);
		} else {
			return new Tile(TileType.RADIATION);
		}
	}

}
