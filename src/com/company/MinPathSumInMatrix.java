package com.company;

import java.util.ArrayList;

public class MinPathSumInMatrix {
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {

        if(A.size() == 0){
            return 0;
        }
        int rows = A.size();
        int cols = A.get(0).size();

        int[][] arr= new int[rows][cols];

        int sum=0;

        for(int i=0;i<cols;i++){
          arr[0][i]=sum+A.get(0).get(i);
          sum=arr[0][i];
        }
        sum = 0;

        for(int i = 0; i < rows; i++){
            arr[i][0] = sum + A.get(i).get(0);
            sum = arr[i][0];
        }
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                arr[i][j] = A.get(i).get(j) + Math.min(arr[i-1][j], arr[i][j-1]);
            }
        }
        return arr[rows-1][cols-1];
    }
}
