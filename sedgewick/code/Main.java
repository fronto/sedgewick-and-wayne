public class Main {

	public static void main(String[] args) {

		mystery(2, 25);				
		System.out.println();
		mystery(3, 11);

	}

	public static int mystery(int a, int b) {
		
		if(b == 0) {
			int result = 0;
			System.out.println("mystery(" + a + "," + b + ") -> " + result);
			return result;
		}

		if(b % 2 == 0) {
			int result = mystery(a+a, b/2);	
			System.out.println("mystery(" + a + "," + b + ") -> " + result);
			return result;

		}

		
		int result = mystery(a+a, b/2) + a;	
		System.out.println("mystery(" + a + "," + b + ") -> " + result);
		return result;

	}


}
