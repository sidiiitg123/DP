package com.company;

import java.util.List;

public class BuyAndSellStockI {
    public int maxProfit(final List<Integer> A) {
        if(A.size()==0)
            return 0;

        int min=A.get(0);
        int sol=0;
        for(int i=1;i<A.size();i++){

            if(A.get(i)<min){
                min=A.get(i);
            }
           sol= Math.max(sol,A.get(i)-min);
        }
        return sol;
    }
}
