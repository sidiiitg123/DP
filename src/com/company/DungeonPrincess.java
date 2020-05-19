package com.company;

import java.util.ArrayList;

public class DungeonPrincess {

    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {

        int m = A.size(), n = A.get(0).size();
        int[][] dp = new int[m][n];
        for(int i=m-1;i>=0;i--){
            for(int j =n-1;j>=0;j--){
                if(i==m-1 && j==n-1) dp[i][j]= Math.max(1,1-A.get(i).get(j));
                else if(i==m-1) dp[i][j]=Math.max(1,dp[i][j+1]-A.get(i).get(j));
                else if(j==n-1) dp[i][j]=Math.max(1,dp[i+1][j]-A.get(i).get(j));
                else dp[i][j]=Math.max(1, Math.min(dp[i+1][j],dp[i][j+1])-A.get(i).get(j));
            }
        }
        return dp[0][0];
    }
}
