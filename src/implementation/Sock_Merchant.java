package implementation;

import java.util.*;

public class Sock_Merchant {

    static int sockMerchant(int n, int[] ar) {
        // Complete this function
        int totalPairs = 0;
        List<Integer> pairs = new ArrayList<Integer>();
        for(int i=0; i<ar.length;i++) {
            Integer color = new Integer(ar[i]);
            if(pairs.contains(color)) {
                totalPairs ++;
                pairs.remove(color);
            } else {
                pairs.add(color);
            }
        }
        return totalPairs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
