import java.io.PrintStream;

public class OutputLine {

	public static OutputLine compute(InputLine input) {
		double result = (double) input.first / input.second;
		return new OutputLine(input, result);
	}
	
	final InputLine inputLine;
	final Double result;

	private OutputLine(InputLine inputLine, Double result) {
		this.inputLine = inputLine;
		this.result = result;
	}

	void write(PrintStream writer) {
		writer.printf("%s\t%d %d %.3f\n", inputLine.name, inputLine.first, inputLine.second, result);
	}
	
	
}
