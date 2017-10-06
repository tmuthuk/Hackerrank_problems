package implementation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Grading_Students {
    static int[] solve(int[] grade){
        // Complete this function
        int[] result = new int[grade.length];
        for(int i =0; i< grade.length; i++) {
            // bounds
            if(grade[i]>=0 && grade[i]<=100) {
                // >38
                if(grade[i] >= 38) {
                    int mod = grade[i] % 5;
                    result[i] = (5 - mod < 3)?( grade[i] +  5 - mod ): grade[i];
                }
                // <38
                else {
                    result[i] = grade[i];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
    }
}
