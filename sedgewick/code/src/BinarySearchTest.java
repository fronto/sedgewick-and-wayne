import java.util.List;


public class BinarySearchTest {
	private static String asString(int[] array) {
		StringBuilder builder = new StringBuilder("[");
		for(int i = 0; i < array.length; i++) {
			builder.append(i).append(",");
		}
		builder.append("]");	
		return builder.toString();
			
	}

	private static int[] sortedArray(int size) {

		int[] array = new int[size];

		for (int i = 0; i < size; i++) {

			array[i] = i;

		}

		return array;

	}

	private static void searchArray(int key, int[] array) {

		for (int i = 1; i < array.length; i++) {

			if (array[i] < array[i - 1]) {
				throw new IllegalStateException("array not sorted");
			}

		}

		int rank = BinarySearch.rank(key, array);
		if (rank != -1) {
			if (array[rank] != key) {
				throw new IllegalArgumentException("array[" + rank
						+ "] is not " + key);
			}
		}

		if(rank == -1) {

			Integer[] asArray = new Integer[array.length];
			for(int i = 0; i < array.length; i++) {
				asArray[i] = array[i];
			}
			List<Integer> list = java.util.Arrays.asList(asArray); 
			if(list.contains(new Integer(0))) { 
				throw new IllegalArgumentException("array " + asString(array) + " contains " + key + " @ " + list.indexOf(new Integer(key)));
			}

		}

		
		System.out.println("rank of " + key + " is " + rank + " in array " + asString(array));

	}

	public static void main(String[] args) {

		int size = 10;
		int[] array = sortedArray(size);
		for (int i = 0; i < size; i++) {
			searchArray(i, array);
		}

	}
}
