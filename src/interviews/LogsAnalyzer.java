package interviews;

/*

Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.

The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

Example:
logs1 = [
    ["58523", "user_1", "resource_1"],
    ["62314", "user_2", "resource_2"],
    ["54001", "user_1", "resource_3"],
    ["200", "user_6", "resource_5"],
    ["215", "user_6", "resource_4"],
    ["54060", "user_2", "resource_3"],
    ["53760", "user_3", "resource_3"],
    ["58522", "user_22", "resource_1"],
    ["53651", "user_5", "resource_3"],
    ["2", "user_6", "resource_1"],
    ["100", "user_6", "resource_6"],
    ["400", "user_7", "resource_2"],
    ["100", "user_8", "resource_6"],
    ["54359", "user_1", "resource_3"],
]

Example 2:
logs2 = [
    ["300", "user_1", "resource_3"],
    ["599", "user_1", "resource_3"],
    ["900", "user_1", "resource_3"],
    ["1199", "user_1", "resource_3"],
    ["1200", "user_1", "resource_3"],
    ["1201", "user_1", "resource_3"],
    ["1202", "user_1", "resource_3"]
]


Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.

Expected Output:
most_requested_resource(logs1) # => ('resource_3', 3)
Reason: resource_3 is accessed at 53760, 54001, and 54060

most_requested_resource(logs2) # => ('resource_3', 4)
Reason: resource_3 is accessed at 1199, 1200, 1201, and 1202

Complexity analysis variables:

n: number of logs in the input

*/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] argv) {

        String[][] logs1 = new String[][] {
                { "58523", "user_1", "resource_1" },
                { "62314", "user_2", "resource_2" },
                { "54001", "user_1", "resource_3" },
                { "200", "user_6", "resource_5" },
                { "215", "user_6", "resource_4" },
                { "54060", "user_2", "resource_3" },
                { "53760", "user_3", "resource_3" },
                { "58522", "user_22", "resource_1" },
                { "53651", "user_5", "resource_3" },
                { "2", "user_6", "resource_1" },
                { "100", "user_6", "resource_6" },
                { "400", "user_7", "resource_2" },
                { "100", "user_8", "resource_6" },
                {"54359", "user_1", "resource_3"},
        };

        String[][] logs2 = new String[][] {
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };

        System.out.println(getAccessLogs(logs1));
        System.out.println(getAccessLogs(logs2));

    }

    public static HashMap<String, ArrayList<Integer>> getAccessLogs(String[][] input) {

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<input.length;i++) {

            String name = input[i][1];
            int ts = Integer.parseInt(input[i][0]);

            if(map.containsKey(name)) {
                ArrayList<Integer> list = map.get(name);

                int start = list.get(0);

                int end = list.get(1);
                // start
                if(ts < start) {
                    list.set(0, ts);
                } else if(ts > end) {
                    list.set(1, ts);

                }
                //end

                map.put(name, list);

            } else {
                // start //end

                ArrayList<Integer> list = new ArrayList<>();
                list.add(ts);
                list.add(ts);
                map.put(name, list);
            }
        }

        return map;
    }

    public static  most_requested_resource(String[][] input) {
        ResourceInfo info = new ResourceInfo();

        HashMap<String, TreeSet<Integer>> map = new HashMap<>();

        for(int i=0; i<input.length;i++) {
            int ts = Integer.parseInt(input[i][0]);
            String resource = input[i][2];

            if(map.containsKey(resource)) {

                TreeSet<Integer> set = map.get(resource);

                set.add(ts);

                map.put(resource, set);

            } else {
                // start //end

                TreeSet<Integer> set = new TreeSet<>();
                set.add(ts);
                map.put(resource, set);
            }

        }



        return info;
    }
}

class ResourceInfo {
    public String resourceName;
    public int count;
}
