package view;

public enum CardinalPoints {
	N(0, "N"), S(180,"S"), E(90,"E"), W(270,"W");
	
	final private int angle;
	final private String abbr;

	CardinalPoints(int angle, String abbr) {
		this.angle = angle;
		this.abbr = abbr;
	}

	public static CardinalPoints getCardinalPointChar(String c) {
		for (CardinalPoints cp : CardinalPoints.values()) {
			if (c.equals(cp.getAbbr())) {return cp;}
		}
		return null;
	}

	public static CardinalPoints getCardinalPointByAngle(int angle) {
		for (CardinalPoints cp : CardinalPoints.values()) {
			if (angle == cp.getAngle()) {return cp;}
		}
		return null;
	}

	public int getAngle() {
		return angle;
	}

	public String getAbbr() {
		return abbr;
	}
}
