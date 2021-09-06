package interviews;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an integer denoting the number of wheels, help Am logistics find the number of
 * different ways to choose a fleet of vehicles from an infinite supply of two wheeled and four wheeled
 * vehicles such that the group of chosen vehicles has that exact total number of wheels.
 *
 * Two ways of choosing vehicles are considered to be different if and only if they contain different
 * number of two wheeled or four wheeled vehicles
 *
 * Example:
 *
 * input: [4, 5, 6] => [n1, n2, n3...n]
 * An array of total number of wheels. Task is to find out the different ways
 * for EACH "n" of the element in the array
 * Explanation:
 *
 * The number of different combinations possible can be achieved using a simple formula
 * There is a pattern to the combinations. The total combinations possible is changing at every number which is
 * divisible by 4.
 * result = n/4 +  1
 *
 * Time complexity = O(n)
 */
public class NumberOfWheels {

    public static void main(String[] args) {
        int arr[] = findWheelCombinations(new int[]{6, 7, 8}) ;

        for(int n: arr) {
            System.out.println(n);
        }
    }
    public static int[] findWheelCombinations(int[] wheelsArr) {
        int[] resultArr = new int[wheelsArr.length];
        // [4, 5, 6]
        for(int i=0; i<wheelsArr.length; i++) {
            if(wheelsArr[i]%2 != 0) continue; //5
            resultArr[i] = wheelsArr[i]/4 + 1;
        }
        return resultArr;
    }
}
