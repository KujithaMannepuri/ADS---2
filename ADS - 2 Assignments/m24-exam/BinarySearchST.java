import java.util.NoSuchElementException;
/**
 * Class for binary search st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchST<Key extends Comparable<Key>, Value> {
    /**
     * key array.
     */
    private Key[] keys;
    /**
     * val array.
     */
    private Value[] val;
    /**
     * variable num.
     */
    private int num = 0;
    boolean flag;
    int count;
    /**
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    BinarySearchST(final int capacity) {
        keys = (Key[]) new Comparable[capacity];
        val = (Value[]) new Object[capacity];
    }
    /**
     * { var_description }.
     */
    private static final int INIT_CAPACITY = 2;
    /**
     * Constructs the object.
     */
    BinarySearchST() {
        this(INIT_CAPACITY);
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return num;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to contains() is null");
        }
        return get(key) != null;
    }
    public boolean contains(Key key, Boolean flag){
        this.flag = true;
        boolean s = contains(key);
        this.flag = false;
        return s;
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < num && keys[i].compareTo(key) == 0) {
            return val[i];
        }
        return null;
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public int rank(final Key key) {
        count = 0;
        if (key == null) {
            throw new IllegalArgumentException("argument to rank() is null");
        }
        int lo = 0, hi = num - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                 hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
            if(flag){
                count++;
            }
        }
        return lo;
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     * @param      val1  The value 1
     */
    public void put(final Key key, final Value val1)  {
        if (key == null) {
            throw new IllegalArgumentException(
                "first argument to put() is null");
        }
        if (val1 == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < num && keys[i].compareTo(key) == 0) {
            val[i] = val1;
            return;
        }
        if (num == keys.length) {
            resize(2 * keys.length);
        }

        for (int j = num; j > i; j--)  {
            keys[j] = keys[j - 1];
            val[j] = val[j - 1];
        }
        keys[i] = key;
        val[i] = val1;
        num++;

        assert check();
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (isEmpty()) {
            return;
        }
        int i = rank(key);
        if (i == num || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < num - 1; j++)  {
            keys[j] = keys[j + 1];
            val[j] = val[j + 1];
        }
        num--;
        keys[num] = null;
        val[num] = null;
        final int four = 4;
        if (num > 0 && num == keys.length / four) {
            resize(keys.length / 2);
        }
        assert check();
    }
    /**
     * { function_description }.
     */
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow error");
        }
        delete(min());
    }
    /**
     * { function_description }.
     */
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "Symbol table underflow error");
        }
        delete(max());
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "called min() with empty symbol table");
        }
        return keys[0];
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "called max() with empty symbol table");
        }
        return keys[num - 1];
    }
    /**
     * { function_description }.
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Key select(final int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException(
                "called select() with invalid argument: " + k);
        }
        return keys[k];
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Key floor(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to floor() is null");
        }
        int i = rank(key);
        if (i < num && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        } else {
            return keys[i - 1];
        }
    }
    /**
     * { function_description }.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Key ceiling(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to ceiling() is null");
        }
        int i = rank(key);
        if (i == num) {
            return null;
        } else {
            return keys[i];
        }
    }
    /**
     * { function_description }.
     *
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     { description_of_the_return_value }
     */
    public int size(final Key lo, final Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException(
                "first argument to size() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException(
                "second argument to size() is null");
        }

        if (lo.compareTo(hi) > 0) {
            return 0;
        }
        if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }
     /**
      * { function_description }.
      *
      * @param      capacity  The capacity
      */
     private void resize(final int capacity) {
        assert capacity >= num;
        Key[]   keyTemp = (Key[])   new Comparable[capacity];
        Value[] valTemp = (Value[]) new Object[capacity];
        for (int i = 0; i < num; i++) {
            keyTemp[i] = keys[i];
            valTemp[i] = val[i];
        }
        val = valTemp;
        keys = keyTemp;
    }
    /**
     * Determines if sorted.
     *
     * @return     True if sorted, False otherwise.
     */
    private boolean isSorted() {
        for (int i = 1; i < size(); i++) {
            if (keys[i].compareTo(keys[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    private boolean check() {
        return isSorted() && rankCheck();
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) {
                return false;
            }
        }
        for (int i = 0; i < size(); i++) {
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        int i = 0;
        for (i = 0; i < size() - 1; i++) {
            s += keys[i] + " " + val[i] + "\n";
        }
        s += keys[i] + " " + val[i];
        return s;
    }
}