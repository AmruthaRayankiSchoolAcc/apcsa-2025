package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        // TODO: Add a point to the IrregularPolygon.
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        // TODO: Calculate the perimeter.
        double perimeter = 0.0;
        int points = myPolygon.size();

        if (points < 2) return 0.0;

        for (int i = 0; i < points; i++) {
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next = myPolygon.get((i + 1) % points); // Connects last back to first
            
            perimeter += current.distance(next);
        }
        
        return perimeter;
    }

    public double area() {
        // TODO: Calculate the area.
        double area = 0.0;
        int points = myPolygon.size();
        
        if (points < 3) { 
            return 0.0; 
        }

        for (int i = 0; i < points; i++) {
            Point2D.Double p1 = myPolygon.get(i);
            Point2D.Double p2 = myPolygon.get((i + 1) % points);
            
            // Use getter methods instead of .x and .y
            area += (p1.getX() * p2.getY()) - (p1.getY() * p2.getX());
        }

        return Math.abs(area / 2.0);
    }

    public void draw() {
        if (myPolygon.size() < 2) return;

        DrawingTool pen = new DrawingTool(); // Or use your class instance
        Point2D.Double firstPoint = myPolygon.get(0);
        
        pen.up();
        pen.move(firstPoint.getX(), firstPoint.getY());
        pen.down();

        for (int i = 1; i < myPolygon.size(); i++) {
            Point2D.Double nextPoint = myPolygon.get(i);
            pen.move(nextPoint.getX(), nextPoint.getY());
        }

        // Close the polygon by moving back to the start
        pen.move(firstPoint.getX(), firstPoint.getY());
    }

}
