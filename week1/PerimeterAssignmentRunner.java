import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count=0;
        for(Point p:s.getPoints())
        {
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {

        return getPerimeter(s)/getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        double max=Double.MIN_VALUE;
        Point prev = s.getLastPoint();
        for(Point curr:s.getPoints())
        {
            double largeSide = prev.distance(curr);
            if(max<largeSide)
            {
                max=largeSide;
            }
            prev=curr;
        }
        return max;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largeX=Double.MIN_VALUE;
        for(Point p:s.getPoints())
        {
            double curX = p.getX();
            if(largeX<curX)
                largeX=curX;
        }
        return largeX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largePerimeter = Double.MIN_VALUE;
        for(File f:dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if(largePerimeter<perimeter)
            {
                largePerimeter=perimeter;
            }

        }
        return largePerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;// replace this code
        double largePerimeter=Double.MIN_VALUE;
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if(largePerimeter<perimeter)
            {
                largePerimeter=perimeter;
                temp=f;
            }

        }

        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numOfPoints = getNumPoints(s);
        System.out.println("Number of points = "+numOfPoints);
        double avgLength = getAverageLength(s);
        System.out.println("Average length = "+avgLength);
        double longestSide = getLargestSide(s);
        System.out.println("Longest side = "+longestSide);
        double largeX = getLargestX(s);
        System.out.println("Largest X = "+largeX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largePerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Large Perimeter = "+largePerimeter);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String file = getFileWithLargestPerimeter();
        System.out.println("File with largest Perimeter = "+file);

    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        pr.testFileWithLargestPerimeter();
        //pr.testPerimeterMultipleFiles();
    }
}
