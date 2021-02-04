package leetcode;

/*
 Problem Description

 Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

 Constraints:

 The input must be a binary string of length 32

 Note:

 Note that in some languages such as Java, there is no unsigned integer type.
 In this case, the input will be given as a signed integer type.
 It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 In Java, the compiler represents the signed integers using 2's complement notation.
 Therefore, in Example 3 above, the input represents the signed integer. -3.

 2's complement:
 Step 1: Invert 1s to 0s and 0s to 1s
 Step 2: Add 1 to the result from step 1

 In two's complement notation, a non-negative number is represented by its ordinary binary representation;
 in this case, the most significant bit is 0. Though, the range of numbers represented is not the same as with unsigned binary numbers.
 For example, an 8-bit unsigned number can represent the values 0 to 255 (11111111).
 However a two's complement 8-bit number can only represent positive integers from 0 to 127 (01111111),
 because the rest of the bit combinations with the most significant bit as '1' represent the negative integers −1 to −128.
 */

import java.util.HashMap;
import java.util.Map;

public class Count1Bits {
    private static int countBits(int num) {
        int count = 0;

        /*
          We'll begin with base 10/ decimal number 1 => 00000000000000000000000000000001
          With the given constraint that the input is always a 32 bit number, the trick is to left shift (LOC 55) this
          binary value by 1 position in each iteration for 32 times
          It looks like this:
          i=0 ; n=00000000000000000000000000000001
          i=1 ; n=00000000000000000000000000000010
          ...
          i=31 ; n=10000000000000000000000000000000
         */
        int n = 1; // This variable will be used as a mask for the num

        int i = 0;
        while(i < 32) {
            /*
             * The AND operation of the given input and the mask variable, will tell us if the bit is set(1)
             * in the current i position.
             * If yes, the result of num & n will be a non-zero value.
             * Remember that a bit is set at position i iff we do 1 & 1
             */
            if((num & n) != 0) {
                count ++;
            }
            n = n << 1; // left shift by 1 position
            i++;
        }

        System.out.println("input: "+ num +", count: " + count);
        return count;
    }
    public static void main(String[] args) {
        countBits(-217);
        countBits(-5);
        countBits(5);
    }
}
