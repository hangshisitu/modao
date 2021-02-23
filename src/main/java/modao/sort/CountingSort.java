package modao.sort;

import java.util.Arrays;

//非原地排序
//稳定的
//时间复杂度O(n)
public class CountingSort {

    //array中元素的取值范围0~10
    public void sort(int[] array)
    {
        int[] counter = new int[11];
        Arrays.fill(counter,0);
        for(int i=0;i<array.length;++i)
        {
            counter[array[i]] +=1;
        }
        for(int i=1;i<counter.length;++i)
        {
            counter[i] +=counter[i-1];
        }
        int[] result = new int[array.length];
        for(int i=array.length-1;i>=0;--i)
        {
            result[counter[array[i]]-1] = array[i];
            counter[array[i]] -=1;
        }
        for(int i=0;i<result.length;++i)
        {
            array[i] = result[i];
        }
    }
}
