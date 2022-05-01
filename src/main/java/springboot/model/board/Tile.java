package springboot.model.board;

import springboot.model.Position;
import springboot.model.Direction;

public class Tile {

	private TileType type;
	private boolean robotOnTop;
	private String robotIcon;
	private Direction direction;
	public Position position;

	public Tile(TileType type) {
		this.type = type;
		this.robotOnTop = false;
		this.direction = Direction.getRandomDirection();
	}

	public String getRobotIcon() {
		return robotIcon;
	}

	public void setRobotIcon(String robotIcon) {
		this.robotIcon = robotIcon;
	}

	public boolean getRobotOnTop(){return this.robotOnTop;}

	public void setRobotOnTop(boolean robotOnTop, Direction direction) {
		this.direction = direction;
		this.robotOnTop = robotOnTop;
	}

	public Position getPosition() {
		return position;
	}

	public TileType getType() {
		return type;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	@Override
	public String toString() {
		return type + "-->" + position;
	}
}
