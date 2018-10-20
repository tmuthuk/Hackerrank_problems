package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem Description
 * We are given two sentences A and B.  (A sentence is a string of space separated words.
 * Each word consists only of lowercase letters.)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 *
 * Return a list of all uncommon words.
 *
 * You may return the list in any order.
 *
 * Example 1:
 *
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 *
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 *
 *
 * Note:
 *
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 */

public class UncommonWords {
    Map<String, Integer> mapOfStrings = new HashMap<>();
    public String[] uncommonFromSentences(String A, String B) {
        // List of uncommon words

        // split the string by space character
        String[] arrA = A.split(" ");
        String[] arrB = B.split(" ");

        for (String item: arrA) {
            processSetItem(item);
        }

        for (String item: arrB) {
            processSetItem(item);
        }

        // finally put all the items in the String array
        // find the to Array method
        List<String> items = new ArrayList<>();
        for (Map.Entry<String, Integer> item: mapOfStrings.entrySet()) {
            if (item.getValue() == 1) {
                items.add(item.getKey());
            }
        }
        String[] retVal = items.toArray(new String[0]);

        return retVal;
    }

    private void processSetItem(String item) {
        // find if the item is in the Map

        if (mapOfStrings.containsKey(item)) {
            mapOfStrings.put(item, mapOfStrings.get(item) + 1);
        } else {
            mapOfStrings.put(item, 1);
        }
    }
}
