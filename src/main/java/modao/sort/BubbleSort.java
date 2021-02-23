package modao.sort;

//原地排序
//稳定的
//最好情况O(n),最坏情况O(n**2),平均O(n**2)
public class BubbleSort {

    public void sort(int[] array)
    {
        for(int i=0;i<array.length;++i)
        {
            boolean flag = false;
            for(int j=1;j<array.length-i;++j)
            {
                if(array[j]<array[j-1])
                {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1]=temp;
                    flag = true;
                }
            }
            if(!flag)
            {
                break;
            }
        }
    }
}
