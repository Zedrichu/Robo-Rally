package springboot.model.board;

import springboot.model.Position;
import springboot.model.Direction;
import springboot.model.checkPoints.CheckPoint;
import springboot.model.obstacles.*;

import static springboot.model.board.TileType.ACID;
import static springboot.model.board.TileType.PIT;
import static springboot.model.board.TileType.CONVEYORBELT;
import static springboot.model.board.TileType.LASER;
import static springboot.model.board.TileType.LIFETOKEN;
import static springboot.model.board.TileType.STARTING;
import static springboot.model.board.TileType.EMPTY;
import static springboot.model.board.TileType.CHECKPOINT;

public class Tile {

	private TileType type;
	private boolean robotOnTop;
	private String robotIcon;
	private Direction direction;
	public Position position;


	public Tile(TileType type) {
		this.type = type;
		this.robotOnTop = false;
	}

	public String getRobotIcon() {
		return robotIcon;
	}

	public void setRobotIcon(String robotIcon) {
		this.robotIcon = robotIcon;
	}

	public boolean getRobotOnTop(){return this.robotOnTop;}

	public void setRobotOnTop(boolean robotOnTop) {
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
		return "Tile{" +
				type +
				"," + position +
				'}';
	}
}
