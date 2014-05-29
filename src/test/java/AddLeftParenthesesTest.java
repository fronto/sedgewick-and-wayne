import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddLeftParenthesesTest {


    @Test
    public void addOneParenthesis() {


        LeftParenthesesAdder addLeftParentheses = LeftParenthesesAdder.newLeftParenthesesAdder();

        assertEquals("( 1 + 2 )", addLeftParentheses.addLeftParenthesesTo("1 + 2 )"));


    }


    @Test
    public void addsLeftParenthesesToCompoundExpression() {


        LeftParenthesesAdder leftParenthesesAdder = LeftParenthesesAdder.newLeftParenthesesAdder();

        assertEquals("( ( 1 + 2 ) + 3 )", leftParenthesesAdder.addLeftParenthesesTo("1 + 2 ) + 3 )"));


    }


    @Test
    public void addsExpectedParentheses() {

        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String expectedOutput = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )";

        LeftParenthesesAdder addLeftParentheses = LeftParenthesesAdder.newLeftParenthesesAdder();
        assertEquals(expectedOutput, addLeftParentheses.addLeftParenthesesTo(input));

    }

    @Test
    public void canHandleExpressionsAlreadyContainingLeftParentheses() {

        LeftParenthesesAdder leftParenthesesAdder = LeftParenthesesAdder.newLeftParenthesesAdder();

        assertEquals("( ( 1 + 2 ) + 3 )", leftParenthesesAdder.addLeftParenthesesTo("( 1 + 2 ) + 3 )"));

    }


}
