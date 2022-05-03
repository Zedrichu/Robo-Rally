package springboot.model.board;

import java.util.*;
import springboot.model.Direction;
import springboot.model.Position;
import springboot.model.obstacles.CheckPoint;
import springboot.model.players.Player;

/**
 * Model class simulating the state of the gaming board in RoboRally.
 */
public class Board {

	private final Random rnd = new Random();
	private Tile[][] board;
	private int rows;
	private int cols;
	private Set<Tile> startTiles = new HashSet<>();
	private Set<CheckPoint> checkPoints = new HashSet<>();

	/**
	 * Class constructor creating the board with dimensions.
	 * @param rows - number of rows used in the board
	 * @param cols - number of columns used in the board
	 */
	public Board(int rows, int cols) {
		this.board = new Tile[rows][cols];
		this.rows = rows;
		this.cols = cols;
	}

	/**
	 * Getter for the set of check-points
	 */
	public Set<CheckPoint> getCheckPoints() {
		return checkPoints;
	}

	/**
	 * Getter for the number of columns
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * Getter for the number of rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Getter for board as a matrix of Tiles
	 */
	public Tile[][] getBoard() {
		return board;
	}

	/**
	 * Method to randomly load a board for the game.
	 * @param noPlrs - number of players in the game
	 */
	public void loadRandomBoard(int noPlrs) {
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
					// Add the starting tiles to a set
					startTiles.add(t);
				}
				if (t.getType().equals(TileType.CHECKPOINT)) {
					// Add the checkpoints to the general set
					checkPoints.add((CheckPoint) t.getType().getObstacle());
				}
				board[j][i] = t;
			}
		}
	}

	/**
	 * Method for loading a pre-defined EASY board.
	 */
	public void loadBoard_Easy() {
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				if ((i==6 && j==4) || (i==2 && j==4)) {
					Tile t = new Tile(TileType.ACID);
					t.position = new Position(i, j);
					board[j][i] = t;
				} else if ((i==3 && j==0) || (i==5 && j==3) || (i==4 && j==7)) {
					TileType type = TileType.CHECKPOINT;
					type.setObstacle(new CheckPoint());
					Tile t = new Tile(type);
					t.position = new Position(i, j);
					board[j][i] = t;
					checkPoints.add(new CheckPoint());
				} else if ((i==0 && j==0) || (i==0 && j==2) || (i==0 && j==6) || (i==0 && j==8) || (i==8 && j==0) || (i==8 && j==2) || (i==8 && j==6) || (i==8 && j==8)) {
					Tile t = new Tile(TileType.STARTING);
					t.position = new Position(i, j);
					board[j][i] = t;
					startTiles.add(t);
				} else if ((i==2 && j==0) || (i==2 && j==1) || (i==2 && j==2) || (i==2 && j==3) || (i==6 && j==0) || (i==6 && j==1) || (i==6 && j==2) || (i==6 && j==3)){
					Tile t = new Tile(TileType.CONVEYORBELT);
					t.setDirection(Direction.S);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==2 && j==5) || (i==2 && j==6) || (i==2 && j==7) || (i==2 && j==8) || (i==6 && j==5) || (i==6 && j==6) || (i==6 && j==7) || (i==6 && j==8)){
					Tile t = new Tile(TileType.CONVEYORBELT);
					t.setDirection(Direction.N);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==3 && j==1) || (i==4 && j==6) || (i==5 && j==2)) {
					Tile t = new Tile(TileType.LASER);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==0 && j==1) || (i==3 && j==2) || (i==4 && j==4) || (i==0 && j==7) || (i==4 && j==8) || (i==8 && j==1) || (i==8 && j==7)) {
					Tile t = new Tile(TileType.PIT);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==3 && j==4) || (i==5 && j==0) || (i==0 && j==4) || (i==5 && j==8) || (i==8 && j==4)) {
					Tile t = new Tile(TileType.LIFETOKEN);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else{
					Tile t = new Tile(TileType.EMPTY);
					t.position = new Position(i, j);
					board[j][i] = t;
				}
			}
		}
	}

	/**
	 * Method for loading a pre-defined MEDIUM board.
	 */
	public void loadBoard_Medium() {
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				if((i==0 && j==7) || (i==1 && j==7) || (i==3 && j==0) || (i==3 && j==1) || (i==9 && j==3) || (i==10 && j==3) || (i==7 && j==9) || (i==7 && j==10)) {
					Tile t = new Tile(TileType.ACID);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==3 && j==4) || (i==4 && j==7) || (i==7 && j==6) || (i==6 && j==3)) {
					var type =TileType.CHECKPOINT;
					type.setObstacle(new CheckPoint());
					Tile t = new Tile(type);
					t.position = new Position(i, j);
					board[j][i] = t;
					checkPoints.add(new CheckPoint());
				}else if((i==0 && j==1) || (i==1 && j==0) || (i==0 && j==9) || (i==1 && j==10) || (i==9 && j==0) || (i==10 && j==1) || (i==9 && j==10) || (i==10 && j==9)) {
					Tile t = new Tile(TileType.STARTING);
					t.position = new Position(i, j);
					board[j][i] = t;
					startTiles.add(t);
				}else if((i==1 && j==5) || (i==2 && j==5) || (i==3 && j==5) || (i==4 && j==5)){
					Tile t = new Tile(TileType.CONVEYORBELT);
					t.setDirection(Direction.E);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==5 && j==1) || (i==5 && j==2) ||(i==5 && j==3) || (i==5 && j==4)){
					Tile t = new Tile(TileType.CONVEYORBELT);
					t.setDirection(Direction.S);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==6 && j==5) || (i==7 && j==5 )||(i==8 && j==5) || (i==9 && j==5)){
					Tile t = new Tile(TileType.CONVEYORBELT);
					t.setDirection(Direction.W);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==5 && j==6) || (i==5 && j==7) || (i==5 && j==8) || (i==5 && j==9)){
					Tile t = new Tile(TileType.CONVEYORBELT);
					t.setDirection(Direction.N);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==0 && j==3) || (i==1 && j==3) || (i==3 && j==9) || (i==3 && j==10) || (i==7 && j==0) || (i==7 && j==1) || (i==9 && j==7) || (i==10 && j==7)) {
					Tile t = new Tile(TileType.LASER);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==0 && j==0) || (i==3 && j==3) || (i==3 && j==7) || (i==5 && j==5) || (i==10 && j==0) || (i==7 && j==3) || (i==7 && j==7) || (i==10 && j==10) || (i==0 && j==10)) {
					Tile t = new Tile(TileType.PIT);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==5 && j==0)||(i==0 && j==5) || (i==4 && j==6) || (i==5 && j==10) || (i==4 && j==4) || (i==10 && j==5) || (i==6 && j==4) || (i==6 && j==6)) {
					Tile t = new Tile(TileType.LIFETOKEN);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else{
					Tile t = new Tile(TileType.EMPTY);
					t.position = new Position(i, j);
					board[j][i] = t;
				}
			}
		}
	}

	/**
	 * Method for loading a pre-defined HARD board.
	 */
	public void loadBoard_Hard() {
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < cols; i++) {
				if((i==2 && j==3) || (i==2 && j==9) || (i==4 && j==5) || (i==4 && j==7) || (i==8 && j==5) || (i==8 && j==7) || (i==10 && j==3) || (i==10 && j==9)) {
					Tile t = new Tile(TileType.ACID);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==0 && j==6) || (i==6 && j==6) || (i==6 && j==0) || (i==6 && j==12) || (i==12 && j==6)) {
					TileType type =TileType.CHECKPOINT;
					type.setObstacle(new CheckPoint());
					Tile t = new Tile(type);
					t.position = new Position(i, j);
					board[j][i] = t;
					checkPoints.add(new CheckPoint());
				}else if((i==0 && j==2) || (i==0 && j==10) || (i==2 && j==0) || (i==2 && j==12) || (i==10 && j==0) || (i==10 && j==12) || (i==12 && j==2) || (i==12 && j==10)) {
					Tile t = new Tile(TileType.STARTING);
					t.position = new Position(i, j);
					board[j][i] = t;
					startTiles.add(t);
				}else if((i==0 && j==3) || (i==0 && j==4) || (i==0 && j==5) || (i==4 && j==1) || (i==8 && j==1) || (i==12 && j==3) || (i==12 && j==4) || (i==12 && j==5)){
					Tile t = new Tile(TileType.CONVEYORBELT);
					t.setDirection(Direction.S);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==0 && j==7) || (i==0 && j==8) || (i==0 && j==9) || (i==4 && j==11) || (i==8 && j==11) || (i==12 && j==7) || (i==12 && j==8) || (i==12 && j==9)) {
					Tile t = new Tile(TileType.CONVEYORBELT);
					t.setDirection(Direction.N);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==1 && j==4) || (i==1 && j==8) || (i==3 && j==0) || (i==3 && j==12) || (i==4 && j==0) || (i==4 && j==12) || (i==5 && j==0) || (i==5 && j==12)) {
					Tile t = new Tile(TileType.CONVEYORBELT);
					t.setDirection(Direction.E);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==7 && j==0) || (i==7 && j==12) || (i==8 && j==0) || (i==8 && j==12) || (i==9 && j==0) || (i==9 && j==12) || (i==11 && j==4) || (i==11 && j==8)) {
					Tile t = new Tile(TileType.CONVEYORBELT);
					t.setDirection(Direction.W);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==2 && j==7) || (i==2 && j==5) || (i==4 && j==3) || (i==4 && j==9) || (i==6 && j==2)  || (i==6 && j==10) || (i==8 && j==3) || (i==8 && j==9) || (i==10 && j==7) || (i==10 && j==5)) {
					Tile t = new Tile(TileType.LASER);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==1 && j==1) || (i==1 && j==11) || (i==5 && j==5) || (i==5 && j==7) || (i==7 && j==5) || (i==7 && j==7) || (i==11 && j==1) || (i==11 && j==11)) {
					Tile t = new Tile(TileType.PIT);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else if((i==0 && j==0) || (i==0 && j==12) || (i==12 && j==0) || (i==12 && j==12) || (i==3 && j==4) || (i==3 && j==8) || (i==9 && j==4) || (i==6 && j==3) || (i==6 && j==9)) {
					Tile t = new Tile(TileType.LIFETOKEN);
					t.position = new Position(i, j);
					board[j][i] = t;
				}else{
					Tile t = new Tile(TileType.EMPTY);
					t.position = new Position(i, j);
					board[j][i] = t;
				}
			}
		}
	}

	/**
	 * Method to place all robots corresponding to players on the board.
	 * @param sps - Set of players registered in the game
	 */
	public void placePlayers(Set<Player> sps) {
		for (Player plr : sps){
			Position pos = plr.getPosition();
			Tile tile = board[pos.y][pos.x];
			tile.setRobotOnTop(true,plr.getDirection());
			tile.setDirection(plr.getDirection());
			tile.setRobotIcon(plr.getRobot());
		}
	}

	/**
	 * Method to add a check-point to the board's set of check-points.
	 * @param checkPoint - CheckPoint object to be added to the set
	 */
	public void addCheckPoint(CheckPoint checkPoint) {
		this.checkPoints.add(checkPoint);
	}

	/**
	 * Getter method for the set of starting tiles.
	 */
	public Object[] getStartTiles() {
		return startTiles.toArray();
	}

	/**
	 * Method to obtain a random starting position on the board.
	 * @return Position object
	 */
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

	/**
	 * Method checking if a certain position is within bounds on the board.
	 * @param position - Position object to be checked
	 * @return boolean value, depending on whether the position is within bounds or not
	 */
	public boolean checkPositionInBounds(Position position) {
		return (0 <= position.x && position.x <= cols-1
				&& 0<=position.y && position.y <=rows-1);

	}

	/**
	 * Method generating random tile to construct the board matrix.
	 * @return Tile object requested
	 */
	private Tile getRandomTile() {
		double val = rnd.nextDouble();
		if (val < 0.05) {
			return new Tile(TileType.CHECKPOINT);
	 	} else if (val < 0.81) {
			return new Tile(TileType.EMPTY);
		} else if (val < 0.82) {
			return new Tile(TileType.PIT);
		} else if (val < 0.86) {
			return new Tile(TileType.ACID);
		} else if (val < 0.91) {
			return new Tile(TileType.LASER);
		} else if (val < 0.97) {
			return new Tile(TileType.CONVEYORBELT);
		} else {
			return new Tile(TileType.LIFETOKEN);
		}
	}

	/**
	 * Method to obtain the tile at a certain position in the board.
	 * @param pos - tuple of coordinates (x and y), denoting position
	 * @return Tile object requested
	 */
	public Tile getTile(int[] pos) {
		return board[pos[1]][pos[0]];
	}
}
