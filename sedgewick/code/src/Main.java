import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		File file = new File(args[0]);
		if (!file.exists()) {
			throw new IllegalArgumentException("non-existant file: "
					+ file.getAbsolutePath());
		}

		// Parser parser = Parser.createParser(file);
		// while (parser.canParseNextLine()) {
		// InputLine inputLine = parser.parseNextLine();
		// OutputLine outputLine = OutputLine.compute(inputLine);
		// outputLine.write(System.out);
		// }

		In fileIn = new In(file);
		Out out = new Out();
		while (fileIn.hasNextLine()) {

			String line = fileIn.readLine();
			// In lineIn = new In(line);
			Scanner scanner = new Scanner(line);
			if (scanner.hasNext()) {
				String name = scanner.next();
				Integer first = scanner.nextInt();
				Integer second = scanner.nextInt();
				double result = (double) first / second;
				out.printf("%s\t%d %d %.3f\n", name, first, second, result);
			}
		}

	}

}
