package leetcode.arrays_strings;

import java.util.*;

/**
 * LC Easy #811
 *
 * A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
 *
 * Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".
 *
 * We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.
 *
 * Example 1:
 * Input:
 * ["9001 discuss.leetcode.com"]
 * Output:
 * ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
 * Explanation:
 * We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
 */
public class Subdomain_Visit_Count {
    public List<String> subdomainVisits(String[] cpdomains) {

        List<String> retVal = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] splits = cpdomain.split(" ");
            int count = Integer.parseInt(splits[0]);

            String[] sp = splits[1].split("\\.", 2);

            ArrayList<String> list = new ArrayList<>();
            list.add(splits[1]);

            map.put(splits[1], map.containsKey(splits[1]) ? (map.get(splits[1]) + count) : count);


            int j = 0;
            while (j < list.size()) {

                String s = list.get(j);
                String[] splitted = s.split("\\.", 2);

                if (splitted.length > 1)
                    map.put(splitted[1], map.containsKey(splitted[1]) ? (map.get(splitted[1]) + count) : count);
                else
                    break;

                if (splitted.length == 2)
                    list.add(splitted[1]);
                j++;

            }
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            retVal.add("" + entry.getValue() + " "+entry.getKey());
        }
        return retVal;

    }
}
