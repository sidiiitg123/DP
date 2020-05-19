package com.company;

import java.util.List;

public class MaxProductSubarray {

    public int maxProduct(final List<Integer> A) {

        if(A.size()==0 ||A== null)
            return 0;

        int curr_max_product=A.get(0);
        int prev_max_product=A.get(0);
        int prev_min_product=A.get(0);
        int curr_min_product=A.get(0);
        int ans=A.get(0);

        for(int i=1;i<A.size();i++){
            curr_max_product=Math.max(A.get(i)*prev_max_product,Math.max(A.get(i)*prev_min_product,A.get(i)));
            curr_min_product=Math.min(A.get(i)*prev_max_product,Math.min(A.get(i)*prev_min_product,A.get(i)));
            ans=Math.max(ans,curr_max_product);
            prev_max_product=curr_max_product;
            prev_min_product=curr_min_product;
        }
        return ans;
    }
}
