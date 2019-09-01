package cc.jeris;

import java.util.Stack;

/**
 * ValidParentheses. Speed 98.5% and 1ms. O(n) time and space.
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

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                if (c == ')' && stack.pop() != '(')
                    return false;
                if (c == ']' && stack.pop() != '[')
                    return false;
                if (c == '}' && stack.pop() != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}