import java.util.NoSuchElementException;

/**
 * Represents a generic linked list.
 * 
 * The list can hold objects of any type.
 */
public class LinkedList<E> {
	private Node<E> first; // Points to the first node in the list (just after the dummy node)
	private Node<E> last; // Points to the last node in the list
	private int size; // Number of list elements

	/**
	 * Creates a list with 0 elements.
	 */
	public LinkedList() {
		// Starts with a dummy node, to avoid handling empty lists.
		Node<E> dummy = new Node<E>(null);
		this.first = dummy;
		this.last = first;
		this.size = 0;
	}

	/**
	 * Adds the given element to the beginning of this list.
	 * 
	 * @param e the element to add to the list.
	 */
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e);
		newNode.next = this.first.next;
		this.first.next = newNode;
		if (this.size == 0) {
			this.last = newNode;
		}
		this.size++;

	}

	/**
	 * Returns the index of the given element in this list, or -1 if not found.
	 * the function return the last appearance
	 * 
	 * @param e the returned index will be the index of e.
	 * @return the index of the last occurrence of the specified element, or -1 if
	 *         not found
	 */
	public int indexOf(E e) {
		Node<E> temp = this.first.next;
		int lastindext = -1;
		for (int i = 0; i < this.size; i++) {
			if (temp.e.equals(e)) {
				lastindext = i;
			}
			temp = temp.next;
		}
		return lastindext;
	}

	/**
	 * The function removes an element from a linked list based on the provided
	 * index.
	 * 
	 * @param index
	 */
	public void remove(int index) {
		// throw an exception if the index is not valid
		if (index > size - 1 || index < 0) {
			throw new IllegalArgumentException(index + " is not valid.");
		}
		Node<E> pre = this.first.next;
		for (int i = 0; i < index - 1; i++) {
			pre = pre.next;
		}
		if (index == 0) {
			this.first = this.first.next;
			this.size--;
		} else {
			Node<E> cur = pre.next;
			if (cur.next == null) {
				this.last = pre;
				pre.next = null;
			} else {
				pre.next = cur.next;
				cur = null;
			}
			this.size--;
		}
	}

	/**
	 * Returns the first element in this list.
	 * 
	 * @return the first element in this list.
	 * @throws NoSuchElementException if the list is empty
	 */
	public E getFirst() {
		// throw an exception is the size is 0
		if (this.size == 0) {
			throw new NoSuchElementException("This list is empty");
		}
		return this.first.next.e;
	}

	/**
	 * Returns the last element in this list and remove it.
	 * 
	 * @return the last element in this list.
	 * @throws NoSuchElementException if the list is empty
	 */
	public E getLast() {
		// check if the list is empty
		if (this.size == 0) {
			throw new NoSuchElementException("the list is empty.");
		}
		Node<E> cur = this.first;
		for (int i = 0; i < this.size - 1; i++) {
			cur = cur.next;
		}
		E value = cur.next.e;
		cur.next = null;
		this.size--;
		this.last = cur;
		return value;
	}

	/**
	 * Returns the size of this list.
	 * 
	 * @return the size of this list.
	 */
	public int size() {
		return this.size;
	}

	public static void main(String[] args) {

	}

}
