package cc.jeris;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ParenthesesTest
 */
public class ParenthesesTest {

    ValidParentheses v = new ValidParentheses();

    @Test
    public void testOne() {
        assertTrue(v.isValid("()"));
    }

    @Test
    public void testTwo() {
        assertFalse(v.isValid("(]"));
    }

    @Test
    public void testThree() {
        assertTrue(v.isValid("()[]{}"));
    }

    @Test
    public void testFour() {
        assertFalse(v.isValid("]("));
    }
}