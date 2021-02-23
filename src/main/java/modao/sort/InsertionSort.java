package modao.sort;

//稳定的
//原地排序
//最好情况O(n),最坏情况O(n**2),平均O(n**2)
public class InsertionSort {

    public void sort(int[] array)
    {
        for(int i=1; i<array.length;++i)
        {
            int curr = array[i];
            int j=i;
            for(;j>=1;--j)
            {
                if(curr<array[j-1])
                {
                    array[j] = array[j-1];
                }else
                {
                    break;
                }
            }
            array[j]=curr;
        }
    }
}
