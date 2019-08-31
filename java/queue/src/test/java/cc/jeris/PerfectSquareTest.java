package cc.jeris;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for the perfect square problem
 */
public class PerfectSquareTest {

    @Test
    public void test2() {
        PerfectSquare p = new PerfectSquare();
        assertTrue("There are 2 perfect squares minumum in 2", p.numSquares(2) == 2);
    }

    @Test
    public void test7391() {
        PerfectSquare p = new PerfectSquare();
        assertTrue("There are 4 perfect squares minumum in 7391", p.numSquares(7391) == 4);
    }
}
