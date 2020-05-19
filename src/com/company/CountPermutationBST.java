package com.company;

public class CountPermutationBST {
    static long mod=(long)Math.pow(10,9) + 7;

    static long c[][];

    //Precompute ncr
    public void combine (long[][] comb)
    {
        int n= comb.length, mod= 1000000007;
        comb[0][0]= 1;
        for (int i=1;i<comb.length;i++)
        {
            comb[i][0]=1;
            for (int j= 1;j<= i;j++)
            {
                comb[i][j]=comb[i- 1][j];
                comb[i][j]+= comb[i- 1][j- 1];
                comb[i][j]%= mod;
            }
        }
    }

    public long solve(int start,int end,int height,long[][][] dp)
    {
        int len=end-start;
        if(height==0)
        {
            if(len<=0) return 1;
            return 0;
        }

        if(start>end) return 0;
        if(height>len) return 0;

        if(dp[start][end][height]!=-1)
            return dp[start][end][height];

        long val=0;

        for(int i=start;i<=end;i++)
        {
            long left_val=0;
            long right_val=0;

            int left_sub=(i-1)-start+1; //Size of left_subtree
            int right_sub=end-(i+1)+1;  //Size of right_subtree

            //Left Subtree
            for(int h=0;h<=height-1;h++)
                left_val=(left_val+solve(start,i-1,h,dp)*solve(i+1,end,height-1,dp))%mod;

            //Right Subtree
            for(int h=0;h<=height-1;h++)
                right_val=(right_val+solve(start,i-1,height-1,dp)*solve(i+1,end,h,dp))%mod;

            //Subtract duplicate
            long sub=(solve(start,i-1,height-1,dp)*solve(i+1,end,height-1,dp))%mod;

            val=(val+(c[left_sub+right_sub][right_sub]*(left_val+right_val-sub))%mod)%mod;
        }

        dp[start][end][height]=val;
        return val;
    }

    public int cntPermBST(int A, int B) {

        long dp[][][]=new long[A+1][A+1][B+1];
        c=new long[A+1][A+1];

        combine(c);

        for(int i=0;i<=A;i++)
            for(int j=0;j<=A;j++)
                for(int k=0;k<=B;k++)
                    dp[i][j][k]=-1;


        return (int)solve(1,A,B,dp);
    }
}
