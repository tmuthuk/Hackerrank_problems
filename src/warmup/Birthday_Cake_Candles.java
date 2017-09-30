package warmup;


import java.util.Scanner;

public class Birthday_Cake_Candles {
    static int birthdayCakeCandles(int n, int[] ar) {
        // Complete this function
        int max = ar[0];
        int count = 1;
        if(n >= 1 && n <= Math.pow(10, 5)) {
            for(int i=1; i<n; i++) {
                if(ar[i] >= 1 && ar[i] <= Math.pow(10, 7)) {
                    if(ar[i] > max) {
                        count = 1;
                        max = ar[i];
                    }
                    else if(ar[i] == max) {
                        count ++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
