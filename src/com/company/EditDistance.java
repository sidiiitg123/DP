package com.company;

public class EditDistance {
    public int minDistance(String A, String B) {
        int aLength = A.length();
        int bLength = B.length();
        if(aLength == 0){
            return bLength;
        }
        if(bLength == 0){
            return aLength;
        }

        int[][] table = new int[aLength + 1][bLength + 1];
        for(int i = 1; i <= aLength; i++)
            table[i][0] = i;
        for(int i = 1; i <= bLength; i++)
            table[0][i] = i;

        for(int i = 0; i < aLength; i++){
            for(int j = 0; j < bLength; j++){
                table[i+1][j+1] = Math.min(table[i+1][j],
                        table[i][j+1]) + 1;
                if(A.charAt(i) == B.charAt(j))
                    table[i+1][j+1] = Math.min(table[i+1][j+1],
                            table[i][j]);
                else
                    table[i+1][j+1] = Math.min(table[i+1][j+1],
                            table[i][j] + 1);
            }
        }

        return table[aLength][bLength];
    }
}
