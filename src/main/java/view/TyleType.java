package view;

public enum TyleType {
	
	OPEN_FLOOR("tiles/floor.png"),
	PIT("tiles/pit.png"),
	ACID("tiles/acid.png"),
	RADIATION("tiles/radiation.png");
	
	private String pictureFile;
	
	private TyleType(String pictureFile) {
		this.pictureFile = pictureFile;
	}
	
	public String getPictureFile() {
		return pictureFile;
	}
}
