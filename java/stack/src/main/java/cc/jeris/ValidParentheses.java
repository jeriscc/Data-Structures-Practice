package cc.jeris;

import java.util.Stack;

/**
 * ValidParentheses. Speed 98.5% and 1ms. O(n) time and space.
 * 
 * Problem Src: https://leetcode.com/problems/valid-parentheses/
 * 
 * Take away, not all correspondance verification has to happen via HashMaps,
 * simple boolean logic also works. Also, look for broader boolean simplication
 * across my solutoins.
 * 
 * My previous convoluted hashmap solution:
 * https://leetcode.com/submissions/detail/256641128/
 * 
 * Simplified hashmap solution:
 * https://leetcode.com/submissions/detail/256644767/
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() == 0)
            return true;
        if (s.length() % 2 == 1)
            return false;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}