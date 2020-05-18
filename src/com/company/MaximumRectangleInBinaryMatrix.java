package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class MaximumRectangleInBinaryMatrix {

    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        if(A.size()==0 || A==null)
            return 0;
        int row=A.size(),col=A.get(0).size();
        int[][] grid=new int[row][col];

        buildHist(grid,A);
        int max=Integer.MIN_VALUE;
        for(int bottom=0;bottom<row;bottom++){
            max=Math.max(max,maxrec(grid,bottom));
        }
        return max;
    }

    public int maxrec(int[][] grid,int bottom){

        Deque<Integer> mystack=new ArrayDeque<>();
        mystack.push(-1);
        int max=Integer.MIN_VALUE;
        int curIndex=0;

        while(curIndex<grid[bottom].length){
          while(mystack.peek()!=-1 && grid[bottom][curIndex]<=grid[bottom][mystack.peek()]){
              max= Math.max(max,grid[bottom][mystack.pop()]*(curIndex-mystack.peek()-1));
          }
            mystack.push(curIndex++);
        }


        while(mystack.peek()!=-1){
            max= Math.max(max,grid[bottom][mystack.pop()]*(grid[bottom].length-mystack.peek()-1));
        }
        return max;
    }

    public void buildHist(int[][] grid,ArrayList<ArrayList<Integer>> A){

        for(int i=0;i<A.get(0).size();i++){
            if(A.get(0).get(i)==1){
                grid[0][i]=1;
            }else{
                grid[0][i]=0;
            }
        }
        for(int i=1;i<A.size();i++){
            for(int j=0;j<A.get(i).size();j++){
                if(A.get(i).get(j)==1 ){
                    grid[i][j]=grid[i-1][j]+1;
                }else {
                    grid[i][j]=0;
                }
            }
        }
    }
}
