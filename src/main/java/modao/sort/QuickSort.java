package modao.sort;
//原地排序
//不稳定
//时间复杂度O(nlogn)
public class QuickSort {

    public void sort(int[] array,int left, int right)
    {
        if(left>=right)
        {
            return;
        }

        int i=left;
        int j=right;
        int key = array[i];
        while(i<j)
        {
            while(j>i && array[j]>=key)
            {
                j--;
            }
            array[i] = array[j];
            while(i<j && array[i]<=key)
            {
                i++;
            }
            array[j] = array[i];
        }
        array[i] = key;
        sort(array,left,i-1);
        sort(array,i+1,right);
    }
}
