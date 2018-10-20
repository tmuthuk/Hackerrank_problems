package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Description
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 * Note:
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * Tip to yourself.. Instead of using two separate lists,
 * use the finalArray and do a two pass on the input
 */

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        // Sort by even and odd

        // iterate through each item in the list
        List<Integer> evenBkt = new ArrayList<>();
        List<Integer> oddBkt = new ArrayList<>();
        int arrSize = A.length;
        for(int item: A) {
            if (item % 2 == 0) {
                evenBkt.add(item);
            } else {
                oddBkt.add(item);
            }
        }

        // combine both the buckets in the int array
        int[] finalArr = new int[arrSize];
        int i = 0;
        for(int item: evenBkt) {
            finalArr[i] = item;
            i++;
        }

        for(int item: oddBkt) {
            finalArr[i] = item;
            i++;
        }
        return finalArr;
    }
}
