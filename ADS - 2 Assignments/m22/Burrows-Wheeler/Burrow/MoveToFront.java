import java.util.Arrays;
import java.util.LinkedList;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {
    private static final int lgR = 8;

    public static void encode() {
        LinkedList<Integer> ascii = new LinkedList<Integer>();
        final int R = 256;
        for(int i = 0; i < R; i++) {
            ascii.add(i);
        }
        while(!BinaryStdIn.isEmpty()) {
            int ch = BinaryStdIn.readChar();
            int index = ascii.indexOf(ch);
            BinaryStdOut.write(index, lgR);
            ascii.remove(index);
            ascii.add(0, ch);
        }
        BinaryStdOut.close();
    }

    public static void decode() {
        LinkedList<Integer> vals = new LinkedList<Integer>();
        final int R = 256;
        for(int i = 0; i < R; i++) {
            vals.add(i);
        }
        while(!BinaryStdIn.isEmpty()) {
            int index = BinaryStdIn.readChar();
            int  c = vals.get(index);
            BinaryStdOut.write(c, lgR);
            vals.remove(index);
            vals.add(0, c);
        }
        BinaryStdOut.close();
    }

    public static void main(String[] args) {
        if      (args[0].equals("-")) encode();
        else if (args[0].equals("+")) decode();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}
