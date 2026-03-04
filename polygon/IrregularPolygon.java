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
        for (int i = 0; i < myPolygon.size()-1; i++) {
            double xdif = myPolygon.get(i).getX() - myPolygon.get(i+1).getX();
            double ydif = myPolygon.get(i).getY() - myPolygon.get(i+1).getY();
            perimeter += Math.sqrt((xdif*xdif + ydif*ydif));
        }
        double x = myPolygon.get(myPolygon.size() - 1).getX() - myPolygon.get(0).getX();
        double y = myPolygon.get(myPolygon.size() - 1).getY() - myPolygon.get(0).getY();
        perimeter += Math.sqrt((x*x + y*y));
        return perimeter;
    }

    public double area() {
        // TODO: Calculate the area.
        Double area = 0.0;
        if (myPolygon.size() > 2) {
            
        }
        return area;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            //DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            //myDrawingTool.move(50, 50);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
