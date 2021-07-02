package leetcode.arrays_strings;

import java.util.*;

public class GroupAnagrams {
    /** Problem 49
     Runtime complexity : O(nklogn)
     klogn - Sorting ofcharacters in a string of length K
     n - length of input array
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> retVal = new ArrayList<List<String>>();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for(int i=0; i<strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sortedString = String.valueOf(arr);
            if(map.containsKey(sortedString)) {

                ArrayList<String> keys = map.get(sortedString);
                keys.add(strs[i]);
                map.put(sortedString, keys);
            } else{
                ArrayList<String> keys = new ArrayList<String>();
                keys.add(strs[i]);
                map.put(sortedString, keys);
            }
        }

        for(Map.Entry<String,ArrayList<String>> entry: map.entrySet()) {
            retVal.add(entry.getValue());
        }

        return retVal;
    }
}
