import java.text.DecimalFormat;

public class BST<K extends Comparable<K>, V> {
	private Node root;
	private int size;

	private class Node {
		private K k;
		private V v;
		private Node left;
		private Node right;

		Node(K key, V value) {
			k = key;
			v = value;
		}

		K getKey() {
			return k;
		}

		V getValue() {
			return v;
		}

		Node getLeft() {
			return left;
		}

		void setLeft(Node n) {
			left = n;
		}

		Node getRight() {
			return right;
		}

		void setRight(Node n) {
			right = n;
		}

		public String toString(int level) {
			DecimalFormat df = new DecimalFormat("0.00");
			String result = "";
			for (int i = 0; i < level; i++) {
				result += "  ";
			}
			level++;
			result += "(k=" + df.format(getKey()) + ", v=" + getValue() + ")\n";
			if (getLeft() != null) {
				result += getLeft().toString(level + 1);
			} else {
				for (int i = 0; i <= level; i++) {
					result += "  ";
				}
				result += "null\n";
			}

			if (getRight() != null) {
				result += getRight().toString(level + 1);
			} else {
				for (int i = 0; i <= level; i++) {
					result += "  ";
				}

				result += "null\n";
			}

			return result;
		}

		public String toString() {
			return toString(1);
		}
	}

	public BST() {
		root = null;
		size = 0;
	}

	public void insert(K key, V value) {
		Node newNode = new Node(key, value);
		Node compare = root;
		Node parent = null;
		if (root == null) {
			root = newNode;
			size++;
		} else {
			while (compare != null) {
				if (newNode.getKey().compareTo(compare.getKey()) < 0) {
					parent = compare;
					compare = compare.getLeft();
				} else {
					parent = compare;
					compare = compare.getRight();
				}
			}
			if (newNode.getKey().compareTo(parent.getKey()) < 0) {
				parent.setLeft(newNode);

				size++;
			} else {
				parent.setRight(newNode);
				size++;
			}
		}
	}

	public V find(K key) {
		Node start = root;
		Node result = find(key, start);
		return result.getValue();
	}

	private Node find(K key, Node n) {
		// if (n.getKey() != key) {

		while (key != n.getKey()) {
			// System.out.println("n : k=" + n.getKey() + " , v= " + n.getValue());
			// System.out.println("key : " + key);
			if (key.compareTo(n.getKey()) < 0) {
				n = n.getLeft();
			} else if ((key.compareTo(n.getKey()) > 0)) {
				n = n.getRight();
			} else {
				break;
			}
		}
		return n;
		// } else
		// return n;
	}

	public V delete(K key) {
		Node parent = null;
		Node start = root;
		Node find = null;
		Node temp = null;
		String store = "";
		// System.out.println("start : k=" + start.getKey() + " , v= " +
		// start.getValue());
		// if (start.getKey() == key) {
		if (key == start.getKey()) {
			if (start.getLeft() != null && start.getRight() != null) {
				find = start.getRight();
				temp = find;
				while (find.getLeft() != null) {
					find = find.getLeft();
				}
				store = (String) start.getValue();
				start.k = find.getKey();
				start.v = find.getValue();
				temp.setLeft(null);
			} else
				store = (String) start.getValue();
		}
		// System.out.println("here");
		// }
		else {
			while (start.getKey() != key) {
				if (key.compareTo(start.getKey()) < 0) {
					parent = start;
					start = start.getLeft();
				} else if (key.compareTo(start.getKey()) > 0) {
					parent = start;
					start = start.getRight();
				} else {
					break;
				}
			}
			if (start.getLeft() != null && start.getRight() != null) {
				find = start.getRight();
				temp = find;
				while (find.getLeft() != null) {
					find = find.getLeft();
				}
				store = (String) start.getValue();
				start.k = find.getKey();
				start.v = find.getValue();
				temp.setLeft(null);
				System.out.println("store : " + store);
			} else if (start.getLeft() == null && start.getRight() == null)

			{
				if (key.compareTo(parent.getKey()) < 0) {
					parent.setLeft(null);
				} else
					parent.setRight(null);
			} else if (start.getLeft() != null || start.getRight() == null) {
				if (key.compareTo(parent.getKey()) < 0) {
					parent.setLeft(start.getLeft());
				} else
					parent.setRight(start.getLeft());

			} else if (start.getLeft() == null || start.getRight() != null) {
				if (key.compareTo(parent.getKey()) < 0) {
					parent.setLeft(start.getRight());
				} else
					parent.setRight(start.getRight());

			}
		}
		if (parent != null) {
			return start.getValue();
		} else {
			return (V) store;
		}
	}
	// }return start.getValue();

	public int size() {
		return size;
	}

	public String toString() {
		return (root == null) ? "null" : root.toString();
	}
}