import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

	private final LineSegment[] segments;
	private final Point[] points;
	
	public BruteCollinearPoints(Point[] providedPoints) {
		// Throw exception if points is null
		if (providedPoints == null) {
			throw new java.lang.NullPointerException();
		}
				
		points = providedPoints.clone();
		Arrays.sort(points);
		
		// Find duplicates
		for (int i = 1; i < points.length; i++) {
			if (points[i-1].compareTo(points[i]) == 0 || points[i-1] == null || points[i] == null) {
				throw new java.lang.IllegalArgumentException();
			}
		}
		
		ArrayList<LineSegment> segmentsList = new ArrayList<LineSegment>();
		
		for (int p = 0; p < points.length; p++) {
			for (int q = p + 1; q < points.length; q++) {
				for (int r = q + 1; r < points.length; r++) {
					for (int s = r + 1; s < points.length; s++) {
						
						Point pPoint = points[p];
						Point qPoint = points[q];
						Point rPoint = points[r];
						Point sPoint = points[s];
						
						if (Double.compare(pPoint.slopeTo(qPoint), qPoint.slopeTo(rPoint)) == 0 &&
						    Double.compare(qPoint.slopeTo(rPoint), rPoint.slopeTo(sPoint)) == 0) {
							
							segmentsList.add(new LineSegment(pPoint, sPoint));
						}				
					}
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

	}
}
