import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	protected Solution() {

	}
	/** Don't modify this method.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cases = scan.nextLine();

		switch (cases) {
		case "loadDictionary":
			// input000.txt and output000.txt
			BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
			while (scan.hasNextLine()) {
				String key = scan.nextLine();
				System.out.println(hash.get(key));
			}
			break;

		case "getAllPrefixes":
			// input001.txt and output001.txt
			T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
			while (scan.hasNextLine()) {
				String prefix = scan.nextLine();
				for (String each : t9.getAllWords(prefix)) {
					System.out.println(each);
				}
			}
			break;

		case "potentialWords":
			// input002.txt and output002.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			int count = 0;
			while (scan.hasNextLine()) {
				String t9Signature = scan.nextLine();
				for (String each : t9.potentialWords(t9Signature)) {
					count++;
					System.out.println(each);
				}
			}
			if (count == 0) {
				System.out.println("No valid words found.");
			}
			break;

		case "topK":
			// input003.txt and output003.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			Bag<String> bag = new Bag<String>();
			int k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				bag.add(line);
			}
			for (String each : t9.getSuggestions(bag, k)) {
				System.out.println(each);
			}

			break;

		case "t9Signature":
			// input004.txt and output004.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			bag = new Bag<String>();
			k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (String each : t9.t9(line, k)) {
					System.out.println(each);
				}
			}
			break;

		default:
			break;

		}
	}
	/**
	 * { function_description }.
	 *
	 * @param      file  The file
	 *
	 * @return     { description_of_the_return_value }
	 */

	public static String[] toReadFile(String file) {
		In in = new In(file);
		return in.readAllStrings();
	}
	/**
	 * Loads a dictionary.
	 *
	 * @param      file  The file
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static BinarySearchST<String, Integer> loadDictionary(String file) {
		BinarySearchST<String, Integer>  st = new BinarySearchST<String, Integer>();
		// your code goes here
		for (String w : toReadFile(file)) {
			w = w.toLowerCase();
			if (st.contains(w)) {
				st.put(w, st.get(w)+1);
			} else {
				st.put(w, 1);
			}
		}
		return st;
	}
}
/**
 * Class for t 9.
 */
class T9 {
	/**
	 * { var_description }.
	 */
	TST tst = new TST();
	public T9(BinarySearchST<String, Integer> st) {
		// your code goes here
		for (String k : st.keys()) {
			tst.put(k, st.get(k));
		}
	}
	/** get all the prefixes that match with given prefix.
	*/
	public Iterable<String> getAllWords(String prefix) {
		// your code goes here
		return tst.keysWithPrefix(prefix);
	}
	/**
	 * { function_description }.
	 *
	 * @param      t9Signature  The t 9 signature
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Iterable<String> potentialWords(String t9Signature) {
		// your code goes here
		return null;
	}

	/** return all possibilities(words), find top k with highest frequency.
	*/
	public Iterable<String> getSuggestions(Iterable<String> words, final int k) {
		// your code goes here
		//for (String s : )
		return null;
	}

	/** final output
	// Don't modify this method.
	*/
	public Iterable<String> t9(String t9Signature, final int k) {
		return getSuggestions(potentialWords(t9Signature), k);
	}
}
