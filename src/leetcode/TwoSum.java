package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * PROBLEM DESCRIPTION
 *Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 *
 *
 * Complexity Achieved: time - O(n) with one pass approach
 * Space: O(n) since an additional HashMap is needed
 */
public class TwoSum {

    Map<Integer, Integer> map = new HashMap<>();
    public int[] twoSum() {

        int[] nums = new int[4];
        nums[0] = -3;
        nums[1] = 4;
        nums[2] = 3;
        nums[3] = 90;

        int target =0;

        int[] retVal = new int[2];
        retVal[0] = -1;
        retVal[1] = -1;

        for(int i=0; i<nums.length; i++) {
            int diff = -1;
            if(i == 0) {
                map.put(nums[i], i);
            }
            else {
                    diff = map.containsKey(target - nums[i])? map.get(target - nums[i]):-1;
                if (diff != -1) {
                    retVal[0] = diff;
                    retVal[1] = i;
                    return retVal;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return retVal;
    }

    public static void main(String args[]) {
        TwoSum twoSum = new TwoSum();
        twoSum.twoSum();
    }
}
