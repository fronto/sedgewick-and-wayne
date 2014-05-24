import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LinkedStackTest {


    @Test(expected = Exception.class)
    public void peekEmptyStack() {

        LinkedStack<Integer> stack = new LinkedStack();
        stack.peek();

    }


    @Test
    public void peekReturnsLastElementAdded() {

        LinkedStack<Integer> stack = new LinkedStack<>();

        stack.push(1);
        stack.push(2);

        assertEquals(new Integer(2), stack.peek());

    }

}
