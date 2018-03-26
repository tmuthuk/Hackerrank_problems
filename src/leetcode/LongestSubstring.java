package leetcode;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 Examples:
 Given "abcabcbb", the answer is "abc", which the length is 3.
 Given "bbbbb", the answer is "b", with the length of 1.
 Given "pwwkew", the answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int j=0, i=0; j<s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maxLength = Math.max(maxLength, j - i +1);
            map.put(s.charAt(j), j+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {

        String str1 = "abcdecfgh";
        int length = LongestSubstring.lengthOfLongestSubstring(str1);
        System.out.println(length);
    }

}
