import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParenthesesTest {


    @Test
    public void balancedBrackets() {

        Parentheses parser = new Parentheses();
        assertTrue(parser.balanced("[()]{}{[()()]()}"));

    }

    @Test
    public void erronouslyOverlapping() {

        Parentheses parser = new Parentheses();
        assertFalse(parser.balanced("[(])"));


    }





}
