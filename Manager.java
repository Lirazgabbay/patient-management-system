/**
 * The Manager class hold all the relevant information for a Manager: Heap and
 * queue
 * 
 * the manager class holds maxheap and queue data structure to store all
 * elements based on both priority and creation order
 */
public class Manager<T extends Comparable<T>> {
    private Heap<T> maxheap; // storing all elements according to priority.
    private Queue<T> queue; // storing all elements by order of insertion.

    /**
     * Constructs a new empty Heap and Queue objects, each holds the elements in the
     * system.
     */
    public Manager() {
        this.maxheap = new Heap<>();
        this.queue = new Queue<>();
    }

    /**
     * The function adds an element to both the heap and the queue data structures.
     * 
     * @param t- the element to be added to this manager data.
     */
    public void add(T t) {
        this.maxheap.add(t);
        this.queue.add(t);
    }

    /**
     * the function returns the element with the earliest creation time and
     * removes it from the system.
     * 
     * @return T - the element with the earliest creation time
     */
    public T getByCreationTime() {
        T t = queue.get();
        maxheap.remove(t);
        return t;
    }

    /**
     * the function returns the element with the highest priority and removes it
     * from the system. 
     */
    public T getByPriority() {
        T t = maxheap.get();
        queue.remove(t);
        return t;
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        if (this.queue.getSize() == 0) {
            return true;
        }
        return false;
    }
}
