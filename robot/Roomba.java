package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/basicRoom.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	//private Robot robot;

	// You will need to add many variables!!


	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.
		Robot robot = new Robot(startX, startY, South, 0);

		//creates the world for the robot to clean
		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(10);

		int totalBeepers = 0; // Need to move this somewhere else.

		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */
		// robot start moving
		robot.turnLeft(); 
		// repeating code: function to clear the row
		while(robot.frontIsClear()) {
			robot.move();
			while(robot.nextToABeeper()) {
				robot.pickBeeper();
				totalBeepers++;
			}
		}
		// in-between while loop, the code for robot to move to next row when turning left
		robot.turnLeft();
		robot.move();
		robot.turnLeft();
		// repeating code: function to clear the row
		while(robot.frontIsClear()) {
			robot.move();
			while(robot.nextToABeeper()) {
				robot.pickBeeper();
				totalBeepers++;
			}
		}
		// code for robot to move to next row when turning right
		robot.turnLeft();
		robot.turnLeft();
		robot.turnLeft();
		robot.move();
		robot.turnLeft();
		robot.turnLeft();
		robot.turnLeft();
		// repeating code: function to clear the row
		while(robot.frontIsClear()) {
			robot.move();
			while(robot.nextToABeeper()) {
				robot.pickBeeper();
				totalBeepers++;
			}
		}
		// code for robot to move to next row moving left
		robot.turnLeft();
		robot.move();
		robot.turnLeft();
		// repeating code: function to clear the row
		while(robot.frontIsClear()) {
			robot.move();
			while(robot.nextToABeeper()) {
				robot.pickBeeper();
				totalBeepers++;
			}
		}
		// code for robot to move to next row when turning right
		robot.turnLeft();
		robot.turnLeft();
		robot.turnLeft();
		robot.move();
		robot.turnLeft();
		robot.turnLeft();
		robot.turnLeft();
		// repeating code: function to clear the row
		while(robot.frontIsClear()) {
			robot.move();
			while(robot.nextToABeeper()) {
				robot.pickBeeper();
				totalBeepers++;
			}
		}



        // This method should return the total number of beepers cleaned up.
		return totalBeepers;
	}
}
