package leetcode.arrays_strings;

public class StrToInt {
    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        int index = 0, num = 0;

        // skip leading zeroes
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        // termiate if index has reached the end or the current index is NOT a digit
        if (index == s.length() ||
                (!isDigit(s.charAt(index)) && !isSign(s.charAt(index))))
            return num;

        // get negative/positive sign
        boolean isNegative = false;
        if (isSign(s.charAt(index))) {
            isNegative = s.charAt(index) == '-';
            index++;
        }

        int currBase, prevBase;
        // parse number
        while (index < s.length() && isDigit(s.charAt(index))) {
            prevBase = num;
            num = num * 10 + s.charAt(index) - '0';
            currBase = (num - (s.charAt(index) - '0')) / 10;
            // check if exists integer overflow
            if (num < prevBase || prevBase != currBase) {
                if (isNegative) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            index++;
        }

        // return
        if (isNegative) return -num;
        return num;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    public static void main(String[] args) {
        System.out.println( myAtoi("2147483648"));
    }
}
