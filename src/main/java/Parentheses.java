public class Parentheses {


    boolean balanced(String input) {

        LinkedStack<Character> openParentheses = new LinkedStack<>();

        for(int i = 0; i < input.length(); i++) {

            Character c = input.charAt(i);


            if(isOpenParentheses(c)) {
                openParentheses.push(c);
            }

            if(isCloseParentheses(c)) {

                Character o = openParentheses.pop();

                if(notOpenClosed(o, c)) {

                    return false;

                }

            }

        }


        return openParentheses.isEmpty();
    }

    private boolean notOpenClosed(Character o, Character c) {

        return !isOpenClosed(o,c);



    }

    private boolean isOpenClosed(Character o, Character c) {

        if(isSquarePair(o, c)) {
            return true;
        }

        if(isSquiglyPair(o, c)) {
            return true;
        }

        if(isRoundPair(o, c)) {
            return true;
        }

        return false;
    }

    private boolean isRoundPair(char o, char c) {
        return o == '(' && c == ')';
    }

    private boolean isSquiglyPair(char o, char c) {

        return o == '{' && c == '}';


    }

    private boolean isSquarePair(char o, char c) {
        return o == '[' && c == ']';
    }

    private boolean isCloseParentheses(Character c) {

        if(c.charValue() == '}') {
            return true;
        }

        if(c.charValue() == ']') {
            return true;
        }

        if(c.charValue() == ')') {
            return true;
        }

        return false;


    }

    private boolean isOpenParentheses(Character c) {
        if(c.charValue() == '{') {
            return true;
        }

        if(c.charValue() == '[') {
            return true;
        }

        if(c.charValue() == '(') {
            return true;
        }

        return false;

    }


}
