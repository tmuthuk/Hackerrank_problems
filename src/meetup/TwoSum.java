package meetup;

/**
 * Problem Statement:
 * Link: http://blog.sdeskills.com/technical-thursday-04-aug-2016-arrays/
 * Given an array of integers a[] and a target sum T,
 * find two indices (i and j) such that a[i] + a[j] adds up to T. Return both the indices
 int[] TwoSum(int a[], int T)
 Easy: O(n2)
 Easy-Moderate: O(n log n)
 Moderate: O(n), Can use extra space
 */

import java.util.HashMap;

/**
 * My solution: In this program I'm trying the best
 * case scenario with complextity O(n)
 * Uses additional space with O(1) complexity to
 * retrieve the value stored in the hashmap
 */

public class TwoSum {

    public void generateTwoSum() {
//    public static void main(String[] args) {
        int[] sampleArray = {7, 4, 8, 5, 9, 6};
        int target = 15;
        HashMap<Integer, Integer> indexStore = new HashMap<Integer, Integer>();
        for(int i=0; i<sampleArray.length;i++) {
            if(sampleArray[i] < target) {
                int diff = target - sampleArray[i];
                if(indexStore.containsKey(diff)){
                    //Print the indices
                }
            }
        }
    }
}
