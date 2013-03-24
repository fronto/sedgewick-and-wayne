
public class BinarySearch {

	public static int rank(int key, int[] a) {

		int start = 0;
		int end = a.length - 1;
		int index = (start + end) / 2;

		while (start <= end) { //TODO figure out why <= is needed

			index = (start + end) / 2;

			if (a[index] == key) {
				break;
			}

			if (a[index] < key) {
				start = index + 1;
			}

			if (a[index] > key) {
				end = index - 1;
			}

		}

		if (a[index] == key) {
			return index;
		}

		return -1;
	}


}
