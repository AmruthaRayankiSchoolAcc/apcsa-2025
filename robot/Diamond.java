package robot;
import kareltherobot.*;


public class Diamond implements Directions{

    public static void turnRight(Robot r){
        for (int i = 0; i<3; i++) {
            r.turnLeft();
        }
    }

    public static void main(String[] args) {

        World.setVisible(true);// allows us to see the run output
        // the bigger the street, the farther north
        World.setSize(20,20);
        World.setDelay(20);


        // The line below creates a Robot that we will refer to as rob
        // Find out what the numbers and direction do!
        // Put rob in a better location for your initials.
        Robot rob = new Robot(15,2,South,20);

        // Want a second robot?  No prob.  They are cheap :)
        //Robot dude = new Robot(7,5,West,9);
        // examples of commands you can invoke on a Robot
        //rob.move();// move one step in the direction it is facing

        rob.putBeeper();
        for (int i = 0; i < 2; i++) {
            rob.move();
            rob.turnLeft();
            rob.move();
            rob.putBeeper();
            Diamond.turnRight(rob);
        }
        for (int i = 0; i < 2; i++) {
            rob.move();
            rob.turnLeft();
            rob.move();
            rob.putBeeper();
        }
        rob.move();
        Diamond.turnRight(rob);
        rob.move();
        rob.putBeeper();
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        //top sides
        for (int i = 0; i < 2; i++) {
            rob.move();
            rob.turnLeft();
            rob.move();
            rob.putBeeper();
            Diamond.turnRight(rob);
        }
        for (int i = 0; i < 2; i++) {
            rob.move();
            rob.turnLeft();
            rob.move();
            rob.putBeeper();
        }
        Diamond.turnRight(rob);
        rob.move();
        rob.turnLeft();
        rob.move();
        rob.putBeeper();
        rob.move();


    }
}
