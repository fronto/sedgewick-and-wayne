import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;

public class Fibonacci {

	private static final List<BigInteger> resultCache = new ArrayList<BigInteger>();
	private static final BigInteger fibPerSecond = BigInteger.valueOf(Double.valueOf("1.8053112574944776E8").longValue());
	private static final BigInteger SIXTY = BigInteger.valueOf(60);

	public static BigInteger fibSlow(int N) {
		

		if(N == 0) {
			return BigInteger.ZERO;
		}

		if(N == 1) {
			return BigInteger.ONE;
		}

		return fibSlow(N-1).add(fibSlow(N-2));
	}

	public static BigInteger F(int N) {
		
		if(resultCache.size() >  N) {
			return resultCache.get(N);
		}

		if(N == 0) {
			resultCache.add(BigInteger.ZERO);
			return BigInteger.ZERO;
		}

		if(N == 1) {
			resultCache.add(BigInteger.ONE);
			return BigInteger.ONE;
		}

		BigInteger result =  F(N-1).add(F(N-2));
		resultCache.add(result);
		return result;
	}

	public static void main(String[] args) {
			
		BigInteger fibPerHour = fibPerSecond.multiply(SIXTY).multiply(SIXTY);
		
		for(int N = 0; N < 100; N++) {
			Stopwatch stopwatch = new Stopwatch();
			BigInteger fib = F(N);

			if(fib.compareTo(fibPerHour) <= 0) {
				double elapsedTime = stopwatch.elapsedTime();
				StdOut.println(elapsedTime + "s fib(" + N + ") is " + fib );
			}

		}
	}

}
