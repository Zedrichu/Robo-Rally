package view;

public enum TileType {
	
	EMPTY("tiles/floor.png"),
	PIT("tiles/pit.png"),
	ACID("tiles/acid.png"),
	RADIATION("tiles/radiation.png"),
	STARTING("tiles/starting.png");


	final private String pictureFile;
	
	TileType(String pictureFile) {
		this.pictureFile = pictureFile;
	}
	
	public String getPictureFile() {
		return pictureFile;
	}
}
