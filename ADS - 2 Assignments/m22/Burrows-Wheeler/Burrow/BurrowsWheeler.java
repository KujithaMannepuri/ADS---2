import java.util.HashMap;
import java.util.Arrays;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.Queue;
public class BurrowsWheeler {
    public static void transform() {
    	String ip = BinaryStdIn.readString();
    	CircularSuffixArray csa = new CircularSuffixArray(ip);
    	for (int i = 0; i < csa.length(); i++) {
    		if (csa.index(i) == 0) {
    			BinaryStdOut.write(i);
    			break;
    		}
    	}
    	for (int i = 0; i < csa.length(); i++) {
    		if (csa.index(i) == 0) {
    			BinaryStdOut.write(ip.charAt(ip.length()-1));
    		} else {
    			BinaryStdOut.write(ip.charAt(csa.index(i) - 1));
    		}
    	}
    	BinaryStdOut.close();
    }

    public static void inverseTransform() {
    	int num = BinaryStdIn.readInt();
    	String s = BinaryStdIn.readString();
    	char[] t = s.toCharArray();
    	HashMap<Character, Queue<Integer>> hmap = new HashMap<Character, Queue<Integer>>();
    	for (int i = 0; i < t.length; i++) {
    		if (!hmap.containsKey(t[i])) {
    			hmap.put(t[i], new Queue<Integer>());
    		} 
    		hmap.get(t[i]).enqueue(i);
    	}
    	Arrays.sort(t);
    	int[] nextarr = new int[t.length];
    	for (int i = 0; i < t.length; i++) {
            nextarr[i] = (hmap.get(t[i])).dequeue();
    	}
    	for (int i = 0; i < nextarr.length; i++) {
    		BinaryStdOut.write(t[num]);
    		num = nextarr[num];
    	}
    	BinaryStdOut.close();
    }

    public static void main(String[] args) {
    	if (args.length == 0) {
            throw new IllegalArgumentException("Illegal command line argument");
        }
        if (args[0].equals("-")) {
            transform();
        }
        else if (args[0].equals("+")) {
            inverseTransform();
        }
        else {
            throw new IllegalArgumentException("Illegal command line argument");
        }
    }
}
