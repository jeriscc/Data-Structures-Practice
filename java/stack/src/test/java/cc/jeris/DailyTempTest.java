package cc.jeris;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

/**
 * DailyTempTest
 */
public class DailyTempTest {

    DailyTemperature p = new DailyTemperature();

    @Test
    public void testOne() {
        int[] input = {73,74,75,71,69,72,76,73};
        int[] answer = {1,1,4,2,1,1,0,0};
        // Need to use Arrays.equals function to compare array contents
        assertTrue(Arrays.equals(p.dailyTemperatures(input), answer));
        assertTrue(Arrays.equals(p.dailyTempTwo(input), answer));
    }
}