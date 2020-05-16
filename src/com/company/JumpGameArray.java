package com.company;

import java.util.ArrayList;

public class JumpGameArray {
    public int canJump(ArrayList<Integer> A) {
        if(A.size()==1) return 1;
        int prev=A.get(0);
        if(prev==0) return 0;

        for(int i=1;i<A.size();i++){
            prev-=1;
            prev=Math.max(prev,A.get(i));
            if(prev==0) return 0;
        }
        return 1;
    }
}
