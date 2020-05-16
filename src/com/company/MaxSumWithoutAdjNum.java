package com.company;

import java.util.ArrayList;

public class MaxSumWithoutAdjNum {
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        if(A == null || A.size() == 0)
            return 0;

        int m = A.size();
        int n = A.get(0).size();
        if(n == 0)
            return 0;

        int[] dp = new int[n];
        ArrayList<Integer> first = A.get(0);
        ArrayList<Integer> second = A.get(1);

        dp[0] = Math.max(first.get(0), second.get(0));
        if(n < 2)
            return dp[0];

        dp[1] = Math.max(first.get(1), second.get(1));
        dp[1] = Math.max(dp[0], dp[1]);

        for(int i = 2; i < n; i++){
            dp[i] = Math.max(first.get(i), second.get(i));
            dp[i] += dp[i-2];//new inclusive
            dp[i] = Math.max(dp[i], dp[i-1]);//new exclusive
        }

        return dp[n-1];
    }
}
