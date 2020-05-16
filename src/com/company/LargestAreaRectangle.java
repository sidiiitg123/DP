package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class LargestAreaRectangle {


    public int solve(ArrayList<ArrayList<Integer>> A) {

        int ans=Integer.MIN_VALUE;

        ArrayList<ArrayList<Integer>> myarr=new ArrayList<>(A);

        for(int i=1;i<A.size();i++){
            for(int j=0;j<A.get(0).size();j++){
                if(A.get(i).get(j)!=0){
                  int value=myarr.get(i-1).get(j)+1;
                  myarr.get(i).set(j,value);
                }
            }
        }
        for(int i=0;i<A.size();i++){
            Collections.sort(myarr.get(i));
        }
        for(int i=A.size()-1;i>=0;i--){
            for(int j=A.get(0).size()-1;j>=0;j--){
                if(myarr.get(i).get(j)!=0){
                    ans=Math.max(ans,(j+1)*A.get(i).get(j));
                }
            }
        }
        return ans;
    }

}
