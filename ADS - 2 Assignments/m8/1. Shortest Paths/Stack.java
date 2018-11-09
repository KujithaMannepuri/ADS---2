/******************************************************************************
 *  Compilation:  javac Stack.java
 *  Execution:    java Stack < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/13stacks/tobe.txt
 *
 *  A generic stack, implemented using a singly-linked list.
 *  Each stack element is of type Item.
 *
 *  This version uses a static nested class Node (to save 8 bytes per
 *  Node), whereas the version in the textbook uses a non-static nested
 *  class (for simplicity).
 *
 *  % more tobe.txt
 *  to be or not to - be - - that - - - is
 *
 *  % java Stack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * List of .
 *
 * @param      <Item>  The item
 */
public class Stack<Item> implements Iterable<Item> {
    /**
     * { var_description }.
     */
    private Node<Item> first;     // top of stack
    /**
     * { var_description }.
     */
    private int n;                // size of the stack
    /**
     * Class for node.
     *
     * @param      <Item>  The item
     */
    private static class Node<Item> {
        /**
         * { var_description }.
         */
        private Item item;
        /**
         * { var_description }.
         */
        private Node<Item> next;
    }

    /**
     * Initializes an empty stack.
     */
    public Stack() {
        first = null;
        n = 0;
    }

    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    public int size() {
        return n;
    }
    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    public void push(final Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }
    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }
        return first.item;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of items in this
     * stack in LIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
    /**
     * Returns an iterator to this stack that
     * iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that
     * iterates through the items in LIFO order
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }
/**
 * Class for list iterator.
 *
 * @param      <Item>  The item
 */
    private class ListIterator<Item> implements Iterator<Item> {
        /**
         * { var_description }.
         */
        private Node<Item> current;
/**
 * Constructs the object.
 *
 * @param      fst  The fst
 */
        ListIterator(final Node<Item> fst) {
            current = fst;
        }
/**
 * Determines if it has next.
 *
 * @return     True if has next, False otherwise.
 */
        public boolean hasNext() {
            return current != null;
        }
/**
 * { function_description }.
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
    /**
     * Unit tests the {@code Stack} data type.
     *
     * @param args the command-line arguments
     */
   /* public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }*/
}

