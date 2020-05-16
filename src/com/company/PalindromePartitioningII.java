package com.company;

public class PalindromePartitioningII {
    public int minCut(String A) {
        int n=A.length();
        if(isPal(A,0,n-1)==1){
            return 0;
        }
        int[][] T= new int[n][n];
        for(int i=0; i<=n-1; i++){
            T[i][i]=0;
        }
        for(int l=1; l<=n-1; l++){
            for(int i=0; i<=n-1-l; i++){
                int j=i+l;
                if(isPal(A,i,j)==1){
                    T[i][j]=0;
                }
                else{
                    int min=1+T[i][i]+T[i+1][j];
                    for(int k=1; k<=(j-i-1); k++){
                        int val=1+T[i][i+k]+T[i+k+1][j];
                        if(val<min){
                            min=val;
                        }
                    }
                    T[i][j]=min;
                }
            }
        }

        return T[0][n-1];
    }

    public int isPal(String str, int min, int max){
        for(int i=0; i<=(max-min)/2; i++){
            if(str.charAt(min+i)!=str.charAt(max-i)){
                return 0;
            }
        }
        return 1;
    }
}
