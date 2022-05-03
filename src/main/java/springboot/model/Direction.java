package springboot.model;

import java.util.Random;

/**
 * Model enum denoting the 4 possible directions in cardinal space
 */
public enum Direction {
	N(0, "N"), S(180,"S"), E(90,"E"), W(270,"W");
	
	final private int angle;
	final private String abbr;

	/**
	 * Enum constructor based on given angle and it's abbreviate name
	 */
	Direction(int angle, String abbr) {
		this.angle = angle;
		this.abbr = abbr;
	}

	/**
	 * Method to obtain the cardinal direction based on abbreviate character
	 * @return Direction object
	 */
	public static Direction getCardinalPointChar(String c) {
		for (Direction cp : Direction.values()) {
			if (c.equals(cp.getAbbr())) {return cp;}
		}
		return null;
	}

	/**
	 * Method to obtain cardinal direction based on given angle
	 * @return Direction object
 	 * @throws Exception
	 */
	public static Direction getCardinalPointByAngle(int angle) throws Exception {
		for (Direction cp : Direction.values()) {
			if (angle % 360 == cp.getAngle()) {return cp;}
		}
		throw new Exception("Angle"+angle+"not found in directions");
	}

	/**
	 * Method to generate a random direction
	 * @return Direction object
	 */
	public static Direction getRandomDirection(){
		Random r = new Random();
		float x = r.nextFloat();
		if (x < 0.25) {return Direction.N;}
		else if (x < 0.5) {return Direction.E;}
		else if (x < 0.75) {return Direction.S;}
		else {return Direction.W;}
	}

	/**
	 * Angle Getter
	 */
	public int getAngle() {
		return angle;
	}

	/**
	 * Abbreviation Getter
	 */
	public String getAbbr() {
		return abbr;
	}
}
