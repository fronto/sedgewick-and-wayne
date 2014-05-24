public interface Stack<Item> {

    Item peek();

    Item pop();

    boolean isEmpty();

    int size();

    void push(Item item);


}
