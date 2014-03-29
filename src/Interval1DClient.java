public class Interval1DClient {

	public static void main(String[] args) {

		int N = Integer.parseInt(args[0]);

		Interval1D[] intervals = parseIntervals(N);
		printIntersections(intervals);

	}

	private static void printIntersections(Interval1D[] intervals) {
		for(int i = 0; i < intervals.length; i++) {
			for(int j = i; j < intervals.length; j++) {
				if(i != j) {
					if(intervals[i].intersects(intervals[j])) {
						System.out.println(intervals[i] + " interscts with " + intervals[j]);
					}
				}
			}
		}
	}

	private static Interval1D[] parseIntervals(int N) {
		Interval1D[] intervals = new Interval1D[N];
		for (int i = 0; i < intervals.length; i++) {
			
			double start = StdIn.readDouble();
			double end = StdIn.readDouble();
			intervals[i] = new Interval1D(start, end);
			
		}
		return intervals;
	}
}
