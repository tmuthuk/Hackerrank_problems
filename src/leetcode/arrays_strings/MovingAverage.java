package leetcode.arrays_strings;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * Implement the MovingAverage class:
 *
 * MovingAverage(int size) Initializes the object with the size of the window size.
 * double next(int val) Returns the moving average of the last size values of the stream.
 *
 *
 * Example 1:
 *
 * Input
 * ["MovingAverage", "next", "next", "next", "next"]
 * [[3], [1], [10], [3], [5]]
 * Output
 * [null, 1.0, 5.5, 4.66667, 6.0]
 *
 * Explanation
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // return 1.0 = 1 / 1
 * movingAverage.next(10); // return 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
 */
public class MovingAverage {
    double currentSum;
    Queue<Integer> queue = new LinkedList<Integer>();

    int maxWindowSize;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        maxWindowSize = size;
    }

    public double next(int val) {
        double average;
        if (queue.size() < maxWindowSize) {
            currentSum += val;
        } else {
            // if the stream has hit windowsize, then start decrementing the first element
            int firstVal = queue.poll(); // removes element from the Q
            currentSum = currentSum - firstVal + val;

        }
        queue.offer(val); // adds element to the Q
        average = currentSum / queue.size();

        return average;

    }

}
