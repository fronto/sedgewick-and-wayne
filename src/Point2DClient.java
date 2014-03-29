public class Point2DClient {

	public static void main(String[] args) {

		final int RANGE = 1;
		int N = Integer.parseInt(args[0]);
		Point2D[] points = createRandomPoints(RANGE, N);

		double min = findMinDistance(points);
		System.out.println("Minimum distance between points is: " + min);

	}

	private static Point2D[] createRandomPoints(final int RANGE, int N) {
		Point2D[] points = new Point2D[N];

		for (int i = 0; i < N; i++) {
			double x = StdRandom.random() * RANGE;
			double y = StdRandom.random() * RANGE;
			points[i] = new Point2D(x, y);
		}
		return points;
	}

	private static double findMinDistance(Point2D[] points) {
		double minDistSquared = Double.MAX_VALUE;

		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (i != j) {
					double distanceSquared = points[i]
							.distanceSquaredTo(points[j]);
					if (distanceSquared < minDistSquared) {
						minDistSquared = distanceSquared;
					}
				}
			}
		}
		return Math.sqrt(minDistSquared);
	}

}
