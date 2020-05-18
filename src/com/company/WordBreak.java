package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordBreak {

    public int  wordbreak(String A, ArrayList<String> B ){
        boolean[] t = new boolean[A.length() + 1];
        t[0] = true;

        for(int i = 0; i < A.length(); i++){
            if(!t[i])
                continue;
            for(String word : B){
                int length = word.length();
                int end = i + length;
                if(end > A.length())
                    continue;
                if(t[end])
                    continue;
                if(A.substring(i, end).equals(word))
                    t[end] = true;
            }
        }
        if(!t[A.length()])
            return 0;

        return 1;
    }
}
