package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectingChordCircle {
    final long mod=1000000007;
    int ans=0;

    public int chordCnt(int A) {
         long[] myarr=new long[A+1];
         Arrays.fill(myarr,0);
         myarr[0]=1;
         for(int i=1;i<=A;i++){
             for (int j=0;j<i;j++){
                 myarr[i]=myarr[i]+(myarr[j]*myarr[i-j-1])%mod;
                 myarr[i]=myarr[i]%mod;
             }
         }
         return (int)myarr[A];
    }

}
