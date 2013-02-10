public class Main {

	public static void main(String[] args) {

		System.out.println(asBinaryNumber(6));

	}

	private static String asBinaryNumber(int i) {

		String binaryNumber = "";
		while (i != 0) {
			binaryNumber = i % 2 + binaryNumber;
			i = i / 2;
		}
		return binaryNumber;

	}

}
