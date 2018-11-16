package hiq.classic.codetest;

import java.util.HashMap;
import java.util.Map;

public class Car {
	
	private String carModel;
	private String heading;
	private int lastPositionAtX;
	private int lastPositionAtY;
	private int currentPositionAtX;
	private int currentPositionAtY;
	
	Map<String,String> cardinalDirections = new HashMap<String,String>()
			{{
				put("N","360");
				put("S","180");
				put("E","90");
				put("W","270");
				
				put("360","N");
				put("0","N");
				put("180","S");
				put("90","E");
				put("270","W");
			}};
	
	public Car(String carModel, String heading, int currentPositionAtX, 
			int currentPositionAtY) {
		this.carModel = carModel;
		this.heading = heading;
		this.currentPositionAtX = currentPositionAtX;
		this.currentPositionAtY = currentPositionAtY;
		this.lastPositionAtX = currentPositionAtX;
		this.lastPositionAtY = currentPositionAtY;
	}
	
	public String getDegreesFromCardinalDirections(String key) {
		return this.cardinalDirections.get(key);
	}	

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public int getCurrentPositionAtX() {
		return currentPositionAtX;
	}

	public void setCurrentPositionAtX(int currentPositionAtX) {
		this.currentPositionAtX = currentPositionAtX;
	}

	public int getCurrentPositionAtY() {
		return currentPositionAtY;
	}

	public void setCurrentPositionAtY(int currentPositionAtY) {
		this.currentPositionAtY = currentPositionAtY;
	}

	public Map<String, String> getCardinalDirections() {
		return cardinalDirections;
	}

	public void setCardinalDirections(Map<String, String> cardinalDirections) {
		this.cardinalDirections = cardinalDirections;
	}

	public int getLastPositionAtX() {
		return lastPositionAtX;
	}

	public void setLastPositionAtX(int lastPositionAtX) {
		this.lastPositionAtX = lastPositionAtX;
	}

	public int getLastPositionAtY() {
		return lastPositionAtY;
	}

	public void setLastPositionAtY(int lastPositionAtY) {
		this.lastPositionAtY = lastPositionAtY;
	}		
	
	
	
	
	
	
}
