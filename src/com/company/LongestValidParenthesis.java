package com.company;

import java.util.Stack;

public class LongestValidParenthesis {

    public int longestValidParentheses(String A) {
        int maxLen = 0;
        int last = -1;

        Stack<Integer> left = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') {
                left.push(i);
            } else {
                if (left.isEmpty()) {
                    last = i;
                } else {
                    left.pop();
                    if (left.isEmpty()) {
                        maxLen = Math.max(maxLen, i - last);
                    } else {
                        maxLen = Math.max(maxLen, i - left.peek());
                    }
                }
            }
        }
        return maxLen;
    }
}
