public class DoublingStackOfStrings implements Stack<String> {

    private String[] items = new String[1];
    private int size = 0;

    public DoublingStackOfStrings() {
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;

    }

    public void push(String item) {

        if (size == items.length) {
            resize(items.length * 2);
        }

        items[size++] = item;


    }

    private void resize(int newSize) {

        String[] replacement = new String[newSize];

        for (int i = 0; i < Math.min(newSize, items.length); i++) {
            replacement[i] = items[i];
        }

        items = replacement;
    }

    public String pop() {

        if (size == items.length / 4) {
            resize(items.length / 2);
        }

        return items[--size];

    }

    public String peek() {
        return items[size - 1];
    }

    public static void main(String[] args) {


        Stack<String> stack = new DoublingStackOfStrings();

        while (!StdIn.isEmpty()) {

            String item = StdIn.readString();

            if (!item.equals("-")) {
                stack.push(item);

            } else if (!stack.isEmpty()) {
                StdOut.println(stack.pop() + " ");
            }

            StdOut.println("(" + stack.size() + " left on stack)");
        }


    }


}
