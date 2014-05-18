import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class DoublingStackOfStringsTest {



    @Test
    public void pushToResizeThenPopToResize() {

        DoublingStackOfStrings stack = new DoublingStackOfStrings();

        for(int i = 0; i < 10; i++) {

            stack.push("" + i);
            assertEquals("" + i, stack.peek());


        }

        for(int i = 9; i >= 0; i--) {

            assertEquals("" + i, stack.pop());


        }

        assertTrue(stack.isEmpty());


    }





}
