package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestBitonicSubsequence {


    public int lbs(List<Integer> arr, int n) {
        Integer[] arrLeft = new Integer[n];
        Arrays.fill(arrLeft, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (arr.get(i) > arr.get(j) && arrLeft[i] < arrLeft[j] + 1)
                    arrLeft[i] = arrLeft[j] + 1;
        }
        Integer[] arrRight = new Integer[n];
        Arrays.fill(arrRight, 1);

        for (int i = n - 2; i >= 0; i--)
            for (int j = n - 1; j > i; j--)
                if (arr.get(i) > arr.get(j) && arrRight[i] < arrRight[j] + 1)
                    arrRight[i] = arrRight[j] + 1;


        int max = arrLeft[0] + arrRight[0] - 1;
        for (int i = 1; i < n; i++)
            if (arrLeft[i] + arrRight[i] - 1 > max)
                max = arrLeft[i] + arrRight[i] - 1;


        return max;

    }

    public int longestSubsequenceLength(final List<Integer> A) {

              return lbs(A,A.size());
    }
}
