public class FixedCapacityStackOfStrings implements Stack<String> {

    private int index;
	private final String[] items;



	@SuppressWarnings("unchecked")
	public FixedCapacityStackOfStrings(int capacity) {
		this.items =  new String[capacity];
        this.index = 0;
	}


    @Override
    public void push(String s) {
        items[index++] = s;
    }

    @Override
    public String pop() {
        return items[index--];
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public int size() {
        return index;
    }

    boolean isFull() {
        return index == items.length;
    }

}
