package interviews;

import java.util.Vector;

/**
 * Onsite tech round:
 *Given a sequence of non-negative integers, find if the sum of
 * contiguous numbers could result in the “target” sum
 *
 * input: [1,2,1,6] , target: 9
 * output: true
 *
 * input: [1,1,1,7], target: 6
 * output: false
 *
 * Run time complexity: O(n)
 */
public class ContiguousSequence {
    public static  boolean findTarget(Vector<Integer> arr, int target) {
        int sum = 0;
        int startIndex = 0;

        for(int i=0; i<arr.size(); i++) {
            if(arr.get(i) == target) return true;

            sum += arr.get(i);

            if(sum > target) {
                while(startIndex < i) {
                    sum -= arr.get(startIndex);
                    if(sum == target) return true;

                    startIndex++;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Vector<Integer> arr = new Vector<>();
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(6);
        System.out.println(findTarget(arr, 9));
    }

}
