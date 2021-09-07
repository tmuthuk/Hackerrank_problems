package leetcode.dp;

/**
 * LC Medium
 *
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 *
 *
 *
 */
public class LPS {
    public int longestPalindromeSubseq(String s) {
        // Solved by myself
        // Longest Palindromic Sequence
        int[][] LPS = new int[s.length()+1][s.length()+1];

        StringBuilder sReversedBuilder = new StringBuilder(s);
        String reversed = sReversedBuilder.reverse().toString();

        for(int i=1; i<=s.length(); i++) {
            for(int j=1; j<=s.length(); j++) {
                if(s.charAt(i-1) == reversed.charAt(j-1)) {

                    LPS[i][j] = 1 + LPS[i-1][j-1];
                } else {
                    LPS[i][j] = Math.max(LPS[i-1][j], LPS[i][j-1]);
                }
            }

        }
        return LPS[s.length()][s.length()];
    }
}
