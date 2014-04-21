public class Interval2DClient {

	public static void main(String[] args) {
		
		int N = Integer.parseInt(args[0]);
		double min = Double.parseDouble(args[1]);
		double max = Double.parseDouble(args[2]);

		Interval2D[] intervals = new Interval2D[N];
		
		for(int i = 0; i < N; i++) {
			
			 
			intervals[i] = createInterval2D(min, max); 
			for(int j = 0; j < i; j++) {
				if(intervals[i].intersects(intervals[j])) {
					System.out.println(intervals[i] + " intersects " + intervals[j]);
				}
			}
			intervals[i].draw();
			
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i != j) {
					if(intervals[i].contains(intervals[j])) {
						
						System.out.println(intervals[i] + " contains " + intervals[j]);
						
					}
				}
			}
		}
		
	}

	private static Interval2D createInterval2D(double min, double max) {
		Interval1D x = createInterval1D(min, max);
		Interval1D y = createInterval1D(min, max);
		Interval2D interval2d = new Interval2D(x, y);
		return interval2d;
	}

	private static Interval1D createInterval1D(double min, double max) {

		double range = max - min;

		double[] randoms = new double[] { StdRandom.random(),
				StdRandom.random() };
		double intervalMin = StdStats.min(randoms) * range + min;
		double intervalMax = StdStats.max(randoms) * range + min;
		return new Interval1D(intervalMin, intervalMax);
	}

}
