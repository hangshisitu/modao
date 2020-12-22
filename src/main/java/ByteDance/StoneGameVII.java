package ByteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoneGameVII {

    public int stoneGameVII(int[] stones) {
        int i=0;
        int j= stones.length-1;
        int ails = 0;
        int bob = 0;
        boolean flag = true;
        do {

            int temp = sum(stones,i+1,j);
            int temp2 = sum(stones,i,j-1);

            if(stones[i]<stones[j])
            {
                ++i;
            }else
            {
                --j;
            }
            temp = sum(stones,i,j);

            Map<String, List<String>> hashMap = new HashMap<>();
            hashMap.put("test",new ArrayList<>());

            for (List<String> item: hashMap.values()
                 ) {

            }
            if(flag)
            {
//                if(stones[i]<stones[j])
//                {
//                    ++i;
//                }else
//                {
//                    --j;
//                }
                ails += sum(stones,i,j);
                flag = false;
            }else
            {
//                if(stones[i]>stones[j])
//                {
//                    ++i;
//                }else
//                {
//                    --j;
//                }
                bob += sum(stones,i,j);
                flag = true;
            }
        }while(i<=j);
        return ails-bob;
    }

    public int sum(int[] stones, int left, int right)
    {
        int sum =0;
        for(int i=left;i<=right;++i)
        {
            sum += stones[i];
        }
        return sum;
    }
}
