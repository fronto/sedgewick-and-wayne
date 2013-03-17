public class Main {

	static double logFactorial(int n) {

		if(n == 1) {
			return 0.0;
		}

		return Math.log((double) n) + logFactorial(n -1);

	}

	static int factorial(int n) {

		if(n == 0) {
			return 1;
		}

		if(n == 1) {
			return 1;
		}

		return n * factorial(n-1);

	}

	public static void main(String[] args) {

		double expected = Math.log((double) factorial(3));	
		double actual = logFactorial(3);

		System.out.printf("expected: %f  actual: %f\n", expected, actual);

	}

}
