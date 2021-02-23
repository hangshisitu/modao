package modao.sort;
//原地排序
//不稳定
//最好，最坏，平均时间复杂度都是O(n**2)
public class SelectionSort {

    public void sort(int[] array)
    {
        for(int i=0;i<array.length;++i)
        {
            int minIndex = i;
            for(int j=i+1;j<array.length;++j)
            {
                if(array[j]<array[minIndex])
                {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
