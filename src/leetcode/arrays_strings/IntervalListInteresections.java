package leetcode.arrays_strings;

import java.util.ArrayList;

/**
 * LC Medium #986
 *
 * You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * A closed interval [a, b] (with a < b) denotes the set of real numbers x with a <= x <= b.
 *
 * The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 * Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Example 2:
 *
 * Input: firstList = [[1,3],[5,9]], secondList = []
 * Output: []
 * Example 3:
 *
 * Input: firstList = [], secondList = [[4,8],[10,12]]
 * Output: []
 * Example 4:
 *
 * Input: firstList = [[1,7]], secondList = [[3,10]]
 * Output: [[3,7]]
 *
 */
public class IntervalListInteresections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length == 0 || secondList.length == 0) {
            return new int[0][0];
        }


        ArrayList<int[]> retVal = new ArrayList();

        int retValIndex = 0;

        // i -> firstList
        // j -> secondList

        int i = 0;
        int j = 0;

        while(i<firstList.length && j<secondList.length) {
            int low = -1;
            int high = -1;
            // i[start] < j[start] && i[end] <j[end] take j[start] and i[end]
            if((firstList[i][0] <= secondList[j][0]) && firstList[i][1] <= secondList[j][1]) {
                low = secondList[j][0];
                high = firstList[i][1];
            } else if(secondList[j][0] <= firstList[i][0] && secondList[j][1] <= firstList[i][1]) {
                low = firstList[i][0];
                high = secondList[j][1];
            } else if(firstList[i][0] < secondList[j][0] && firstList[i][1] > secondList[j][1]) {
                low = secondList[j][0];
                high = secondList[j][1];

            } else if(secondList[j][0] < firstList[i][0] && secondList[j][1] > firstList[i][1]) {
                low = firstList[i][0];
                high = firstList[i][1];
            }

            if(low<=high) {
                retVal.add(new int[]{low, high});
            }

            if((firstList[i][1] < secondList[j][1]) && low!=-1 && high != -1)
                i++;
            else
                j++;
        }
        return retVal.toArray(new int[retVal.size()][]);
    }
}
