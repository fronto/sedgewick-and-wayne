
public class Euclid {

	public static void main(String[] args) {

		int dividend = 105;	
		int divisor = 24;
		
		
		int hcd = findHCD(dividend, divisor);
		System.out.println("HCD is " + hcd);	
	}


	private static int findHCD(int dividend, int divisor) {
		int remainder = findRemainder(dividend, divisor);
		while(remainder != 0) {
			dividend = divisor;
			divisor = remainder;
			remainder = findRemainder(dividend, divisor);
		}
		return divisor;
	}


	public static int findRemainder(int dividend, int divisor) {
		int result = dividend % divisor;
		System.out.println(dividend + " % " + divisor + " = " + result);
		return result;
	}

}
