public class Main {

	public static void main(String[] args) {

		int[] array = new int[10];
		
		for(int i = 0; i < 10; i++) {
			array[i] = 9 - i;
		}
		for(int i = 0; i < 10; i++) {
			array[i] = array[array[i]];
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		
		
	}


}
