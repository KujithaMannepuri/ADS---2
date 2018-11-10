/*************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag < input.txt
 *
 *  A generic bag or multiset, implemented using a linked list.
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for bag.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**
     * variable num.
     */
    private int num;         // number of elements in bag
    /**
     * Node first.
     */
    private Node first;    // beginning of bag
    // helper linked list class
    /**
     * Class for node.
     */
    private class Node {
        /**
         * { var_description }.
         */
        private Item item;
        /**
         * { var_description }.
         */
        private Node next;
    }
   /**
     * Create an empty stack.
     */
    public Bag() {
        first = null;
        num = 0;
    }
    /**
     * Is the BAG empty?.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * Return the number of items in the bag.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return num;
    }
   /**
    * { function_description }.
    *
    * @param      item  The item
    */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        num++;
    }
    /**
     * Return an iterator that iterates over the items in the bag.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }
    // an iterator, doesn't implement remove() since it's optional.
    /**
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * { var_description }.
         */
        private Node current = first;
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * remove function.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * { function_description }.
         *
         * @return     { description_of_the_return_value }
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

