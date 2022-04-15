package springboot.model;

import java.util.Random;

public enum Direction {
	N(0, "N"), S(180,"S"), E(90,"E"), W(270,"W");
	
	final private int angle;
	final private String abbr;

	Direction(int angle, String abbr) {
		this.angle = angle;
		this.abbr = abbr;
	}

	public static Direction getCardinalPointChar(String c) {
		for (Direction cp : Direction.values()) {
			if (c.equals(cp.getAbbr())) {return cp;}
		}
		return null;
	}

	public static Direction getCardinalPointByAngle(int angle) {
		for (Direction cp : Direction.values()) {
			if (angle == cp.getAngle()) {return cp;}
		}
		return null;
	}

	//Generates random direction
	public static Direction getRandomDirection(){
		Random r = new Random();
		float x = r.nextFloat();
		if (x < 0.25) {return Direction.N;}
		else if (x < 0.5) {return Direction.E;}
		else if (x < 0.75) {return Direction.S;}
		else {return Direction.W;}
	}

	public int getAngle() {
		return angle;
	}

	public String getAbbr() {
		return abbr;
	}
}
