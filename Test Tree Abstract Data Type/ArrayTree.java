
public class ArrayTree<E> {
	private E[] array;
	private int count;
	private int size;
	private int order;

	public ArrayTree(int order, int capacity) {
		this.order = order;
		size = capacity;
		array = (E[]) new Object[size];
	}

	public boolean isEmpty() {
		return array[0] == null;
	}

	public int root() {
		return 0;
	}

	public int parent(int p) {
		return (p - 1) / order;
	}

	public int child(int parent, int c) {
		int positionC = order * parent + c + 1;
		if (positionC > size) {// if number of elements exceed size of Array
			return -1;
		}
		parent(parent);
		return positionC;
	}

	public int size() {
		return count;
	}

	public int addRoot(E e) {
		while (isEmpty()) {
			array[0] = e;
			count++;
		}
		return 0;
	}

	public E get(int pos) {
		if (isEmpty()) {
			return null;
		}
		return array[pos];
	}

	public int addChild(int parent, int child, E e) {
		if (child(parent, child) == -1) {
			return -1;
		}
		array[order * parent + child + 1] = e;
		count++;
		return order * parent + child + 1;

	}

	public E getChild(int parent, int child) {
		return array[order * parent + child + 1];
	}

	public String toString() {
		String result = "[ArrayTree: order=" + order + ", count=" + count + ", size=" + size + ", array={";
		for (int element = 0; element < size; element++) {
			if (array[element] == null) {
				result += "- ";
			}
			
			else {
			result += array[element];
			result += " ";
			}
		}
		result += "}]";
		return result;
	}
}
