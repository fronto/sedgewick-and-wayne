public class LinkedStack<Item> implements Stack<Item> {

    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;

    }


    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.next = oldfirst;
        first.item = item;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {
        return first.item;
    }


    public static void main(String[] args) {


        LinkedStack<String> s = new LinkedStack<>();

        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if(!item.equals("-")) {
                s.push(item);
            } else if(!s.isEmpty()) {

                StdOut.print(s.pop() + " ");

            }

            StdOut.println("(" + s.size() + " left on stack)");

        }


    }

}

