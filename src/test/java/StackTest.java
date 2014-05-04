import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StackTest {


    @Test(expected = Exception.class)
    public void peekEmptyStack() {

        Stack<Integer> stack = new Stack();
        stack.peek();

    }


    @Test
    public void peekReturnsLastElementAdded() {

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);

        assertEquals(new Integer(2), stack.peek());

    }

}
