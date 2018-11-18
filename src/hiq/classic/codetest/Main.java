package hiq.classic.codetest;

import java.util.Scanner;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int firstSizeRoom;
		int secondSizeRoom;
		String commands;
		
		int valuesOfDimensionRoom[] = new int[2];
		valuesOfDimensionRoom = enterAndCheckParametersSizeRoom();
		firstSizeRoom = valuesOfDimensionRoom[0];
		secondSizeRoom = valuesOfDimensionRoom[1];
		
		Car car = enterAndCheckCarParameters(firstSizeRoom,secondSizeRoom);
		
		commands = enterAndCheckCommands();

		Simulator simulator = new Simulator(firstSizeRoom,secondSizeRoom, commands, car);	
		String resultOfTheSimulation = simulator.startSimulation();
		System.out.println(resultOfTheSimulation);	
		
		scanner.close();		
	}
	
	public static int[] enterAndCheckParametersSizeRoom() {
		
		int firstSizeRoom = 0;
		int secondSizeRoom = 0;
		int valuesOfDimensionRoom[] = new int[2];
		boolean incorrectInputSizeRoom =  true;
		
		while(incorrectInputSizeRoom == true) {
			System.out.println("Enter room size: ");
			String sizeOfTheRoom[] = scanner.nextLine().split(" ");
			
			if(sizeOfTheRoom.length == 2) {
				try {			
					firstSizeRoom = Integer.parseInt(sizeOfTheRoom[0]);
					secondSizeRoom = Integer.parseInt(sizeOfTheRoom[1]);
					if(firstSizeRoom >= 1 && secondSizeRoom >= 1) {
						valuesOfDimensionRoom[0] = firstSizeRoom;
						valuesOfDimensionRoom[1] = secondSizeRoom;
						incorrectInputSizeRoom = false;
					}
					else {
						System.out.println("The size of the room needs to be greater than 0");
					}
				}catch(NumberFormatException numberFormatException) {
					System.out.println("Parameters need to be numbers");
				}
			}else {
				System.out.println("Number of parameters incorrect");
			} 
		}
		
		return valuesOfDimensionRoom;
	}
	
	public static Car enterAndCheckCarParameters(int firstSizeRoom, int secondSizeRoom) {
		
		int initialPositionAtX;
		int initialPositionAtY;
		String initialHeading;
		Car car = null;
		boolean incorrectPositionHeadingCar = true;
		
		while(incorrectPositionHeadingCar == true) {
			System.out.println("Enter the starting position and heading of the car:");
			String positionHeading[] = scanner.nextLine().split(" ");
			
			if(positionHeading.length == 3) {
				try {			
					initialPositionAtX = Integer.parseInt(positionHeading[0]);
					initialPositionAtY = Integer.parseInt(positionHeading[1]);
					initialHeading = positionHeading[2].toUpperCase();
			
					if(initialPositionAtX >= 0 && initialPositionAtX < firstSizeRoom && 
							initialPositionAtY >= 0 && initialPositionAtY < secondSizeRoom) {					
						if(initialHeading.length() == 1) {
							if(initialHeading.equals("N") || initialHeading.equals("S") || 
								initialHeading.equals("E") || initialHeading.equals("W")) {
							
								car = new Car("Monster Trucks",initialHeading,
									initialPositionAtX,initialPositionAtY);	
	
								incorrectPositionHeadingCar = false;
							}else {
								System.out.println("The value: " + initialHeading + 
									" is not valid as a heading");
							}						
						}else {
							System.out.println("The heading must have a maximum 1 character");
						}
					}else {
						System.out.println("The car is not in the room");	
					}								
				}catch(NumberFormatException numberFormatException){
					System.out.println("Incorrect parameters. Try again. Example: 0 0 N");
				}
			}else {
				System.out.println("Number of parameters incorrect");
			}
		}
		
		return car;
	}

	public static String enterAndCheckCommands() {
		String commands = "";
		boolean incorrectCommands = true;
		
		while(incorrectCommands == true) {
			System.out.println("Enter the sequence of commands: ");
			commands = scanner.nextLine().toUpperCase();
			if(commands.length() > 0) {
				for(int i = 0; i< commands.length(); i++) {
					char letter = commands.charAt(i);
					if(letter != 'F' && letter != 'B' && 
						letter != 'R' && letter != 'L' ) {
						System.out.println("Just the commands FRLB are acceptable");
						incorrectCommands = true;
						break;
					}else {
						incorrectCommands = false;
					}					
				}
			}else {
				System.out.println("At least one command has to be enter");
			}
		}
		
		return commands;
	}
}
