package leetcode;
import java.util.Arrays;

/*
    Problem Description:
    Reverse bits of a given 32 bits unsigned integer.

    Note:

    Note that in some languages such as Java, there is no unsigned integer type.
    In this case, both input and output will be given as a signed integer type.
    They should not affect your implementation, as the integer's internal binary representation is the same,
    whether it is signed or unsigned.
    In Java, the compiler represents the signed integers using 2's complement notation.
    Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
    Follow up:

    If this function is called many times, how would you optimize it?

    Example 1:

    Input: n = 00000010100101000001111010011100
    Output:    964176192 (00111001011110000010100101000000)
    Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
    so return 964176192 which its binary representation is 00111001011110000010100101000000.
    Example 2:

    Input: n = 11111111111111111111111111111101
    Output:   3221225471 (10111111111111111111111111111111)
    Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293,
    so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 */

// Achieved runtime - 2 ms and memory usage 38.5 MB
public class ReverseBits {
    // you need treat n as an unsigned value
    public static void reverseBits(int n) {

        String binStr = Integer.toBinaryString(n);
        char[] binChar = binStr.toCharArray();
        char[] arr = new char[32];

        char[] buff = new char[32];

        if(binChar.length < 32) {
            int bufFillLen = (32 - binChar.length);
            Arrays.fill(arr, 0, bufFillLen, '0');
            // System.arraycopy(buff, 0, arr, 0, bufFillLen);
            System.arraycopy(binChar, 0, arr, bufFillLen, binChar.length);
            buff = arr;
        } else {
            buff = binChar;
        }

        int num = (int) Long.parseLong(String.valueOf(buff), 2);


        int k = 0;
        long result = 0;
        int ni = 1;

        while(k < 32) {
            if((num & ni) != 0) {
                result += Math.pow(2, (31 - k));
            }
            ni = ni<<1;
            k++;
        }

        // Binary String approach


        // char[] binCharCopy = buff;

//         for(int i=0, j=buff.length -1; i<buff.length/2; i++, j--) {

//             char temp = buff[i];
//             buff[i] = binCharCopy[j];
//             buff[j] = temp;
//             System.out.println("i: " +i + " j: " + j+" bin str " + String.valueOf(buff));
//         }

//         System.out.println("bin str " + String.valueOf(buff));
//         long l = Long.parseLong(String.valueOf(buff),2);
//         int retVal = (int)l;
        System.out.println((int) result);
    }

    public static void main(String[] args) {
        reverseBits(43261596);
        reverseBits(-3);

    }
}
