package com.company;

import java.util.Arrays;
import java.util.List;

public class LongIncSubseq {
    public int lis(final List<Integer> A) {

        Integer[] arrLeft = new Integer[A.size()];
        Arrays.fill(arrLeft, 1);

        int sol = 1;

        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j)) {
                    arrLeft[i] = Math.max(arrLeft[j] + 1, arrLeft[i]);
                    if (arrLeft[i] > sol) {
                        sol = arrLeft[i];
                    }
                }
            }
        }
        return sol;
    }
}
