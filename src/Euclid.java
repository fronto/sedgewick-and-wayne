
public class Euclid {

	public static void main(String[] args) {

		//assertEqual(3, findHCD(105, 24));
		//assertEqugl(3, findHCD(24, 105));
		//assertEqual(105, findHCD(105, 105));
		//assertEqual(1, findHCD(31, 32));
		//System.out.println("HCD is " + hcd);	

		int dividend = Integer.parseInt(args[0]);
		int divisor = Integer.parseInt(args[1]);

		findHCD(dividend, divisor);


	}


	private static void assertEqual(Integer expected, Integer actual) {
		if(expected.equals(actual)) {
			return;
		}
		throw new RuntimeException("expected value: " + expected + " but got " + actual);
	}

	public static int findHCD(int dividend, int divisor) {

		int result = findHCDRecursive(dividend, divisor);
		System.out.println("findHCD(" + dividend + ", " + divisor + ") is " + result);
		return result;

	}


	public static int findHCDUsingWhileLoop(int dividend, int divisor) {
		String message = "findHCD(" + dividend + ", " + divisor +  ")";
		int remainder = findRemainder(dividend, divisor);
		while(true) {
			if(remainder == 0) {
				break;
			}
			dividend = divisor;
			divisor = remainder;
			remainder = findRemainder(dividend, divisor);
		}
		message = message + " is " + divisor;
		System.out.println(message);
		return divisor;
	}

	public static int findHCDRecursive(int dividend, int divisor) {

		int remainder = dividend % divisor;
		
		if(remainder == 0) {
			return divisor;
		}

		return findHCDRecursive(divisor, remainder);
		
	}


	private static int findRemainder(int dividend, int divisor) {
		int result = dividend % divisor;
		//System.out.println(dividend + " % " + divisor + " = " + result);
		return result;
	}

	
	
}
