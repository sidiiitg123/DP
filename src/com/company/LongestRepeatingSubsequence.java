package com.company;

public class LongestRepeatingSubsequence {

    public int anytwo(String A) {
        int n = A.length() + 1;
        int[][] cache = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (A.charAt(i - 1) == A.charAt(j - 1) && i != j) {
                    cache[i][j] = 1 + cache[i - 1][j - 1];
                } else {
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
                }
                if (cache[i][j] >= 2) return 1;
            }
        }
        return 0;
    }
}
