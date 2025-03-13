/**
 * This class implements a Queue data structure using a linked list.
 * Queues are a first-in, first-out (FIFO) data structure where the first
 * element added is the first to be removed.
 * 
 * This implementation uses a linked list to store the elements.
 * 
 * @param <E> the type of elements in the queue
 */
public class Queue<T> {
    // fields
    private LinkedList<T> q;
    private int size;

    /**
     * Constructs a new empty Queue object with an initial size of 0 and a linked
     * list
     * implementation using a LinkedList object.
     */
    public Queue() {
        // Set the initial size to 0
        this.size = 0;
        // Initialize the LinkedList object to store the queue elements
        this.q = new LinkedList<>();
    }

    /**
     * The function adds an element to the queue in a first-in, first-out (FIFO)
     * order
     * 
     * @param t
     */
    public void add(T t) {
        q.addFirst(t);
        this.size++;
    }

    /**
     * The function returns the last element that is currently in the queue,
     * the element that was added first and has been waiting in the queue the
     * longest.
     * 
     * @return the element that has been waiting in the queue the longest
     */
    public T get() {
        if (this.q == null || size == 0) {
            return null;
        } else {
            size--;
            return q.getLast();
        }
    }

    /**
     * The function receives an element and removes it.
     * 
     * @param t
     */
    public void remove(T t) {
        int index = this.q.indexOf(t);
        if (index != -1) {
            q.remove(index);
            this.size--;
        }
    }

    /**
     * @return the size of the queue
     */
    public int getSize() {
        return this.size;
    }

    public static void main(String[] args) {

    }
}
