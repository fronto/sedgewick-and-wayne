public class BinarySearch {

	public static int rank(int key, int[] a) {

		int start = 0;
		int end = a.length - 1;

		return rankRecursive(key, a, start, end);
	}

	private static int rankRecursive(int key, int[] a, int hi, int lo) {

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

		return -1;
	}

}
