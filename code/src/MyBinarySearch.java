import java.util.Arrays;

public class MyBinarySearch {

	static int numberOfcalls;
	
	
	
	public static int rank(int key, int[] a) {

		int start = 0;
		int end = a.length - 1;
		numberOfcalls = 0;
		return rankRecursive(key, a, start, end);
	}

	private static int rankRecursive(int key, int[] a, int lo, int hi) {

		//printRecursive(lo, hi);
		
		if(lo <= hi) {

			int index = (hi + lo) / 2;

			if (a[index] == key) {
				return index;
			}

			if (a[index] < key) {
				return rankRecursive(key, a, index + 1, hi);
			}

			if (a[index] > key) {
				return rankRecursive(key, a, lo, index - 1);
			}

		}

		return -1;

	}

	private static void printRecursive(int lo, int hi) {
		
		numberOfcalls++;
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < numberOfcalls; i ++) {
			stringBuilder.append(" ");
		}
		stringBuilder.append("rank(").append(lo).append(", ").append(hi).append(")");
		
		System.out.println(stringBuilder);
		
	}
	
	
	public static void main(String[] args) {

		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);

		if("+".equals(args[1])) {

			while(!StdIn.isEmpty()) {
			
					int key = StdIn.readInt();
					if(rank(key, whitelist) == -1) {
						StdOut.println(key);
					}
			
			}		

		}

		if("-".equals(args[1])) {

			while(!StdIn.isEmpty()) {
		
				int key = StdIn.readInt();
				if(rank(key, whitelist) != -1) {
					StdOut.println(key);
				}
		
			}		

		

		}

		
		
		
		
	}
	
}
