import java.io.File;

public class Main {

	public static void main(String[] args) {

		File file = new File(args[0]);
		if (!file.exists()) {
			throw new IllegalArgumentException("non-existant file: "
					+ file.getAbsolutePath());
		}
		
		Parser parser = Parser.createParser(file);
		while (parser.canParseNextLine()) {
			InputLine inputLine = parser.parseNextLine();
			OutputLine outputLine = OutputLine.compute(inputLine);
			outputLine.write(System.out);
		}

	}

}
