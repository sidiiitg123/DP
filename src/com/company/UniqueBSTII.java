package com.company;

public class UniqueBSTII {
    public int numTrees(int limit) {
        int[] dp = new int[limit + 1];
        dp[0] = dp[1] = 1;
        for (int n = 2; n <= limit; n++) {
            for (int root = 1; root <= n; root++) {
                dp[n] += dp[root - 1] * dp[n - root];
            }
        }
        return dp[limit];
    }
}
