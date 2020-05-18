package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreakII {
    public ArrayList<String> wordBreak(String a, ArrayList<String> b) {
        ArrayList<String> res = new ArrayList<>();
        backtrack(a, 0, new StringBuilder(), res, new HashSet(b));
        return res;
    }

    private void backtrack(String a, int index,StringBuilder cur,
                           ArrayList<String> res, Set<String> dict) {
        if (index >= a.length()) {
            res.add(cur.toString());
        }

        int len = cur.length();
        if (index != 0) {
            cur.append(" ");
        }

        for (int i = index; i < a.length(); i++) {
            cur.append(a.charAt(i));
            if (dict.contains(a.substring(index, i + 1))) {
                backtrack(a, i + 1, cur, res, dict);
            }
        }

        cur.setLength(len);
    }

}
