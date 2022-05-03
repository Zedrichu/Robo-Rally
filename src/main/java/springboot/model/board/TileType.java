package springboot.model.board;

import springboot.model.cards.Card;
import springboot.model.obstacles.CheckPoint;
import springboot.model.obstacles.*;
import springboot.model.obstacles.Obstacle;

/**
 * Enumeration of possible types of tiles.
 */
public enum TileType {
	
	EMPTY("tiles/floor.png", null),
	PIT("tiles/pit.png", new Pit()),
	ACID("tiles/acid.png", new Acid()),
	LASER("tiles/radiation.png", new Laser()),
	STARTING("tiles/starting.png", null),
	LIFETOKEN("tiles/lifeToken.png", new LifeToken()),
	CONVEYORBELT("tiles/conveyorBelt.png", new ConveyorBelt()),
	CHECKPOINT("tiles/checkPoint.png", new CheckPoint());

	final private String pictureFile;
	private Obstacle obstacle;

	/**
	 * Enum constructor
	 * @param pictureFile - path to picture of the tile
	 * @param obstacle - obstacle corresponding to the type of tile
	 */
	TileType(String pictureFile, Obstacle obstacle) {
		this.pictureFile = pictureFile;
		this.obstacle = obstacle;
	}

	/**
	 * Obstacle Setter
	 */
	public void setObstacle(Obstacle obstacle) {this.obstacle = obstacle;}

	/**
	 * Picture file Getter
	 */
	public String getPictureFile() {
		return pictureFile;
	}

	/**
	 * Obstacle Getter
	 */
	public Obstacle getObstacle() { return obstacle;}
}
