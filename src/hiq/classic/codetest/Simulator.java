package hiq.classic.codetest;

public class Simulator {
	
	private int[][] room;
	private String commands;
	private Car car;
	
	public Simulator(int sizeX, int sizeY, String commands, Car car) {
		this.setRoom(new int[sizeX][sizeY]);	
		this.commands = commands;
		this.car = car;
	}
	
	public String startSimulation() {
		
		boolean isDrivingIntoTheWall = false;
		char specificCommand = 'X';
		
		for(int i = 0; i < this.getCommands().length();i++) {
			specificCommand = this.commands.charAt(i);
			
			if(specificCommand == 'F' && car.getHeading().equals("N")) {
				isDrivingIntoTheWall = movingForwardHeadingNorth();
				if(isDrivingIntoTheWall == true) {
					return printResultSimulation(isDrivingIntoTheWall, specificCommand);
				}
			}			
			else if(specificCommand == 'F' && car.getHeading().equals("E")) {
				isDrivingIntoTheWall = movingForwardHeadingEast();
				if(isDrivingIntoTheWall == true) {
					return printResultSimulation(isDrivingIntoTheWall, specificCommand);
				}
			}			
			else if(specificCommand == 'F' && car.getHeading().equals("S")) {
				isDrivingIntoTheWall = movingForwardHeadingSouth();
				if(isDrivingIntoTheWall == true) {
					return printResultSimulation(isDrivingIntoTheWall, specificCommand);
				}
			}			
			else if(specificCommand == 'F' && car.getHeading().equals("W")) {
				isDrivingIntoTheWall = movingForwardHeadingWest();
				if(isDrivingIntoTheWall == true) {
					return printResultSimulation(isDrivingIntoTheWall, specificCommand);
				}
			}
			
			else if(specificCommand == 'B' && car.getHeading().equals("N")) {
				isDrivingIntoTheWall = movingBackwardsHeadingNorth();
				if(isDrivingIntoTheWall == true) {
					return printResultSimulation(isDrivingIntoTheWall, specificCommand);
				}
			}
			else if(specificCommand == 'B' && car.getHeading().equals("E")) {
				isDrivingIntoTheWall = movingBackwardsHeadingEast();
				if(isDrivingIntoTheWall == true) {
					return printResultSimulation(isDrivingIntoTheWall, specificCommand);
				}
			}			
			else if(specificCommand == 'B' && car.getHeading().equals("S")) {
				isDrivingIntoTheWall = movingBackwardsHeadingSouth();
				if(isDrivingIntoTheWall == true) {
					return printResultSimulation(isDrivingIntoTheWall, specificCommand);
				}
			}			
			else if(specificCommand == 'B' && car.getHeading().equals("W")) {
				isDrivingIntoTheWall = movingBackwardsHeadingWest();
				if(isDrivingIntoTheWall == true) {
					return printResultSimulation(isDrivingIntoTheWall, specificCommand);
				}
			}			
			
			else if(specificCommand == 'L') {
				rotateLeft();
			}
			
			else if(specificCommand == 'R') {
				rotateRight();
			}		
		}
		
		return printResultSimulation(isDrivingIntoTheWall, specificCommand);

	}
	
	public boolean movingForwardHeadingNorth() {		
		this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
		this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());
		
		this.car.setCurrentPositionAtY(this.car.getCurrentPositionAtY() + 1);
		
		return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
				this.car.getCurrentPositionAtY());
	}
	
	public boolean movingForwardHeadingEast() {		
		this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
		this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());
		
		this.car.setCurrentPositionAtX(this.car.getCurrentPositionAtX() + 1);
		return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
				this.car.getCurrentPositionAtY());
	}
	
	public boolean movingForwardHeadingSouth() {		
		this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
		this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());

		this.car.setCurrentPositionAtY(this.car.getCurrentPositionAtY() - 1);
		return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
				this.car.getCurrentPositionAtY());
	}
	
	public boolean movingForwardHeadingWest() {		
		this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
		this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());

		this.car.setCurrentPositionAtX(this.car.getCurrentPositionAtX() - 1);
		return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
				this.car.getCurrentPositionAtY());
	}
	
	public boolean movingBackwardsHeadingNorth() {		
		this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
		this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());
		
		this.car.setCurrentPositionAtY(this.car.getCurrentPositionAtY() - 1);
		return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
				this.car.getCurrentPositionAtY());
	}
	
	public boolean movingBackwardsHeadingEast() {		
		this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
		this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());
		
		this.car.setCurrentPositionAtX(this.car.getCurrentPositionAtX() - 1);
		return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
				this.car.getCurrentPositionAtY());
	}
	
	public boolean movingBackwardsHeadingSouth() {		
		this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
		this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());
		
		this.car.setCurrentPositionAtY(this.car.getCurrentPositionAtY() + 1);
		return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
				this.car.getCurrentPositionAtY());
	}
	
	public boolean movingBackwardsHeadingWest() {		
		this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
		this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());
		
		this.car.setCurrentPositionAtX(this.car.getCurrentPositionAtX() + 1);
		return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
				this.car.getCurrentPositionAtY());
	}
	
	public void rotateLeft() {
		try {
			int degrees = Integer.parseInt(
				this.car.getDegreesFromCardinalDirections(this.car.getHeading()));
			degrees -= 90;
			this.car.setHeading(this.car.getCardinalDirections().get(degrees + ""));
		}catch(NumberFormatException numberFormatException){
			System.out.println("Degrees are not a valid number");
			System.exit(0);
		}
	}
	
	public void rotateRight() {
		try {
			int degrees = Integer.parseInt(
				this.car.getDegreesFromCardinalDirections(this.car.getHeading()));
			if(degrees == 360) {
				degrees = 0;
			}
			degrees += 90;
			this.car.setHeading(this.car.getCardinalDirections().get(degrees + ""));
		}catch(NumberFormatException numberFormatException){
			System.out.println("Degrees are not a valid number");
			System.exit(0);
		}
	}
	
	public boolean checkIfDroveIntoTheWall(int positionAfterMoveAtX, int positionAfterMoveAtY) {		
		if(positionAfterMoveAtX >= this.getRoom().length || positionAfterMoveAtX < 0) {			
			return true;
		}
		if(positionAfterMoveAtY >= this.getRoom()[1].length || positionAfterMoveAtY < 0) {
			return true;
		}  
		
		return false;	
	}
	
	public String printResultSimulation(boolean isDrivingIntoTheWall, char lastCommand) {
		
		String command = "";
		
		if(lastCommand == 'F') {
			command = "Forwand";
		}
		if(lastCommand == 'B') {
			command = "Backwards";
		}
		
		if(!isDrivingIntoTheWall) {
			return "Successful - The car finished at position: ["+
					this.car.getCurrentPositionAtX()+ "," + this.car.getCurrentPositionAtY() +
					"] - Heading to the: " + this.car.getHeading();
		}else {
			return "Unsuccessful - The car was at position: ["+
					this.car.getLastPositionAtX() + "," + this.car.getLastPositionAtY() +
					"] heading to the " + this.car.getHeading() + 
					" and tried to go " + command + " and hitted the wall";
		}			
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
