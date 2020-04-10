package implementation;

import java.util.*;

public class Apple_and_orange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }

        int apple_count = 0;
        int orange_count = 0;
        for (int i=0;i<apple.length;i++) {
            if (apple[i] >= 0) {
                int d = apple[i];
                apple_count += (((a + d) >= s) && ((a + d) <= t))? 1 : 0;
            }
        }

        for(int i=0;i<orange.length;i++) {
            if (orange[i] <= 0){
                int d = orange[i];
                orange_count += (((b + d) >= s) && ((b + d) <= t)) ? 1: 0;
            }}

        System.out.println(apple_count);
        System.out.println(orange_count);
    }
}
