import java.util.Scanner;
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
            SequentialSearchST sst = new SequentialSearchST<Integer, Integer>();
            BinarySearchST bst = new BinarySearchST<Integer, Integer>();
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < max; i++) {
                bst.put(i, i);
                sst.put(i, i);
                int ele = i + 1;
                bst.get(ele);
                sst.get(ele);
                if (sst.count == bst.count * 10) {
                    System.out.println("10 times"+" "+ sst.count +" "+bst.count);
                }
                if (sst.count == bst.count * 100) {
                    System.out.println("100 times"+" "+ sst.count + " "+bst.count);
                }
                if (sst.count == bst.count * 1000) {
                    System.out.println("1000 times"+" "+ sst.count +" " +bst.count);
                    break;
                }
            }/*
            AvgCase a = new AvgCase();
            a.avgCase();*/
        }
}
/*class AvgCase{
    SequentialSearchST sst;
    BinarySearchST bst;
    Scanner sc;
    public void avgCase(){
        sc = new Scanner(System.in);
        bst = new BinarySearchST<Integer, Integer>();
        sst = new SequentialSearchST<Integer, Integer>();
        int noOfInputs = Integer.parseInt(sc.nextLine());
        for(int i=0; i< noOfInputs;i++){
            int tok = Integer.parseInt(sc.nextLine());
            bst.put(tok, 0);
            sst.put(tok, 0);
        }
        while(sc.hasNext()){
            int temp = Integer.parseInt(sc.nextLine());
            boolean bstFlag = bst.contains(temp , true);
            boolean sstFlag = sst.contains(temp, true);
            System.out.println("fastness: "+sst.count/bst.count+" Times, sst count: "+sst.count+" bst count: "+bst.count);
        }
    }
    
}*/
