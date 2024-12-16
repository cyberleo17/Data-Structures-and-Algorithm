

public class SinglyLinkedList<E> {
	private static class Node<E> {
		private E element;
		private Node<E> next;

		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}

	private Node<E> head;
	private Node<E> tail;
	private int size;

	public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public int length() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E getFirst() {
		if (isEmpty()) {
			return null;
		}
		return head.getElement();
	}

	public E getLast() {
		if (isEmpty()) {
			return null;
		}
		return tail.getElement();
	}

	public void addFirst(E e) {
		head = new Node<E>(e, head);
		if (isEmpty()) {
			tail = head;
		}
		size++;
	}

	public void addLast(E e) {
		Node<E> newest = new Node<E>(e, null);
		if (isEmpty()) {
			head = newest;
		} else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}

	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}

		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (isEmpty()) {
			tail = null;
		}
		return answer;
	}

	public E removeLast() {
		if (isEmpty()) {
			return null;
		}

		E answer = tail.getElement();
		for (Node<E> holder = head; holder != null; holder = holder.getNext()) {

			if (holder.getNext().getNext() == null) {
				holder.setNext(null);
				tail = holder;
			}
		}
		size--;
		return answer;
	}

	public E get(int n) {
		if (n >= length()) {
			return null;
		}

		Node<E> holder = head;
		Node<E> previousholder = null;
		for(int i=0; i<=n; i++) {
				previousholder = holder;
				holder = holder.getNext();
			}
		return previousholder.getElement();
	}
	
	void insertAfter(int n, E e) {
		if(n>= length()) {
			return;
		}
		
		Node<E> p = head;
	
		for(int i=0; i<n; i++) {
			p=p.getNext();
		}
		
		Node<E> newNode = new Node<E>(e, null);
		newNode.setNext(p.getNext());
		p.setNext(newNode);
	}
	
	void delete(int n) {
		if(n>=length()) {
			return;
		}
		Node<E> p = head;
		Node<E> holder = null;
		if(n==0) {
			if(length()==1) {
				head = null;
				size--;
				return;
			}
			holder = p.getNext();
			p.setNext(null);
			head = holder;
			size--;
		}
		
		if(n!=0) {
		for(int i=1; i<n; i++) {
			p=p.getNext();
		}
		p.setNext(p.getNext().getNext());
		size--;
		}
	}

	public String toString() {
		String result = length() + ":[";
		for (Node<E> p = head; p != null; p = p.getNext()) {
			result += p.getElement();
			if (p.getNext() != null) {
				result += ", ";
			}
		}
		result += "]";
		return result;
	}
}
