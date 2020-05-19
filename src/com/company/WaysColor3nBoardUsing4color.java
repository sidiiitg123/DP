package com.company;

public class WaysColor3nBoardUsing4color {

    public int solve(int A) {

        long color3=24;
        long color2=12;
        long temp=0;
        for(int i=2;i<=A;i++){
            temp=color3;
            color3=(11*color3+10*color2)%1000000007;
            color2=(5*temp+7*color2)%1000000007;
        }
        long num=(color2+color3)%1000000007;

        return (int)num;
    }

}
