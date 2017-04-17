package challenge;

/**
 * Created by Tamilthaaragai on 8/13/2016.
 *
 * HackerRank Problem Desc Link: https://www.hackerrank.com/contests/w22/challenges/cookie-party
 * Description:
 * You're having a cookie party tonight! You're expecting guests and you've already made  cookies.
 * You want to distribute all the cookies evenly between your guests in such a way that each guest
 * receives the same number of whole cookies. If there are not enough cookies to give everyone the
 * same amount, you must make some number of additional cookies.

 Given  and , find and print the minimum number of additional cookies you must make so that
 everybody receives the same number of cookies.

 Input Format:
 A single line of two space-separated integers describing the respective values of  and .

 Constraints:
 1 <= n, m <= 10^9

 Output Format:
 Print a single integer denoting the number of additional cookies you need to make so that everyone
 at the cookie party has the same number of whole cookies.

 Sample Input
 3 2
 Sample Output
 1

 */
public class CookieParty {
    public int findMinCookies(int n, int m) {
        /**
         * Base Algorithm
         * Loop until (n x noc ! = m) :
         *      if n x noc < m then
         *         increment noc
         *      if m < n x noc then
         *         m = n x noc + diffM
         *  Edge cases:
         *  1. when number of people is in negative
         *  2. When number of cookies is in negative
         *  3. When Number of cookies is more than the constraint
         *  4. When any one of the values is not an integer
         *
         *  Complexity: O(1)
         */
        int noc = 1;
        int diffM = 0;

        if(n >= 1 && m>0 && m <= Math.pow(10,9)) {
            if (m > n) {
                noc = m / n; //quotient
                if (m % n != 0) {
                    noc++;
                }
            }
            diffM = n * noc - m;
        }
        return diffM;
    }
}

