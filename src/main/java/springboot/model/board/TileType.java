package springboot.model.board;

import springboot.model.obstacles.CheckPoint;
import springboot.model.obstacles.*;
import springboot.model.obstacles.Obstacle;

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
	final private Obstacle obstacle;

	
	TileType(String pictureFile, Obstacle obstacle) {
		this.pictureFile = pictureFile;
		this.obstacle = obstacle;
	}
	
	public String getPictureFile() {
		return pictureFile;
	}

	public Obstacle getObstacle() { return obstacle;}
}
