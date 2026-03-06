package polygon;

import java.awt.geom.Point2D;

public class Main {
    public static void main(String[] args)
    {
        IrregularPolygon myPolygon = new IrregularPolygon();

        myPolygon.add(new Point2D.Double(50, 50));
        myPolygon.add(new Point2D.Double(100, 120));
        myPolygon.add(new Point2D.Double(170, 90));
        myPolygon.add(new Point2D.Double(150, 20));
        myPolygon.add(new Point2D.Double(80, 10));

        myPolygon.draw();

        System.out.println("Perimeter: " + myPolygon.perimeter());
        System.out.println("Area: " + myPolygon.area());

        TestSuite.run();
    }
}
