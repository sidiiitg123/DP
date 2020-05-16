package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubMatricesZeroSum {

    int findZeroSumSubArray(int arr[]){
        HashMap<Integer,Integer> sumMap= new HashMap<>();
        int sum = 0;
        int c = 0;
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];


            if (sum == 0 )
                c++;

            if(sumMap.containsKey(sum)) {
                c+=sumMap.get(sum);
            }


            if(sumMap.containsKey(sum)) {
                sumMap.put(sum, sumMap.get(sum)+1);
            } else {
                sumMap.put(sum, 1);
            }
        }
        return c;
    }

    public int solve(ArrayList<ArrayList<Integer>> A){
        if(A.size()==0)
            return 0;
        int c=0;
        int rows=A.size();
        int col=A.get(0).size();

        for(int left=0;left<col;left++){
            int[] temp=new int[rows];
            Arrays.fill(temp,0);

            for(int right=left;right<col;right++){
                for(int i=0;i<rows;i++){
                    temp[i]+=A.get(i).get(right);
                }
                int x=findZeroSumSubArray(temp);
                c+=x;
            }
        }
        return c;
    }
}
