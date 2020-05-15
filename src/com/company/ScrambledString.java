package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ScrambledString {



    public int isScramble(final String A, final String B) {

        if (A.length() != B.length())
            return 0;
        if (A.equals(B))
            return 1;

        int L =A.length();

        int[] chars = new int[26];
        for (int i = 0; i < L; i++) {
            chars[A.charAt(i) - 'a']++;
            chars[B.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0)
                return 0;
        }
        for (int i = 1; i < L; i++) {
            String A1 = A.substring(0, i);
            String A2 = A.substring(i);
            String B1 = B.substring(0,i);
            String B2 = B.substring(i);
            if (isScramble(A1, B1)==1 && isScramble(A2, B2)==1)
                return 1;
            B1 = B.substring(0, L - i);
            B2 = B.substring(L-i);
            if (isScramble(A1, B2)==1 && isScramble(A2, B1)==1)
                return 1;
        }
        return 0;
    }
}
