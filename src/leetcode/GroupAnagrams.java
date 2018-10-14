package leetcode;

import java.util.*;


/**
 * PROBLEM STATEMENT
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list;
        for(String str: strs) {
            String reArrangedStr = rearrange(str);
            if (map.containsKey(reArrangedStr)) {
                // extract the value, add the item to the list and put it back in the map
                list = map.get(reArrangedStr);
            } else {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(reArrangedStr, list);
        }
        // iterate over the map and constrcut an list of lists
        List<List<String>> listOfLists = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            listOfLists.add(entry.getValue());
            System.out.println(entry.getValue());
        }
        return listOfLists;
    }

    /**
     * Helper method to convert the string to char array and sort the characters
     in alphabetical order
     */
    private static String rearrange(String str) {
        char[] charss = str.toCharArray();
        Arrays.sort(charss);
        return new String(charss);
    }

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(str);
    }
}