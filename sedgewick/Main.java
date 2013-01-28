public class Main {

	public static void main(String[] args) {

		int sum = 0;
		for(int i = 1; i < 1000; i *= 2) {
			for(int j = 0; j < 1000; j++) {
				sum++;
			}
		}
		StdOut.println(sum);

		sum = 0;
		for(int j = 0; j < 1000; j++) {
			sum++;
		}

			
		int tenLog2 = (new Double(Math.log(1000.0)/Math.log(2.0))).intValue();
		StdOut.println(tenLog2 * 1000);

	}

}
