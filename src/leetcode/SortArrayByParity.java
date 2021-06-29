package leetcode;

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
 */

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        for(int i=0,k=0, j=A.length-1; i<A.length  && j>=0;i++) {
            // increment i for even
            if (A[i] % 2 == 0) {
                result[k] = A[i];
                k++;
            } else {
                // decrement j for odd
                result[j] = A[i];
                j--;
            }
        }
        return result;
    }
}
