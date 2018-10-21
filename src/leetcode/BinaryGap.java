package leetcode;

/**
 * problem Description
 *
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
 *
 * If there aren't two consecutive 1's, return 0.
 *
 * Example 1:
 *
 * Input: 22
 * Output: 2
 * Explanation:
 * 22 in binary is 0b10110.
 * In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
 * The first consecutive pair of 1's have distance 2.
 * The second consecutive pair of 1's have distance 1.
 * The answer is the largest of these two distances, which is 2.
 * Example 2:
 *
 * Input: 5
 * Output: 2
 * Explanation:
 * 5 in binary is 0b101.
 * Example 3:
 *
 * Input: 6
 * Output: 1
 * Explanation:
 * 6 in binary is 0b110.
 * Example 4:
 *
 * Input: 8
 * Output: 0
 * Explanation:
 * 8 in binary is 0b1000.
 * There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
 * Note:
 * 1 <= N <= 10^9
 */
public class BinaryGap {
    public int findBinaryGap(int N) {
        // convert a given integer into a binary representation
        char[] bits = Integer.toBinaryString(N).toCharArray();
        int longest = 0;
        int tmp = 0;
        boolean bitSet = false;

        for(char bit: bits) {
            if(bit == '1') {
                if(!bitSet) {
                    // 1 is seen for the first time
                    bitSet = true;
                    continue; //seeing 1 for the first time
                }
                // if length of tmp is more than
                tmp++; // count once for the 1
                if (longest < tmp) {
                    longest = tmp;
                }
                // reset the temp
                tmp = 0;
            } else {
                // 0 is seen
                if(bitSet) {
                    tmp++;
                }
            }
        }
        return longest;
    }
}
