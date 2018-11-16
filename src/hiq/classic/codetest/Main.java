package hiq.classic.codetest;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int firstSizeRoom = -1;
		int secondSizeRoom = -1;
		int initialPositionAtX;
		int initialPositionAtY;
		String initialHeading;
		String commands = "";
		Car car = null;
		boolean incorrectInputSizeRoom = true;
		boolean incorrectPositionHeadingCar = true;
		boolean incorrectCommands = true;
		
		while(incorrectInputSizeRoom == true) {
			System.out.println("Enter room size: ");
			String sizeOfTheRoom[] = scanner.nextLine().split(" ");
		
			try {			
				firstSizeRoom = Integer.parseInt(sizeOfTheRoom[0]);
				secondSizeRoom = Integer.parseInt(sizeOfTheRoom[1]);
				incorrectInputSizeRoom = false;
			}catch(NumberFormatException numberFormatException) {
				System.out.println("Parameters are not numbers");
			}catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBounds) {
				System.out.println("Number of parameters incorrect\n");
			}
		} 
		
		while(incorrectPositionHeadingCar == true) {
			System.out.println("Enter the starting position and heading of the car:");
			String positionHeading[] = scanner.nextLine().split(" ");
		
			try {			
				initialPositionAtX = Integer.parseInt(positionHeading[0]);
				initialPositionAtY = Integer.parseInt(positionHeading[1]);
				initialHeading = positionHeading[2].toUpperCase();
			
				if(initialPositionAtX <= firstSizeRoom && 
					initialPositionAtY <= secondSizeRoom) {					
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
				System.out.println("One of the parameters are not numbers");
			}catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBounds) {
				System.out.println("Number of parameters incorrect");
			}
		}
		
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

		Simulator simulator = new Simulator(firstSizeRoom,secondSizeRoom, commands, car);	
		String resultOfTheSimulation = simulator.startSimulation();
		System.out.println(resultOfTheSimulation);	
		
		scanner.close();		
	}

}
