package springboot.model.board;

import springboot.model.Position;
import springboot.model.Direction;
import springboot.model.obstacles.CheckPoint;

/**
 * Model class simulating each of the tiles forming the board matrix.
 */
public class Tile {

	private final TileType type;
	private boolean robotOnTop;
	private String robotIcon;
	private Direction direction;
	public Position position;

	/**
	 * Model class constructor based on specific type of tile.
	 * @param type - TileType enum option
	 */
	public Tile(TileType type) {
		if (type == TileType.CHECKPOINT) {
			type.setObstacle(new CheckPoint());
		};
		this.type = type;
		this.robotOnTop = false;
		this.direction = Direction.getRandomDirection();
	}

	/**
	 * Robot icon Getter
	 * @return string holding the path to the icon
	 */
	public String getRobotIcon() {
		return robotIcon;
	}

	/**
	 * Robot icon Setter
	 * @param robotIcon - string, path to the icon file
	 */
	public void setRobotIcon(String robotIcon) {
		this.robotIcon = robotIcon;
	}

	/**
	 * Getter checking if robot is on top of the tile.
	 * @return boolean value, true - if robot is on top
	 */
	public boolean getRobotOnTop(){return this.robotOnTop;}

	/**
	 * Setter marking robot on top of the tile.
	 * @param robotOnTop - boolean value marking the presence of the robot
	 * @param direction - direction of the tile orientation
	 */
	public void setRobotOnTop(boolean robotOnTop, Direction direction) {
		this.direction = direction;
		this.robotOnTop = robotOnTop;
	}

	/**
	 * Position Getter
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Getter of the type of tile (TileType)
	 */
	public TileType getType() {
		return type;
	}

	/**
	 * Direction Setter
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * Direction Getter
	 */
	public Direction getDirection() {
		return direction;
	}

	@Override
	public String toString() {
		return type + "-->" + position;
	}
}
