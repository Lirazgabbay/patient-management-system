import java.lang.reflect.Array;

/**
 * The Heap class represents a binary heap data structure implemented using an
 * array.
 * It holds the size of the heap and provides methods for resizing, percolating
 * up and down, adding, and removing elements.
 */
public class Heap<T extends Comparable<T>> {
    private T[] arr;
    private int size;

    /**
     * Constructs a new empty Heap object with an initial size of 0.
     * implementation using an Array object of length 100.
     */
    public Heap() {
        this.arr = (T[]) new Comparable[100];
        this.size = 0;
    }

    /**
     * The function 'resize' changes this array to another array with the same
     * elements
     * but double its length.
     */
    public void resize() {
        T[] newArr = (T[]) Array.newInstance(this.arr[1].getClass(), this.arr.length * 2);
        for (int i = 0; i < this.arr.length; i++) {
            newArr[i] = this.arr[i];
        }
        this.arr = newArr;
    }

    /**
     * The function receive an elment and an index
     * 
     * The function perculate an element to the correct spot
     * 
     * @param element
     * @param index
     */
    public void percolateUp(T element, int index) {
        if (index <= 0 || index > size + 1) {
            throw new IllegalArgumentException("Invalid index");
        }
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        this.arr[index] = element;
        while (index != 1 && this.arr[index / 2].compareTo(element) < 0) {
            T temp = this.arr[index / 2];
            this.arr[index / 2] = this.arr[index];
            this.arr[index] = temp;
            index = index / 2;
        }
    }

    /**
     * the function add a new element to the heap
     * 
     * @param t
     */
    public void add(T t) {
        if (this.size + 1 >= this.arr.length) {
            resize();
        }
        percolateUp(t, this.size + 1);
        this.size++;
    }

    /**
     * the function receives an index and remove the element at the index position
     * the function doesn't change the size
     * 
     * @param index
     */
    public void percolateDown(int index) {
        if (size < 2) {
            return;
        }
        this.arr[index] = this.arr[size];
        while (index * 2 <= size) {
            // a leaf
            if (index > size / 2) {
                return;
            }
            // the parent have a single child
            else if (index * 2 == size) {
                if (this.arr[index].compareTo(this.arr[size]) < 0) {
                    // swap
                    T temp = this.arr[size];
                    this.arr[size] = this.arr[index];
                    this.arr[index] = temp;
                }
                break;
            }
            // has two children
            else {
                int max; // save the index of the child with the max value
                this.arr[index] = this.arr[size];
                if (this.arr[index * 2 + 1].compareTo(this.arr[index * 2]) > 0) {
                    max = index * 2 + 1;
                } else {
                    max = index * 2;
                }
                if (this.arr[index].compareTo(this.arr[max]) < 0) {
                    // swap
                    T temp = this.arr[max];
                    this.arr[max] = this.arr[index];
                    this.arr[index] = temp;
                    index = max;
                } else {
                    break;
                }

            }
        }
    }

    /**
     * the function removes the root and return his value
     * 
     * @return the root of the heap
     */
    public T get() {
        if (size == 0) {
            return null;
        }
        T root = this.arr[1];
        if (size == 1) {
            this.arr[1] = null;
            size--;
            return root;
        }
        percolateDown(1);
        this.arr[size] = null;
        this.size--;
        return root;
    }

    /**
     * the function removes the first show of element t
     * 
     * @param t
     */
    public void remove(T t) {
        int index = 1;
        while (index <= this.size) {
            if (!this.arr[index].equals(t)) {
                index++;
            } else {
                percolateDown(index);
                percolateUp(this.arr[index], index);
                this.arr[size] = null;
                this.size--;
                break;
            }
        }

    }

    public static void main(String[] args) {

    }
}
