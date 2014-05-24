import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class DoublingStackOfStringsTest {


    @Test
    public void pushToResizeThenPopToResize() {

        Stack<String> stack = new DoublingStackOfStrings();
        StackTester stackTester = new StackTester(stack);

        for (int i = 0; i < 10; i++) {

            stackTester.push("" + i).assertPeek("" + i);

        }


    }


    @Test
    public void canPopOffStack() {

        DoublingStackOfStrings stack = new DoublingStackOfStrings();
        StackTester stackTester = new StackTester(stack);

        stackTester.push(new String[]{"1", "2", "3", "4", "5"});


        stackTester.assertPops("" + 5);
        stackTester.assertPops("" + 4);
        stackTester.assertPops("" + 3);
        stackTester.assertPops("" + 2);
        stackTester.assertPops("" + 1);

    }

    @Test(expected = Exception.class)
    public void cannotPopOffEmptyStack() {

        DoublingStackOfStrings stack = new DoublingStackOfStrings();
        StackTester stackTester = new StackTester(stack);

        stackTester.assertIsEmpty();
        stack.pop();


    }


    private static class StackTester<Item> {

        final Stack<Item> stack;


        private StackTester(Stack<Item> stack) {
            this.stack = stack;
        }

        StackTester push(Item[] arr) {
            for (Item i : arr) {
                stack.push(i);
            }
            return this;

        }

        StackTester push(Item value) {
            stack.push(value);
            assertEquals(value, stack.peek());
            return this;
        }

        StackTester assertPeek(String expected) {
            Item actual = stack.peek();
            assertEquals(expected, actual);
            return this;
        }

        StackTester assertPops(String expected) {
            Item actual = stack.pop();
            assertEquals(expected, actual);
            return this;
        }

        StackTester assertIsEmpty() {
            assertTrue(stack.isEmpty());
            return this;
        }

    }


}
