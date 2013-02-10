public class Main {

	public static void main(String[] args) {

		
		printLg(5);
		printLg(8);
		printLg(1);
		printLg(2);
		
		
		
	}
	
	private static void printLg(int i) {
		System.out.println("lg(" + i + ") : " + lg(i));
	}

	public static int lg(int n) {
		int log = 0;
		while((n = n /2) > 0) {
			log++;
		}
		return log;
	}
	
	
	
}
