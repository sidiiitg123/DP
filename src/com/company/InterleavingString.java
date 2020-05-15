package com.company;

import java.util.Stack;

public class InterleavingString {

    String a,b,v;

    public Boolean dp(int in,int i,int j){
        if(in==v.length())return true;
        if(i==a.length()&&j==b.length())return false;
        Boolean uso=false;
        if(i<a.length()&&v.charAt(in)==a.charAt(i))uso=dp(in+1,i+1,j);
        if(uso)return true;
        if(j<b.length()&&v.charAt(in)==b.charAt(j))uso=dp(in+1,i,j+1);
        if(uso)return true;
        return false;
    }

    public int isInterleave(String A, String B, String C) {

     a=A;
     b=B;
     v=C;
     if(dp(0,0,0)){
         return 1;
     }
     return 0;
    }
}
