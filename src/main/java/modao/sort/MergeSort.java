package modao.sort;

public class MergeSort {

    public void sort(int[] array,int left, int right)
    {
        if(left==right)
        {
            return;
        }

        int mid = (left+right)/2;
        sort(array,left,mid);
        sort(array,mid+1,right);

        int[] temp = new int[right-left+1];

        int i=left;
        int j=mid+1;
        int t=0;
        for(;i<=mid && j<=right;)
        {
            if(array[i]<=array[j])
            {
                temp[t]=array[i];
                ++i;
            }else
            {
                temp[t]=array[j];
                ++j;
            }
            ++t;
        }
        if(i>mid)
        {
            while(j<=right)
            {
                temp[t] = array[j];
                ++t;
                ++j;
            }

        }

        if(j>right)
        {
            while(i<=mid)
            {
                temp[t] = array[i];
                ++t;
                ++i;
            }
        }

        for(int k=0;k<temp.length;++k)
        {
            array[left+k] = temp[k];
        }
    }
}
