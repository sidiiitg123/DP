package com.company;

public class Stairs {
    int dp[];

    public int recStairs(int i, int n) {
        if (i > n)
            return 0;
        if (i == n)
            return 1;
        if (dp[i] != -1)
            return dp[i];

        dp[i] = recStairs(i + 1, n) + recStairs(i + 2, n);
        return dp[i];
    }

    public int climbStairs(int A) {
        dp = new int[A + 1];
        for (int i = 0; i <= A; i++)
            dp[i] = -1;

        return recStairs(0, A);
    }
}
