package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class KingdomWar {

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int row = A.size(), max = 0;
        int col = A.get(0).size();
        int[] dp = new int[col];
        Arrays.fill(dp, 0);
        int tmp = A.get(0).get(0);

        for (int i = row - 1; i >= 0; i--) {

            for (int j = 0; j < col; j++) {
                dp[j] += A.get(i).get(j);
                tmp = Math.max(tmp, A.get(i).get(j));
            }
            int temps = 0;
            for (int k = col - 1; k >= 0 && dp[k] > 0; k--) {
                temps += dp[k];
            }
            max = Math.max(max, temps);
        }
        if (max == 0) {
            max = tmp;
        }
        return  max;
    }
}
