import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] token = loadWords();
        TST<Integer> tst = new TST<Integer>();
        String prefix = sc.nextLine();
        int j = 0;
        for (String word : token) {
            SuffixArray sArr = new SuffixArray(word);
            for (int i = 0; i < word.length(); i++) {
                tst.put(sArr.select(i), j++);
            }
        }
        for (String str : tst.keysWithPrefix(prefix)) {
            System.out.println(str);
        }
    }
    /**
     * Loads words.
     *
     * @return     words
     */
    public static String[] loadWords() {
        In in = new In("/Files/dictionary-algs4.txt");
        String[] words = in.readAllStrings();
        return words;
    }
}

