import java.util.Scanner;


public class InputLine {

	static InputLine parseNextLine(Scanner scanner) {
		String name = scanner.next();
		int first = scanner.nextInt();
		int second = scanner.nextInt();
		return new InputLine(name, first, second);
	}
	
	final String name;
	final Integer first;
	final Integer second;
	
	InputLine(String line, Integer first, Integer second) {
		this.name = line;
		this.first = first;
		this.second = second;
	}

	
	
	
	
}
