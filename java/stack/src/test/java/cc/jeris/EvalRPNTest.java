package cc.jeris;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test Suite for EvalRPN problem.
 */
public class EvalRPNTest {

    DailyTemperature p = new DailyTemperature();

    @Test
    public void testOne() {
        String[] input = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        // Need to use Arrays.equals function to compare array contents
        assertTrue((new EvalRPN()).evalRPN(input) == 22);
    }

    @Test
    public void testTwo() {
        String[] input = { "4", "13", "5", "/", "+" };
        // Need to use Arrays.equals function to compare array contents
        assertTrue((new EvalRPN()).evalRPN(input) == 6);
    }
}