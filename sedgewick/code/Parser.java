import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Parser {

	//private static final String SPACES = "[ ]*";
	
	static Parser createParser(File file) {
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			//scanner.useDelimiter(SPACES);
			return new Parser(scanner);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	private final Scanner scanner;
	
	
	private Parser(Scanner scanner) {
		this.scanner = scanner;
	}
	
	
	
	boolean canParseNextLine() {
		return scanner.hasNextLine();
	}
	
	InputLine parseNextLine() {
		return InputLine.parseNextLine(scanner);
		
	}
	
	
}
