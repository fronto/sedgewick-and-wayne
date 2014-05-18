import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class DoublingStackOfStringsTest {



    @Test
    public void pushToResizeThenPopToResize() {

        DoublingStackOfStrings stack = new DoublingStackOfStrings();
        StackTester stackTester = new StackTester(stack);

        for(int i = 0; i < 10; i++) {

            stackTester.push("" + i).assertPeek("" + i);

        }

        for(int i = 9; i >= 0; i--) {

            stackTester.assertPops("" + i);

        }

        stackTester.assertIsEmpty();


    }


    private static class StackTester {

        final DoublingStackOfStrings stack;


        private StackTester(DoublingStackOfStrings stack) {
            this.stack = stack;
        }

        StackTester push(String value) {
            stack.push(value);
            assertEquals(value, stack.peek());
            return this;
        }

        StackTester assertPeek(String expected) {
            String actual = stack.peek();
            assertEquals(expected, actual);
            return this;
        }

        StackTester assertPops(String expected) {
            String actual = stack.pop();
            assertEquals(expected, actual);
            return this;
        }

        StackTester assertIsEmpty() {
            assertTrue(stack.isEmpty());
            return this;
        }

    }


}
