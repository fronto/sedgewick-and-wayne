public class Main {

	public static void main(String[] args) {

		boolean[][] array = randomArray(5);
		System.out.println(booleanArrayAsString(array));
		
		
		
	}

	public static boolean[][] randomArray(int size) {

		boolean[][] array = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (Math.random() < 0.5) {
					array[i][j] = false;
					continue;
				}
				array[i][j] = true;
			}
		}
		return array;

	}

	public static String booleanArrayAsString(boolean[][] array) {
		StringBuilder arrayToPrint = new StringBuilder();
		arrayToPrint.append(' ');
		for(int t = 0; t < array.length; t++) {
			arrayToPrint.append(t + " ");
		}
		arrayToPrint.append('\n');
		
		for (int i = 0; i < array.length; i++) {
			arrayToPrint.append(i);
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j]) {
					arrayToPrint.append("* ");
					continue;
				}
				arrayToPrint.append("  ");
			}
			arrayToPrint.append('\n');
		}
		return arrayToPrint.toString();
	}
}
