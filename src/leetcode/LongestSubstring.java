package leetcode;

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
        if ( s.equals(" ")) {return 1;}
        if(s.isEmpty()) return 0;

        int longestStreak = 0;
        int lastKnownGoodIndex = 0;
        String longestSubstring = "";

        for(int i=0; i<s.length(); i++) {
            int index = longestSubstring.indexOf(s.charAt(i));

            if(index == -1) {
                longestSubstring = longestSubstring + s.charAt(i);

                if(longestStreak < longestSubstring.length()) {
                    longestStreak = longestSubstring.length();
                }
            }
            else {
                if (lastKnownGoodIndex <= index && index < s.length() ) {
                    lastKnownGoodIndex = index + 1;
                }
                if(longestStreak < longestSubstring.length()) {
                    longestStreak = longestSubstring.length();
                }
                longestSubstring = longestSubstring + s.charAt(i);

                longestSubstring = new String(longestSubstring.subSequence(lastKnownGoodIndex, longestSubstring.length()).toString());
                lastKnownGoodIndex = 0;
            }

        }
        return longestStreak;
    }


    public static void main(String[] args) {

        String str1 = "abcdecfgh";
        int length = LongestSubstring.lengthOfLongestSubstring(str1);
        System.out.println(length);
    }

}
