
public class Main {

	public static void main(String[] args) {

		System.out.println(rotation(args[0]));
		
		
	}
	
	
	static String rotation(String s) {
		
		int N = s.length();
		
		if(N <= 1) {
			return s;
		}
		
		String a = s.substring(0, N/2);
		String b = s.substring(N/2, N);
		
		return rotation(b) + rotation(a);
	}


}
