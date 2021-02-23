package modao.sort;

import java.util.Arrays;

//非原地排序
//稳定排序
//时间复杂度O(n)
public class RadixSort {

    public void sort(long[] cellPhoneNos)
    {
        for(int i=0;i<11;++i)
        {
            countingSort(cellPhoneNos,i);
        }
    }

    public void countingSort(long[] cellPhoneNos, int index)
    {
        int[] counter = new int[10];
        Arrays.fill(counter,0);
        long base = (long)Math.pow(10,index);
        for(int i=0;i<cellPhoneNos.length;++i)
        {
            int radix = (int)((cellPhoneNos[i]/base)%10);
            counter[radix] +=1;
        }
        for(int i=1;i<counter.length;++i)
        {
            counter[i] +=counter[i-1];
        }
        long[] result = new long[cellPhoneNos.length];
        for(int i=cellPhoneNos.length-1;i>=0;--i)
        {
            int radix = (int)((cellPhoneNos[i]/base)%10);
            result[counter[radix]-1] = cellPhoneNos[i];
            counter[radix] -=1;
        }
        for(int i=0;i<result.length;++i)
        {
            cellPhoneNos[i] = result[i];
        }
    }
}
