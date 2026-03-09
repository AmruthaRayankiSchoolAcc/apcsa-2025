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
        if (myPolygon.size() > 2) {
            return 0.0;
        }
        double sum1 = 0.0; 
        double sum2 = 0.0;
        for (int i = 0; i < myPolygon.size(); i++) {
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double next = myPolygon.get((i+1) % myPolygon.size());
            sum1 += current.x * next.y;
            sum2 += current.y * next.x;
        }
        return 0.5 * Math.abs(sum1-sum2);
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            if (myPolygon.size() < 2) {
                return; 
            }

            DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
            pen.up();

            Point2D.Double first = myPolygon.get(0);
            pen.move(first.getX(), first.getY());
            pen.down();

            for (int i = 1; i<=myPolygon.size()-1; i++) {
                Point2D.Double next = myPolygon.get(i);
                pen.move(next.x, next.y);
            }
             
            pen.move(first.x, first.y);
            pen.up();
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            //DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            //myDrawingTool.move(50, 50);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
