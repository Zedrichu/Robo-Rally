package view;

import java.util.Random;

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

	//Generates random direction
	public static CardinalPoints getRandomDirection(){
		Random r = new Random();
		float x = r.nextFloat();
		if (x < 0.25) {return CardinalPoints.N;}
		else if (x < 0.5) {return CardinalPoints.E;}
		else if (x < 0.75) {return CardinalPoints.S;}
		else {return CardinalPoints.W;}
	}

	public int getAngle() {
		return angle;
	}

	public String getAbbr() {
		return abbr;
	}
}
