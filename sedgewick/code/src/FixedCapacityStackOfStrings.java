public class FixedCapacityStackOfStrings<T> {

	private final T[] items;

	@SuppressWarnings("unchecked")
	public FixedCapacityStackOfStrings(int capacity) {
		this.items =  (T[]) new Object[capacity];
	}




}
