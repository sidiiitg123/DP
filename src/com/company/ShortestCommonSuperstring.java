package com.company;

import java.util.ArrayList;

public class ShortestCommonSuperstring {
    String s ="";

    public int findOverlappingPair(String s1, String s2) {
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= Math.min(s1.length(), s2.length()); i++) {
            if (s1.substring(s1.length() - i).compareTo(s2.substring(0, i)) == 1) {
                if (max < i) {
                    max = i;
                    s = s1+s2.substring(i);
                }
            }
        }
        for (int i = 1; i <= Math.min(s1.length(), s2.length()); i++) {
            if (s1.substring(0, i).compareTo(s2.substring(s2.length() - i)) == 1) {
                if (max < i) {
                    max = i;
                    s = s2+s1.substring(i);
                }
            }
        }
        return max;
    }

    public int solve(ArrayList<String> A) {

        if(A==null|A.size()==0)
            return 0;
        if(A.size()==1)
            return A.get(0).length();

        ArrayList<String> temp = new ArrayList<>(A);
        int len=temp.size();

        while (len != 1) {
            int max = Integer.MIN_VALUE;
            int l = 0, r = 0;
            String restr = "";
            for (int i = 0; i < temp.size(); i++) {
                for (int j = i + 1; j < temp.size(); j++) {
                    int res = findOverlappingPair(temp.get(i), temp.get(j));
                    if (max < res) {
                        max = res;
                        restr = s;
                        l=i;
                        r=j;
                    }
                }
            }
            len--;
            if(max==Integer.MIN_VALUE){
               temp.set(0,temp.get(0)+A.get(len));
            }else{
                temp.set(l,restr);
                temp.set(r,temp.get(len));
            }
        }
        return temp.get(0).length();
    }
}
