package modao.sort;

import java.util.ArrayList;
import java.util.List;

//非原地排序
//稳定排序
//时间复杂度O(n)
public class BucketSort {

    //array中元素取值范围在0~1000
    public void sort(int[] array)
    {
        List<List<Integer>> buckets = new ArrayList<List<Integer>>();
        for(int i=0;i<11;++i)
        {
            buckets.add(new ArrayList<Integer>());
        }
        for(int i=0;i<array.length;++i)
        {
            int bucketIndex = array[i]/100;
            buckets.get(bucketIndex).add(array[i]);
        }

        for(int i=0;i<11;++i)
        {
            buckets.get(i).sort((a,b)->{return a-b;});
        }

        int j=0;
        for(int i=0; i<11;++i)
        {
            List<Integer> temp = buckets.get(i);
            for(int k=0;k<temp.size();++k)
            {
                array[j] = temp.get(k);
                ++j;
            }
        }
    }
}
