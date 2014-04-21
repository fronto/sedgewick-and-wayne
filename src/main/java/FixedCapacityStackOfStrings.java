public class FixedCapacityStackOfStrings {

    private int index;
    private final String[] items;


    @SuppressWarnings("unchecked")
    public FixedCapacityStackOfStrings(int capacity) {
        this.items = new String[capacity];
        this.index = 0;
    }


    public void push(String s) {
        items[index++] = s;
    }

    public String pop() {
        return items[index--];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public int size() {
        return index;
    }

    boolean isFull() {
        return index == items.length;
    }


    public static void main(String[] args) {


        FixedCapacityStackOfStrings fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings(2);
        fixedCapacityStackOfStrings.push("1");
        assertFalse(fixedCapacityStackOfStrings.isFull());

        fixedCapacityStackOfStrings.push("2");
        assertTrue(fixedCapacityStackOfStrings.isFull());

    }

    private static void assertFalse(boolean truth) {
        if(truth) {
            throw new RuntimeException("expected false");
        }
    }

    private static void assertTrue(boolean truth) {
        if (truth) {
            return;
        }

        throw new RuntimeException("failed assertion");
    }

}
