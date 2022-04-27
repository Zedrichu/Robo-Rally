package springboot.model.board;

import springboot.model.Position;
import springboot.model.Direction;
import springboot.model.checkPoints.CheckPoint;
import springboot.model.obstacles.*;

import static springboot.model.board.TileType.ACID;
import static springboot.model.board.TileType.PIT;
import static springboot.model.board.TileType.CONVEYORBELT;
import static springboot.model.board.TileType.RADIATION;
import static springboot.model.board.TileType.LIFETOKEN;
import static springboot.model.board.TileType.STARTING;
import static springboot.model.board.TileType.EMPTY;
import static springboot.model.board.TileType.CHECKPOINT;

public class Tile {

	private TileType type;
	private boolean robotOnTop;
	private String robotIcon;
	public Direction direction;
	public Position position;


	public Tile(TileType type) {
		this.type = type;
		this.robotOnTop = false;
	}

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

	public Obstacle placeObstacle() {
		if (getType().equals(ACID))
			return new Acid();
		if (getType().equals(RADIATION))
			return new Laser();
		if (getType().equals(LIFETOKEN))
			return new LifeToken();
		if (getType().equals(PIT))
			return new Pit();
		if (getType().equals(CONVEYORBELT))
			return new ConveyorBelt();

		return null;
	}




	@Override
	public String toString() {
		return "Tile{" +
				type +
				"," + position +
				'}';
	}
}
