package leetcode.arrays_strings;

import java.util.HashMap;
import java.util.Map;

/** Problem # 833 - Medium
 * You are given a 0-indexed string s that you must perform k replacement operations on. The replacement operations are given as three 0-indexed parallel arrays, indices, sources, and targets, all of length k.
 *
 * To complete the ith replacement operation:
 *
 * Check if the substring sources[i] occurs at index indices[i] in the original string s.
 * If it does not occur, do nothing.
 * Otherwise if it does occur, replace that substring with targets[i].
 * For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i] = "eee", then the result of this replacement will be "eeecd".
 *
 * All replacement operations must occur simultaneously, meaning the replacement operations should not affect the indexing of each other. The testcases will be generated such that the replacements will not overlap.
 *
 * For example, a testcase with s = "abc", indices = [0, 1], and sources = ["ab","bc"] will not be generated because the "ab" and "bc" replacements overlap.
 * Return the resulting string after performing all replacement operations on s.
 *
 * A substring is a contiguous sequence of characters in a string.
 */
public class FindAndReplaceString {
    public String findReplaceString(String s,
                                    int[] indices,
                                    String[] sources,
                                    String[] target) {

        // map indices -> source and source -> target
        // split the string into char array
        //

        Map<Integer, String> indexToSource = new HashMap<Integer, String>();

        for(int i=0; i<indices.length; i++) {
            indexToSource.put(indices[i], sources[i] + ";"+ target[i]);
            // System.out.println(indexToSource.get(indices[i]));
        }

        char[] strArr = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        boolean firstCharFound = false;
        StringBuilder foundStrSoFar = new StringBuilder();
        String findStr ="";
        String replaceStr = "";
        for(int i=0; i<strArr.length; i++) {
            // System.out.println("////==== " + i);

            if(indexToSource.containsKey(i)) {
                String val = indexToSource.getOrDefault(i, "");

                if(val.startsWith(String.valueOf(strArr[i]))) {
                    String[] splitted = val.split(";", 2);
                    findStr = splitted[0];
                    replaceStr = splitted[1];

                    // System.out.println(findStr + "/" + replaceStr);

                    firstCharFound = true;
                    int findStrLen = findStr.length();


                    foundStrSoFar.append(String.valueOf(strArr[i]));
                } else {
                    sb.append(strArr[i]);
                }
                if(foundStrSoFar.length() == findStr.length() && firstCharFound) {
                    sb.append(replaceStr);
                    firstCharFound = false;
                    findStr = "";
                    replaceStr = "";
                }
                continue;
            }

            // System.out.println("at " + strArr[i]);
            // System.out.println("first " + firstCharFound);
            if(foundStrSoFar.length() < findStr.length() && firstCharFound) {
                // append the next char
                // System.out.println("combined Str " + foundStrSoFar + String.valueOf(strArr[i]));
                if(findStr.contains(foundStrSoFar + String.valueOf(strArr[i]))) {
                    // System.out.println("len " + findStr);
                    foundStrSoFar.append( String.valueOf(strArr[i]));
                } else {
                    // reset
                    sb.append(foundStrSoFar);
                    foundStrSoFar = new StringBuilder();
                    firstCharFound = false;
                    findStr = "";
                    replaceStr = "";
                }
            }
            // System.out.println("ddd " + foundStrSoFar.length() == findStr.length()+ "at " + i);
            if(foundStrSoFar.length() == findStr.length() && firstCharFound) {
                // System.out.println("SB appending at " + i);
                sb.append(replaceStr);
                firstCharFound = false;
                findStr = "";
                replaceStr = "";
            } else if(!firstCharFound) {
                // System.out.println("No char found appending " + strArr[i]);
                sb.append(strArr[i]);
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        StringBuilder b = new StringBuilder();

        b.append("haleuu");
        System.out.println(b + "heylooii");
    }
}
