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
		String commands;
		
		/*
		System.out.println("Enter room size: ");
		String sizeOfTheRoom[] = scanner.nextLine().split(" ");
		
		try {			
			firstSizeRoom = Integer.parseInt(sizeOfTheRoom[0]);
			secondSizeRoom = Integer.parseInt(sizeOfTheRoom[1]);
		}catch(NumberFormatException numberFormatException) {
			System.out.println("Parameters are not numbers");
			System.exit(0);
		}
		catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBounds) {
			System.out.println("Number of parameters incorrect");
			System.exit(0);
		}
		
		System.out.println("Enter the starting position and heading of the car:");
		String positionHeading[] = scanner.nextLine().split(" ");
		
		try {
			
			initialPositionAtX = Integer.parseInt(positionHeading[0]);
			initialHeading = positionHeading[2];
			initialPositionAtY = Integer.parseInt(positionHeading[1]);
			
			if(initialPositionAtX <= firstSizeRoom && 
					initialPositionAtY <= secondSizeRoom) {
				Car car = new Car("Monster Trucks",initialHeading,
						initialPositionAtX,initialPositionAtX);			
			}else {
				System.out.println("The car is not in the room");
				System.exit(0);				
			}								
		}catch(NumberFormatException numberFormatException){
			System.out.println("Parameters are not numbers");
			System.exit(0);
		}catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBounds) {
			System.out.println("Number of parameters incorrect");
			System.exit(0);
		}
		
		System.out.println("Enter the sequence of commands: ");
		commands = scanner.nextLine();
		for(int i = 0; i< commands.length(); i++) {
			char letter = commands.charAt(i);
			if(letter != 'F' && letter != 'B' && 
					letter != 'R' && letter != 'L' ) {
				System.out.println("One of the commands are not acceptable");
				System.exit(0);
			}
		}
		
		Simulator simulator = new Simulator(firstSizeRoom,secondSizeRoom, commands);	
		*/
		
		Car car = new Car("Monster Trucks","N",2,3);
		Simulator simulator = new Simulator(8,6,"FFFRFFLBB");
		simulator.startSimulation(car);
		
		
		
		
	}

}
