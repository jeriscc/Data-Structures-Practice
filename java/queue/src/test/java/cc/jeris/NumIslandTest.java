package cc.jeris;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for the num island problem.
 */
public class NumIslandTest {
    /**
     * Island Group 1
     */
    @Test
    public void testOne() {
        char[][] island = {
            { '1', '0', '0' },
            { '0', '1', '0' },
            { '0', '1', '0' },
            { '0', '1', '1' }
        };
        assertTrue("Island One: There should be two islands", NumIslands.getNum(island) == 2);
    }

    /**
     * Island Group 2
     */
    @Test
    public void testTwo() {
        char[][] island = {
            { '1', '0', '1' },
            { '1', '0', '0' },
            { '1', '0', '1' },
            { '1', '1', '1' }
        };
        assertTrue("Island Two: There should be two islands", NumIslands.getNum(island) == 2);
    }

    /**
     * Island Group 3: checkerboard
     */
    @Test
    public void testThree() {
        char[][] island = {
            { '1', '0', '1', '0' },
            { '0', '1', '0', '1' },
            { '1', '0', '1', '0' },
            { '0', '1', '0', '1' }
        };
        assertTrue("Island Three: There should be eight islands", NumIslands.getNum(island) == 8);
    }

    /**
     * Island Group 4: Spiral
     */
    @Test
    public void testFour() {
        char[][] island = {
            { '1', '1', '1', '1', '1' },
            { '0', '0', '0', '0', '1' },
            { '1', '1', '1', '0', '1' },
            { '1', '0', '0', '0', '1' },
            { '1', '1', '1', '1', '1' }
        };
        assertTrue("Island Four: There should be one islands", NumIslands.getNum(island) == 1);
    }
}
