package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestAP {
    public int solve(final List<Integer> A) {
        if(A==null || A.size()==0)
            return 0;
        if(A.size()==1)
            return 1;

        HashMap<Integer,Integer> dp[]= new HashMap[A.size()];

        for(int i=0;i<A.size();i++){
            dp[i]=new HashMap<>();
        }

        for(int i=0;i<A.size();i++){
            for(int j=i-1;j>=0;j--){
                int diff=A.get(i)-A.get(j);
                if(dp[j].containsKey(diff)){
                    if(dp[i].containsKey(diff)&&dp[i].get(diff)>dp[j].get(diff))
                        continue;
                    else
                    dp[i].put(diff,dp[j].get(diff)+1);
                }else {
                    if (!dp[i].containsKey(diff))
                        dp[i].put(diff,1);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            for(int j:dp[i].keySet()){
               if(dp[i].get(j)>=max)
                   max=dp[i].get(j);
            }
        }
        return max+1;
    }
}
