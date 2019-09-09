package cc.jeris;

/**
 * EvalRPN
 * 
 * Implements stack using an array for better efficiency and deeper access to
 * elements. Would use Deque<Integer> stack = new ArrayDeque<>() for other
 * use-cases.
 * 
 * Problem src: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = 0;
        for (String str : tokens) {
            if (str.equals("+")) {
                top--;
                stack[top - 1] += stack[top];
            } else if (str.equals("*")) {
                top--;
                stack[top - 1] *= stack[top];
            } else if (str.equals("/")) {
                top--;
                stack[top - 1] /= stack[top];
            } else if (str.equals("-")) {
                top--;
                stack[top - 1] -= stack[top];
            } else {
                stack[top++] = Integer.parseInt(str);
            }
        }
        return stack[0];
    }
}