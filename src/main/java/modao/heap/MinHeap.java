package modao.heap;

public class MinHeap {

    private int[] data;
    private int capacity;
    private int size;

    public MinHeap(int capacity)
    {
        this.data = new int[capacity+1];
        this.capacity = capacity;
        this.size = 0;
    }

    public boolean insert(int v)
    {
        if(size==capacity)
        {//满了
            return false;
        }

        size +=1;
        int i = size;
        data[i] = v;
        while( i/2>0 && data[i/2] >data[i])
        {
            int temp = data[i/2];
            data[i/2] = data[i];
            data[i] = temp;
            i = i/2;
        }
        return true;
    }

    private void heapify(int i)
    {
        while(true)
        {
            int minIndex = i;
            if(i*2<=size && data[i*2]<data[minIndex])
            {
                minIndex = i*2;
            }
            if(i*2+1<=size && data[i*2+1]<data[minIndex])
            {
                minIndex = i*2+1;
            }
            if(minIndex == i)
            {
                break;
            }
            int temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;

            i = minIndex;
        }
    }

    //取出堆顶元素
    public int poll()
    {
        if(size==0)
        {
            throw new RuntimeException("heap is empty");
        }

        int top = data[1];

        int i=1;
        data[i] = data[size];
        data[size]=0;
        size -=1;

        heapify(i);
        return top;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=1;i<=size;++i)
        {
            stringBuilder.append(String.format("%d,",data[i]));
        }
        return stringBuilder.toString();
    }
}
