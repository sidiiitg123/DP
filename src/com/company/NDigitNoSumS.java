package com.company;

public class NDigitNoSumS {

    public int solve(int A, int B) {

         long[][] dp =new long[A][B];
         if(B<1 || B>9*A )
             return 0;

         for(int i=0;i<A;i++){
             dp[i][0]=1;
         }
         for(int j=0;j<B;j++){
             if(j<=8){
                 dp[0][j]=1;
             }else{
                 dp[0][j]=0;
             }
        }
         for(int i=1;i<A;i++){
             for(int j=1;j<B;j++){
                 dp[i][j]=0;
                 int k=0;
                 if(j>=9) k=j-9;
                 for(;k<=j;k++){
                     dp[i][j]=(dp[i][j]+dp[i-1][k])%1000000007;
                 }
             }
         }
         return (int)dp[A-1][B-1];
    }
}
