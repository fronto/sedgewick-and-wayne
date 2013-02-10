public class Main {

	public static void main(String[] args) {

		
		int max = 10;
		int[] arrayOfInts = randomInts(100, max);
		int[] frequencies = histogram(arrayOfInts, max);
		
		int maxHeight = max(frequencies);
		
		int[] printEntries = new int[frequencies.length];
		for(int i = 0; i < printEntries.length; i++) {
			printEntries[i] = 0;
		}
		
		for(int i = maxHeight; i > 0; i--) {
			
			int heightOfCurrentRow = i;
			
			for(int j = 0; j < frequencies.length; j++) {
				
				int heightOfCurrentValue = frequencies[j];
				
				if(heightOfCurrentRow <= heightOfCurrentValue) {
					System.out.print("    |");
					printEntries[j]++;
				} else {
					System.out.print("     ");
				}
				
			}
			
			System.out.println();
			
		}
		
		for(int j = 0; j < frequencies.length; j++) {
			System.out.printf("%5d", j);
		}
		
		for(int i = 0; i < frequencies.length; i++) {
			if(frequencies[i] != printEntries[i]) {
				throw new RuntimeException("invariant violated frequency[" + i + "] has value " + frequencies[i] + "\n and printEntries[" + i + "] is " + printEntries[i]);
			}
		}
	}

	public static int[] histogram(int[] arrayOfInts, int max) {

		int[] frequencies = new int[max];
		for (int i = 0; i < frequencies.length; i++) {
			frequencies[i] = 0;
		}

		for (int i = 0; i < arrayOfInts.length; i++) {

			if (arrayOfInts[i] < max && arrayOfInts[i] >= 0) {
				int index = arrayOfInts[i];
				frequencies[index]++;
				continue;
			} 
			
			throw new IllegalStateException("arrayOfIts[" + i + "] has value " + i + " which is out of range 0 <= i < " + max);

		}

		if(total(frequencies) != sum(arrayOfInts)) {
			throw new RuntimeException("ivnvarient violated");
		}
		
		
		return frequencies;

	}

	static int sum(int[] array) {
		int total = 0;
		for(int i = 0; i < array.length; i++) {
			total += array[i];
		}
		return total;
	}
	
	static int total(int[] frequencies) {
		int total = 0;
		for(int i = 0; i < frequencies.length; i++) {
			total += frequencies[i] * i;
		}
		return total;
	}
	
	static int[] randomInts(int length, int max) {

		int[] randoms = new int[length];
		for (int i = 0; i < length; i++) {
			int random = (int) Math.floor(Math.random() * max);
			if(random >= max) {
				throw new RuntimeException("invariant violated");
			}
			randoms[i] = random;
		}
		return randoms;
	}
	
	static int max(int[] array) {
		if(array.length == 0) { 
			throw new IllegalArgumentException("precondition violated");
		}
		int max = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
	

}
