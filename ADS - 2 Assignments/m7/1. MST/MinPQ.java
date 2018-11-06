import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 * Class for minimum pq.
 *
 * @param  <Key>  The key
 */
class MinPQ<Key> implements Iterable<Key> {
    /**
     * variable pq.
     */
    private Key[] pq;
    /**
     * variable comparator.
     */
    private Comparator<Key> comparator;
    /**
     * variable n for size.
     */
    private int n; 
    /**
     * constructor.
     */
    public MinPQ() {
        this(1);
    }
    /**
     * Constructs the object.
     * Time complexity is 1.
     *
     * @param      initCapacity  The initialize capacity
     */
    public MinPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     *Time complexity is 1.
     * Constructs the object.
     *
     * @param      initCapacity  The initialize capacity
     * @param      comparator    The comparator
     */
    public MinPQ(final int initCapacity, final Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     *Time complexity is 1.
     * Constructs the object.
     * 
     * @param      comparator  The comparator
     */
    public MinPQ(final Comparator<Key> comparator) {
        this(1, comparator);
    }
    /**
     * size function.
     *
     * @return     returns size.
     */
    public int size() {
        return n;
    }
    /**
     * Time complexity is N.
     * resize function.
     *
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    /**
     * Time complexity is N.
     * Constructs the object.
     *
     * @param      keys  The keys
     */
    public MinPQ(final Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++) {
            pq[i+1] = keys[i];
        }
        for (int k = n/2; k >= 1; k--) {
            sink(k);
        }
        assert isMinHeap();
    }

    /**
     * Determines if empty.
     * Time complexity is 1.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }
    /**
     * min function.
     *
     * @return     { description_of_the_return_value }
     */
    public Key min() {
        if (isEmpty()) throw new
            NoSuchElementException("Priority queue underflow");
        return pq[1];
    }
    /**
     * Time complexity is 1. insert function.
     *
     * @param      x     { parameter_description }
     */
    public void insert(Key x) {
        if (n == pq.length - 1) resize(2 * pq.length);
        pq[++n] = x;
        swim(n);
        assert isMinHeap();
    }
    /**
     * exchange function.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    private void exch(final int i, final int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    /**
     * delMin function.
     *
     * @return     { description_of_the_return_value }
     */
    public Key delMin() {
        final int four = 4;
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;
        if ((n > 0) && (n == (pq.length - 1) / four)) resize(pq.length / 2);
        assert isMinHeap();
        return min;
    }
    /**
     * { function_description }.
     *
     * @param      temp  The temporary
     */
    private void sink(final int temp) {
        int k = temp;
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
    /**
     * { function_description }.
     *
     * @param      n1     { parameter_description }
     */
    private void swim(final int n1) {
        int k = n1;
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    /**
     * { function_description }.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    /**
     * Determines if minimum heap.
     * Time complexity is 1.
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap() {
        return isMinHeap(1);
    }
    /**
     * Determines if minimum heap.
     * Time complexity is 1.
     *
     * @param      k     { parameter_description }
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap(final int k) {
        if (k > n) {
            return true;
        }
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left  <= n && greater(k, left)) {
            return false;
        }
        if (right <= n && greater(k, right)) {
            return false;
        }
        return isMinHeap(left) && isMinHeap(right);
    }
    /**
     * iterator function.
     * Time complexity is 1.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }
    /**
     * Class for heap iterator. Time complexity is 1.
     */
    private class HeapIterator implements Iterator<Key> {
        /**
         * { var_description }.
         */
        private MinPQ<Key> copy;
        /**
         * Constructs the object.
         */
        HeapIterator() {
            if (comparator == null) {
                copy = new MinPQ<Key>(size());
            } else {
                copy = new MinPQ<Key>(size(), comparator);
            }          
            for (int i = 1; i <= n; i++) {
                copy.insert(pq[i]);
            }
        }
        /**
         * remove function.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return !copy.isEmpty();
        }
        /**
         * next function.
         *
         * @return     { description_of_the_return_value }
         */
        public Key next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.delMin();
        }
    }
}