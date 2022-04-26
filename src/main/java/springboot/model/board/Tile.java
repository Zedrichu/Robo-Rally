package springboot.model.board;

import springboot.model.Position;
import springboot.model.Direction;

public class Tile {

	private TileType type;
	public Direction direction;
	public Position position;

	public Tile(TileType type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "Tile{" +
				type +
				"," + position +
				'}';
	}
}
