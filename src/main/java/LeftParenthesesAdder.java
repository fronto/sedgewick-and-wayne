public class LeftParenthesesAdder {


    private final Stack<String> expressions;
    private final Stack<String> operators;

    static LeftParenthesesAdder newLeftParenthesesAdder() {

        Stack<String> expressions = new LinkedStack<>();
        Stack<String> operators = new LinkedStack<>();

        return new LeftParenthesesAdder(expressions, operators);
    }

    private LeftParenthesesAdder(Stack<String> expressions, Stack<String> operators) {
        this.expressions = expressions;
        this.operators = operators;
    }

    private void handleNextToken(String token) {

        if (paddedWithWhitespace(token)) {
            throw new IllegalArgumentException("cannot parse tokens padded with whitespace: [" + token + "]");
        }

        if(isOpenParenthesis(token)) {
            return;
        }

        if (isNumeric(token)) {
            expressions.push(token);
            return;
        }

        if (isOperator(token)) {
            operators.push(token);
            return;
        }

        if (isCloseParenthesis(token)) {

            String rhs = expressions.pop();
            String op = operators.pop();
            String lhs = expressions.pop();

            String result = compoundExpression(lhs, op, rhs);
            expressions.push(result);
            return;

        }

        throw new IllegalStateException("could not parse token: " + token);

    }

    private boolean isOpenParenthesis(String token) {
        return "(".equals(token);
    }

    private boolean paddedWithWhitespace(String token) {

        String[] whitespaceChars = {" ", "\t", "\n"};

        for (String whiteSpaceChar : whitespaceChars) {
            if (token.startsWith(whiteSpaceChar)) {
                return true;
            }

            if (token.endsWith(whiteSpaceChar)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumeric(String token) {

        for (int i = 0; i < token.length(); i++) {
            char character = token.charAt(i);
            if (!isNumericChar(character)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNumericChar(char character) {
        for (int j = 0; j <= 9; j++) {
            String digit = "" + j;
            if (digit.equals("" + character)) {
                return true;
            }
        }
        return false;
    }

    private String compoundExpression(String lhs, String op, String rhs) {

        return spaceOut("(", lhs, op, rhs, ")");

    }

    private String spaceOut(String... allStrings) {

        StringBuilder withSpaces = new StringBuilder();

        for (String string : allStrings) {
            withSpaces.append(string).append(" ");
        }

        return withSpaces.toString().trim();
    }

    private boolean isCloseParenthesis(String right) {
        return ")".equals(right);
    }

    private boolean isOperator(String op) {

        if ("*".equals(op)) {
            return true;
        }

        if ("/".equals(op)) {
            return true;
        }

        if ("+".equals(op)) {
            return true;
        }

        if ("-".equals(op)) {
            return true;
        }

        return false;

    }

    public String addLeftParenthesesTo(String input) {

        String[] tokens = input.split("\\s+");
        for (String token : tokens) {
            handleNextToken(token);
        }

        if (!operators.isEmpty()) {
            throw new IllegalStateException("insufficient close brackets");
        }

        String result = expressions.pop();

        if (!expressions.isEmpty()) {
            throw new IllegalStateException("final expression not deduced, perhaps insufficient operators");
        }

        return result;
    }
}
