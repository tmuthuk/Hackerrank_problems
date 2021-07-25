package pramp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Source: Pramp
 *
 * Getting a Different Number
 * Given an array arr of unique nonnegative integers, implement a function getDifferentNumber that finds the smallest
 * nonnegative integer that is NOT in the array. Even if your programming language of choice doesn’t have that
 * restriction (like Python), assume that the maximum value an integer can have is MAX_INT = 2^31-1.So, for instance,
 * the operation MAX_INT + 1 would be undefined in our case. Your algorithm should be efficient, both from a time
 * and a space complexity perspectives.
 *
 * Solve first for the case when you’re NOT allowed to modify the input arr. If successful and still have time,
 * see if you can come up with an algorithm with an improved space complexity when modifying arr is allowed.
 * Do so without trading off the time complexity.
 *
 * Analyze the time and space complexities of your algorithm.
 *
 * Example:
 *
 * input:  arr = [0, 1, 2, 3]
 *
 * output: 4
 */
public class FindDifferentNumber {
    static int getDifferentNumber(int[] arr) {
        // your code goes here
        Set<Integer> set = new TreeSet<Integer>();

        // O(n)
        for (int i : arr) {
            set.add(i);
        }

        List<Integer> list = new ArrayList<>(set);
        boolean minFound = false;
        int curMin = 0;
        int i = 0;
        while (!minFound && i < list.size()) {
            int curVal = list.get(i);
            if (!set.contains(curMin)) {
                minFound = true;
            } else {
                curMin = curVal;
                curMin++;
            }
            i++;
        }
        return curMin;
    }

    public static void main(String[] args) {
        //int[] arr = new int[] {1,0,3,4,5}; //{0,1,3,4,5}
        int[] arr = new int[] {100000};
        // 100000
        // 1,0,3,4,5
        // 0,100000
        // 0,99999,100000
        int retVal = getDifferentNumber(arr);
        System.out.println(retVal);
    }
}
