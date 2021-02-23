package modao.sort;

public class HeapSort {

    public void sort(int array[])
    {
        buildHeapEx(array);
        for(int i=array.length-1;i>0;--i)
        {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array,0,i);
        }
    }

    public void buildHeap(int data[])
    {//插入方式建堆

        for(int i=1;i<data.length;++i)
        {
            while( (i-1)/2>=0 && data[(i-1)/2]<data[i])
            {
                int temp = data[(i-1)/2];
                data[(i-1)/2] = data[i];
                data[i] = temp;
                i = (i-1)/2;
            }
        }
    }

    public void buildHeapEx(int data[])
    {
        for(int i=data.length/2;i>=0;--i)
        {
            heapify(data,i,data.length);
        }
    }

    private void heapify(int data[], int i, int size)
    {
        while(true)
        {
            int maxIndex = i;
            if(i*2+1<size && data[i*2+1]>data[maxIndex])
            {
                maxIndex = i*2+1;
            }
            if(i*2+2<size && data[i*2+2]>data[maxIndex])
            {
                maxIndex = i*2+2;
            }
            if(maxIndex == i)
            {
                break;
            }
            int temp = data[maxIndex];
            data[maxIndex] = data[i];
            data[i] = temp;

            i = maxIndex;
        }
    }
}
