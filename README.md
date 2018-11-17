# Simulator for radio controlled cars
This project is a simulator for radio controlled cars developed using Java.

## Getting Started
The simulator test various commands and see if the radio controlled cars can execute them without hitting the wall. The simulator is a console application.

The commands that the simulator accept is forward, back, left and right. Forward make the car move forward 1 meter, back make the car move backwards 1 meter, left rotate the car 90° counterclockwise and right rotate the car 90° clockwise.

The simulated environment is a room. The room size is in whole meters (no decimals). The simulated car is treated as a round object with 1 meter in diameter.

The image below shows all possible positions in a 4 meters wide and 4 meters long room, the highlighted coordinate [0,0] is the most southwest point in which the car will fit.

<img src="https://files.fm/thumb_show.php?i=bemyb6je&view" width="150" alt="Example of the room">

After the simulation the simulator outputs the result of the simulation. The result can either be successful (everything went ok) or unsuccessful (the car drove into the wall).

## Running the tests
The system will ask you the size of the room.
  *This is inputted with two integers separated with a space.
The system will ask you the user start position and a heading of the car.
  *This is inputted with two integers and one letter separated with spaces. The letter can be N, S, W or E. 
The system will ask the user about the commands to execute.
  *This is inputted with all commands in series. Available commands are F, B, L or R.
  
In case of incorrect inputs the system will display an error message and you will be able to enter a new input again. The upper and lower case letter inputs are accepted.

Sample input:
```
8 6
2 3 N
FFFRFFLBB
```
Sample output:
```
Unsuccessful - The car was at position: [2,5] heading to the N and tried to go Forward and hitted the wall
```
## Built With
* Eclipse - The IDE for development.
* Linux - The platform used.

## Author

* **Júlio Simião**




