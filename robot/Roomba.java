package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	int totalBeepers = 0;

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/basicRoom.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// function for cleaning the row
	public void cleanRow(Robot r) {
		while(r.frontIsClear()) {
			r.move();
			while(r.nextToABeeper()) {
				r.pickBeeper();
				totalBeepers++;
			}
		}
	}

	// function for turning left to move to next row 
	public void turnByLeft(Robot r) {
		r.turnLeft();
		r.move();
		r.turnLeft();
	}
	
	// function for turning right to move to next row
	public void turnByRight(Robot r) {
		r.turnLeft();
		r.turnLeft();
		r.turnLeft();
		r.move();
		r.turnLeft();
		r.turnLeft();
		r.turnLeft();
	}

	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.
		Robot robot = new Robot(startX, startY, South, 0);

		//creates the world for the robot to clean
		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(10);

		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		// robot start moving
		robot.turnLeft(); 
		cleanRow(robot);
		turnByLeft(robot);
		cleanRow(robot);
		turnByRight(robot);
		cleanRow(robot);
		turnByLeft(robot);
		cleanRow(robot);
		turnByRight(robot);
		cleanRow(robot);
		
        // This method should return the total number of beepers cleaned up.
		return totalBeepers;
	}
}
