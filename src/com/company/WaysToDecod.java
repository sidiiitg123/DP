package com.company;

public class WaysToDecod {
    public int numDecodings(String A) {
        int n=A.length();
        if(A==null||n==0)
            return 0;
        int dp[]=new int[n+1];
        dp[0]=1;
        if(A.charAt(0)!='0')
            dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            int first=Integer.parseInt(A.substring(i-1,i));
            int second=Integer.parseInt(A.substring(i-2,i));
            if(first>=1&&first<=9)
                dp[i]+=dp[i-1];
            if(second>=10&&second<=26)
                dp[i]+=dp[i-2];
        }
        return dp[n];
    }
}
