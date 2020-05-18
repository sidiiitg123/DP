package com.company;

import java.util.ArrayList;

public class CoinsInLine {
    public int maxcoin(ArrayList<Integer> A) {
        int n = A.size();
        long[] ds = new long[n + 1];
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            ds[i + 1] = ds[i] + A.get(i);
            dp[i][i] = A.get(i);
        }

        for (int k = 1; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                dp[i][j] = sum(ds, i, j) - Math.min(dp[i][j - 1], dp[i + 1][j]);
            }
        }
        return (int) dp[0][n - 1];
    }

    long sum(long[] ds, int st, int end) {
        return ds[end + 1] - ds[st];
    }
}

