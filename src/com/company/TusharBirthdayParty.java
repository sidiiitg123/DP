package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TusharBirthdayParty {
    public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int totSum = 0;

        int a = 0;

        for (Integer b : A) {
            if (b > a) {
                a = b;
            }
        }

        int[] v = new int[a + 1];
        for (int i = 1; i <= a; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < B.size(); j++) {
                if (B.get(j) > i) {
                    continue;
                }
                int value = v[i - B.get(j)] + C.get(j);
                if (value < min) {
                    min = value;
                }
            }
            v[i] = min;
        }

        for (Integer b : A) {
            totSum += v[b];
        }

        return totSum;
    }
}
