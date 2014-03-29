import java.awt.Color;

public class VisualCounter {

	private int count;
	private int opCount;

	private final int max_ops;
	private final int max_count;
	private final int min_count;

	public VisualCounter(int N, int max) {
		this.max_ops = N;
		this.max_count = max;
		this.min_count = -max;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, 2 * max);
		StdDraw.setPenRadius(.005);
		StdDraw.setPenColor(Color.RED);
	}

	public void increment() {
		if (lessThanMaxOps()) {
			opCount++;
			if (lessThanMaxCount()) {
				count++;
			}
		}
		StdDraw.point(opCount, count);
	}

	private boolean lessThanMaxCount() {
		return count < max_count;
	}

	private boolean lessThanMaxOps() {
		return opCount < max_ops;
	}

	public void decrement() {
		if (lessThanMaxOps()) {
			opCount++;
			if (greaterThanMinimumCount()) {
				count--;
			}
		}
		StdDraw.point(opCount, count);
	}

	private boolean greaterThanMinimumCount() {
		return count > min_count;
	}

	public int tally() {
		return count;
	}

	public static void main(String[] args) {

		VisualCounter counter = new VisualCounter(100, 25);
		for (int i = 0; i < 25; i++) {
			counter.increment();
		}
		for (int i = 0; i < 50; i++) {
			counter.decrement();
		}

	}

}
