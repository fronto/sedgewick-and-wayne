
public class Main {

	public static void main(String[] args) {

		String s  = args[0];
		String t = args[1];
		
		if(isCircularRotation(s,t)) {
			System.out.println(s + " is a circular rotation of " + t);
			return;
		} 
		
		System.out.println(s + " is NOT a circular rotation of " + t);
	}

	private static boolean isCircularRotation(String s, String t) {

		return s.length() == t.length() ? (s + s).indexOf(t) != -1 : false;
		
		
	}

}
