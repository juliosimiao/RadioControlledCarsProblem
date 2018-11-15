package hiq.classic.codetest;

public class Simulator {
	
	private int[][] room;
	private String commands;
	
	public Simulator(int size1, int size2, String commands) {
		this.setRoom(new int[size1][size2]);	
		this.commands = commands;
	}
	
	public boolean startSimulation(Car car) {
		
		boolean isDrivingIntoTheWall = false;
		
		for(int i = 0; i < this.getCommands().length();i++) {
			char specificCommand = this.commands.charAt(i);
			
			if(specificCommand == 'F' && car.getHeading() == "N") {
				isDrivingIntoTheWall = movingForwardHeadingNorth(car);
				if(isDrivingIntoTheWall == true) {
					return false;
				}
			}			
			else if(specificCommand == 'F' && car.getHeading() == "E") {
				isDrivingIntoTheWall = movingForwardHeadingEast(car);
				if(isDrivingIntoTheWall == true) {
					return false;
				}
			}			
			else if(specificCommand == 'F' && car.getHeading() == "S") {
				isDrivingIntoTheWall = movingForwardHeadingSouth(car);
				if(isDrivingIntoTheWall == true) {
					return false;
				}
			}			
			else if(specificCommand == 'F' && car.getHeading() == "W") {
				isDrivingIntoTheWall = movingForwardHeadingWest(car);
				if(isDrivingIntoTheWall == true) {
					return false;
				}
			}
			
			else if(specificCommand == 'B' && car.getHeading() == "N") {
				isDrivingIntoTheWall = movingBackwardsHeadingNorth(car);
				if(isDrivingIntoTheWall == true) {
					return false;
				}
			}
			else if(specificCommand == 'F' && car.getHeading() == "E") {
				isDrivingIntoTheWall = movingBackwardsHeadingEast(car);
				if(isDrivingIntoTheWall == true) {
					return false;
				}
			}			
			else if(specificCommand == 'F' && car.getHeading() == "S") {
				isDrivingIntoTheWall = movingBackwardsHeadingSouth(car);
				if(isDrivingIntoTheWall == true) {
					return false;
				}
			}			
			else if(specificCommand == 'F' && car.getHeading() == "W") {
				isDrivingIntoTheWall = movingBackwardsHeadingWest(car);
				if(isDrivingIntoTheWall == true) {
					return false;
				}
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
		
		return true;
	}
	
	public boolean movingForwardHeadingNorth(Car car) {
		car.setCurrentPositionAtY(car.getCurrentPositionAtY() + 1);
		return checkIfDroveIntoTheWall(car.getCurrentPositionAtX(),
				car.getCurrentPositionAtY());
	}
	
	public boolean movingForwardHeadingEast(Car car) {
		car.setCurrentPositionAtX(car.getCurrentPositionAtX() + 1);
		return checkIfDroveIntoTheWall(car.getCurrentPositionAtX(),
				car.getCurrentPositionAtY());
	}
	
	public boolean movingForwardHeadingSouth(Car car) {
		car.setCurrentPositionAtX(car.getCurrentPositionAtX() - 1);
		return checkIfDroveIntoTheWall(car.getCurrentPositionAtX(),
				car.getCurrentPositionAtY());
	}
	
	public boolean movingForwardHeadingWest(Car car) {
		car.setCurrentPositionAtX(car.getCurrentPositionAtX() - 1);
		return checkIfDroveIntoTheWall(car.getCurrentPositionAtX(),
				car.getCurrentPositionAtY());
	}
	
	public boolean movingBackwardsHeadingNorth(Car car) {
		car.setCurrentPositionAtY(car.getCurrentPositionAtY() - 1);
		return checkIfDroveIntoTheWall(car.getCurrentPositionAtX(),
				car.getCurrentPositionAtY());
	}
	
	public boolean movingBackwardsHeadingEast(Car car) {
		car.setCurrentPositionAtY(car.getCurrentPositionAtY() - 1);
		return checkIfDroveIntoTheWall(car.getCurrentPositionAtX(),
				car.getCurrentPositionAtY());
	}
	
	public boolean movingBackwardsHeadingSouth(Car car) {
		car.setCurrentPositionAtX(car.getCurrentPositionAtX() + 1);
		return checkIfDroveIntoTheWall(car.getCurrentPositionAtX(),
				car.getCurrentPositionAtY());
	}
	
	public boolean movingBackwardsHeadingWest(Car car) {
		car.setCurrentPositionAtY(car.getCurrentPositionAtY() + 1);
		return checkIfDroveIntoTheWall(car.getCurrentPositionAtX(),
				car.getCurrentPositionAtY());
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
	
	public boolean checkIfDroveIntoTheWall(int positionAfterMoveAtX, int positionAfterMoveAtY) {
		
		if(positionAfterMoveAtX > this.getRoom().length || positionAfterMoveAtX < 0) {
			return true;
		}
		if(positionAfterMoveAtY > this.getRoom()[1].length || positionAfterMoveAtY < 0) {
			return true;
		}  
		
		return false;	
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
