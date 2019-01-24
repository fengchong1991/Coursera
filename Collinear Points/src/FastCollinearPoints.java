import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
	
	private final LineSegment[] segments;
	private final Point[] points;
	public FastCollinearPoints(Point[] providedPoints) {
		
		// Throw exception if points is null
		if (providedPoints == null) {
			throw new java.lang.NullPointerException();
		}
		
		this.points = providedPoints;
		
		Arrays.sort(points);
		
		// Find duplicates
		for (int i = 1; i < points.length; i++) {
			if (points[i-1].compareTo(points[i]) == 0 || points[i-1] == null || points[i] == null) {
				throw new java.lang.IllegalArgumentException();
			}
		}
		
		
		ArrayList<LineSegment> segmentsList = new ArrayList<LineSegment>();
		Point[] pointsClone = points.clone();
				
		for (int p = 0; p < points.length; p++) {
			Point currentP = points[p];
			Arrays.sort(pointsClone);
			Arrays.sort(pointsClone, currentP.slopeOrder());
			
			Double[] slopes = new Double[points.length];
			for (int i = 0; i < pointsClone.length; i++) {
				slopes[i] = currentP.slopeTo(pointsClone[i]);
			}
			
			for (int i = 0 ; i < pointsClone.length; i++) {
				int j = i;
				while (j < pointsClone.length && Double.compare(slopes[i], slopes[j]) == 0) {
					j++;
				}
				
				j--;
				
				if (j-i >= 2 && pointsClone[i].compareTo(currentP) > 0 && i - 1 >= 0 && Double.compare(slopes[i], slopes[i-1]) != 0) {
					segmentsList.add(new LineSegment(currentP, pointsClone[j]));
				}
			}
		}
		
		segments = segmentsList.toArray(new LineSegment[segmentsList.size()]);
	}
	
	public int numberOfSegments() {
		return segments.length;
	}
	
	public LineSegment[] segments() {
		return segments.clone();
	}
	
	
	public static void main(String[] args) {
		
//	    // read the n points from a file
//	    In in = new In(args[0]);
//	    int n = in.readInt();
//	    Point[] points = new Point[n];
//	    for (int i = 0; i < n; i++) {
//	        int x = in.readInt();
//	        int y = in.readInt();
//	        points[i] = new Point(x, y);
//	    }
//
//	    // draw the points
//	    StdDraw.enableDoubleBuffering();
//	    StdDraw.setXscale(0, 32768);
//	    StdDraw.setYscale(0, 32768);
//	    StdDraw.setPenRadius(0.02);
//	    
//	    for (Point p : points) {
//	        p.draw();
//	    }
//	    StdDraw.show();
//
//	    // print and draw the line segments
//	    FastCollinearPoints collinear = new FastCollinearPoints(points);
//	    for (LineSegment segment : collinear.segments()) {
//	        StdOut.println(segment);
//	        segment.draw();
//	    }
//	    StdDraw.show();
	}
}
