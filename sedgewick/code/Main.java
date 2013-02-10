public class Main {

	public static void main(String[] args) {

		int[][] array = contiousArray(2, 3);
		printIntegerArray(array);
		array = transpose(array);
		printIntegerArray(array);
		
	}
	
	
	private static int[][] contiousArray(int width, int height) {
		int[][] array = new int[height][width];
		int counter = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				counter++;
				array[i][j] = counter;
			}
		}
		return array;
	}
	
	private static void printIntegerArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.printf("%2d",array[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int[][] transpose(int[][] array) {
		int[][] result = new int[array[0].length][array.length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				result[j][i] = array[i][j];
			}
		}
		return result;
	}

}
