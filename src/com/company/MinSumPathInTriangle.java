package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class MinSumPathInTriangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {

        if(a.size() == 0){
            return 0;
        }

        int[] total =new int[a.size()];

        int l = a.size() - 1;

        for (int i = 0; i < a.get(l).size(); i++)
        {
            total[i] = a.get(l).get(i);
        }

        for (int i = a.size() - 2; i >= 0; i--)
        {
            for (int j = 0; j < a.get(i+1).size() - 1; j++)
            {
                total[j] = a.get(i).get(j) + Math.min(total[j], total[j + 1]);
            }
        }

        return total[0];
    }
}
