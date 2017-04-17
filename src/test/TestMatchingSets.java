import challenge.CookieParty;
import challenge.MatchingSets;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Tamilthaaragai on 8/14/2016.
 *
 */
public class TestMatchingSets {
    MatchingSets ms ;
    int[] arrX = {-1, 3, 2, 0, 2, 5};
    int[] arrY = {-1, 3, 2, 0, 0, 7};

    @Test
    public void testAreArraysEqual() {
        ms = new MatchingSets(arrX, arrY);
        ms.areArraysEqual();
    }

    @Test
    public void testCompareArrays() {
       ms = new MatchingSets(arrX, arrY);
        ms.matchingSetsDriver();
//       assertEquals(nop, 2);
    }
}
