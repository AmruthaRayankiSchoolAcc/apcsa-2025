package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// you start with 1 for squareCount because when you start the program robot is inside first square
	int squareCount = 1;
	int totalBeepers = 0;
	int totalPiles = 0;
	int maximumBeepersPerPile = 0;
	int largestPile = 0;
	// largestPileLocation (street and avenue)
	int largestPileStreet = 0;
	int largestPileAvenue = 0;
	boolean needToCleanMore = true;

	// Main method to make this self-contained
	public static void main(String[] args) {
		// String worldName = "robot/basicRoom.wld";
		// String worldName = "robot/TestWorld-1.wld";
		// String worldName = "robot/TestWorld-2.wld";
		String worldName = "robot/finalTestWorld2024.wld";

		Roomba cleaner = new Roomba();
		// int totalBeepers = cleaner.cleanRoom(worldName, 7, 6); for basicRoom
		// int totalBeepers = cleaner.cleanRoom(worldName, 25 , 11); for TestWorld-1
		// int totalBeepers = cleaner.cleanRoom(worldName, 5, 6); for TestWorld-2
		int totalBeepers = cleaner.cleanRoom(worldName, 26, 101); // coordinates for final world
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");
	}

	// function for cleaning the row
	public void cleanRow(Robot r) {
		while(r.frontIsClear()) {
			r.move();
			squareCount++;
			if (r.nextToABeeper()) {
				int totalBeepersPerPile = 0;
				while(r.nextToABeeper()) {
					r.pickBeeper();
					totalBeepers++;
					totalBeepersPerPile++;
				}
				totalPiles++;
				System.out.println("Pile " + totalPiles + " has " + totalBeepersPerPile + " beepers.");
				if (maximumBeepersPerPile < totalBeepersPerPile) {
					maximumBeepersPerPile = totalBeepersPerPile;
					largestPile = totalPiles;
					// location of largest pile
					largestPileStreet = r.street();
					largestPileAvenue = r.avenue();
				}
			}
		}
	}

	// function for turning left to move to next row 
	public void turnByLeft(Robot r) {
		r.turnLeft();
		if (r.frontIsClear()) {
			r.move();
			squareCount++;
		} else {
			needToCleanMore = false;
		}
		r.turnLeft();
	}
	
	// function for turning right to move to next row
	public void turnByRight(Robot r) {
		r.turnLeft();
		r.turnLeft();
		r.turnLeft();
		if (r.frontIsClear()) {
			r.move();
			squareCount++;
		} else {
			needToCleanMore = false;
		}
		r.turnLeft();
		r.turnLeft();
		r.turnLeft();
	}

	public int cleanRoom(String worldName, int startX, int startY) {

        // Make sure it starts at startX and startY location.
		Robot robot = new Robot(startX, startY, East, 0);

		//creates the world for the robot to clean
		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(0);

		// main code for robot to move through the world
		while (needToCleanMore) {
			if (robot.frontIsClear()) {
				cleanRow(robot);
			}
			if (robot.facingEast()) {
				turnByLeft(robot);
			}
			else { // robot.facingWest()
				turnByRight(robot);
			}
		}

		System.out.println("Total number of piles: " + totalPiles);
		System.out.println(largestPile + " is the largest pile in the total number of piles " + totalPiles);
		System.out.println("Largest pile has " + maximumBeepersPerPile + " beepers");
		System.out.println("Largest pile location is " + "street " + largestPileStreet + " avenue " + largestPileAvenue);
		System.out.println("Area is " + squareCount);
        // This method should return the total number of beepers cleaned up.
		return totalBeepers;
	}
}
