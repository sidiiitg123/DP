package com.company;

public class RegularExpressionMatchII {
    public int isMatch(final String A, final String B) {
        int[][] array = new int[A.length()+1][B.length()+1];
        for(int i=0;i<=A.length();i++){
            array[i][0] = 0;
        }
        for(int i=0;i<=B.length();i++){
            array[0][i] = 0;
        }
        array[0][0] = 1;
        for(int i=1;i<=B.length();i++){
            if(B.charAt(i-1) == '*'){
                array[0][i] = array[0][i-2];
            }
        }
        for(int i=1;i<=A.length();i++){
            for(int j=1;j<=B.length();j++){
                if((A.charAt(i-1) == B.charAt(j-1)) || (B.charAt(j-1) == '.')){
                    array[i][j] = array[i-1][j-1];
                }
                else if(B.charAt(j-1) == '*'){
                    array[i][j] = array[i][j-2];
                    if((A.charAt(i-1) == B.charAt(j-2)) || (B.charAt(j-2) == '.')){
                        array[i][j] = array[i][j] | array[i-1][j];
                    }
                }
                else{
                    array[i][j] = 0;
                }
            }
        }
        return array[A.length()][B.length()];
    }
}
