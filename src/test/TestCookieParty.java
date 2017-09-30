package test;

import challenge.CookieParty;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


/**
 * Created by Tamilthaaragai on 8/13/2016.
 */
public class TestCookieParty {
    CookieParty cp = new CookieParty();
    @Test
    public void testEx1() {
        /**
         * when:
         * no. of people < no. of cookies
         * n = 16
         * m = 20
         * noc = 2
         * m` = 12
         */

        int mDiff = cp.findMinCookies(16, 20);
        assertEquals(mDiff, 12);
    }

    @Test
    public void testEx2 () {
        /** when:
         * no. of people > no.of cookies
         * n = 20
         * m = 16
         * noc = 1
         * m` = 4
         */
        int mDiff = cp.findMinCookies(20, 16);
        assertEquals(mDiff, 4);
    }

    @Test
    public void testEx3 () {
        /** When:
         * number of people = number of cookies
         * n = 20
         * m = 20
         * noc = 1
         * m` = 0
         */
        int mDiff = cp.findMinCookies(20, 20);
        assertEquals(mDiff, 0);
    }

    @Test
    public void testEx4() {
        /**
         *
         */
        Double i = Math.pow(10, 8);
        int m =  i.intValue();
        System.out.println(m);
        int mDiff = cp.findMinCookies(15, m);
        System.out.println(mDiff);
    }
 }
