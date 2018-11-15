package hiq.classic.codetest;

public class Simulator {
	
	private int[][] room;
	private String commands;
	
	public Simulator(int size1, int size2, String commands) {
		this.setRoom(new int[size1][size2]);	
		this.commands = commands;
	}
	
	public boolean startSimulation(Car car) {
		
		for(int i = 0; i < this.getCommands().length();i++) {
			char specificCommand = this.commands.charAt(i);
			
			if(specificCommand == 'F' && car.getHeading() == "N") {
				movingForwardHeadingNorth(car);
			}			
			else if(specificCommand == 'F' && car.getHeading() == "E") {
				movingForwardHeadingEast(car);				
			}			
			else if(specificCommand == 'F' && car.getHeading() == "S") {
				movingForwardHeadingSouth(car);
			}			
			else if(specificCommand == 'F' && car.getHeading() == "W") {
				movingForwardHeadingWest(car);
			}
			
			else if(specificCommand == 'B' && car.getHeading() == "N") {
				movingBackwardsHeadingNorth(car);
			}
			else if(specificCommand == 'F' && car.getHeading() == "E") {
				movingBackwardsHeadingEast(car);				
			}			
			else if(specificCommand == 'F' && car.getHeading() == "S") {
				movingBackwardsHeadingSouth(car);
			}			
			else if(specificCommand == 'F' && car.getHeading() == "W") {
				movingBackwardsHeadingWest(car);
			}			
			
			else if(specificCommand == 'L') {
				rotateLeft(car);
			}
			
			else if(specificCommand == 'R') {
				rotateRight(car);
			}
			
			System.out.println("Commando: " + specificCommand + 
					" X: " + car.getCurrentPositionAtX() + 
					" Y: " + car.getCurrentPositionAtY());	
			
		}
		
		return false;
	}
	
	public void movingForwardHeadingNorth(Car car) {
		car.setCurrentPositionAtY(car.getCurrentPositionAtY() + 1);
	}
	
	public void movingForwardHeadingEast(Car car) {
		car.setCurrentPositionAtX(car.getCurrentPositionAtX() + 1);
	}
	
	public void movingForwardHeadingSouth(Car car) {
		car.setCurrentPositionAtX(car.getCurrentPositionAtY() - 1);
	}
	
	public void movingForwardHeadingWest(Car car) {
		car.setCurrentPositionAtY(car.getCurrentPositionAtX() - 1);
	}
	
	public void movingBackwardsHeadingNorth(Car car) {
		car.setCurrentPositionAtY(car.getCurrentPositionAtY() - 1);
	}
	
	public void movingBackwardsHeadingEast(Car car) {
		car.setCurrentPositionAtY(car.getCurrentPositionAtX() - 1);
	}
	
	public void movingBackwardsHeadingSouth(Car car) {
		car.setCurrentPositionAtX(car.getCurrentPositionAtY() + 1);
	}
	
	public void movingBackwardsHeadingWest(Car car) {
		car.setCurrentPositionAtY(car.getCurrentPositionAtX() + 1);
	}
	
	public void rotateLeft(Car car) {
		try {
			int degrees = Integer.parseInt(
					car.getDegreesFromCardinalDirections(car.getHeading()));
			System.out.println("dd" + degrees);
			degrees -= 90;
			car.setHeading(car.getCardinalDirections().get(degrees + ""));
			System.out.println("Novo heading: " + car.getHeading() + " ");
		}catch(NumberFormatException numberFormatException){
			System.out.println("Degrees are not a valid number");
			System.exit(0);
		}
	}
	
	public void rotateRight(Car car) {
		try {
			int degrees = Integer.parseInt(
				car.getDegreesFromCardinalDirections(car.getHeading()));
			if(degrees == 360) {
				degrees = 0;
			}
			degrees += 90;
			car.setHeading(car.getCardinalDirections().get(degrees + ""));
			System.out.println("Novo heading: " + car.getHeading() + " ");
		}catch(NumberFormatException numberFormatException){
			System.out.println("Degrees are not a valid number");
			System.exit(0);
		}
	}
	
	public void checkIfDroveIntoTheWall(int positionAfterMoveAtX, int positionAfterMoveAtY) {
		this.getRoom()[positionAfterMoveAtX][positionAfterMoveAtY] = 1;
		System.out.print("Teste");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public int[][] getRoom() {
		return room;
	}

	public void setRoom(int[][] room) {
		this.room = room;
	}

	public String getCommands() {
		return commands;
	}

	public void setCommands(String commands) {
		this.commands = commands;
	}
	
	

}
