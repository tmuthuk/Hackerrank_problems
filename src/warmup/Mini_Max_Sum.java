package warmup;


import java.util.Scanner;

public class Mini_Max_Sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        long max = arr[0];
        long min = arr[0];
        long sum = arr[0];

        for (int i=1; i<5; i++) {
            if(arr[i] >= 1 && arr[i] <= Math.pow(10, 9)) {
                if(arr[i] < min) {
                    min = arr[i];
                }
                if(arr[i] > max) {
                    max = arr[i];
                }
                sum += arr[i];
            }
        }

        System.out.println((sum - max) + " " + (sum - min));
    }
}
