package modao.queue;

public class CycQueue<T> {

    private int putIndex;
    private int takeIndex;
    private T[] data;
    private int count;

    public CycQueue(int capacity)
    {
        data = (T[])new Object[capacity];
        putIndex=0;
        takeIndex=0;
        count=0;
    }

    public boolean enqueue(T item)
    {
        if(count == data.length)
        {//队列满了
            return false;
        }
        data[putIndex] = item;
        count++;
        if(++putIndex==data.length)
        {
            putIndex = 0;
        }
        return true;
    }

    public T dequeue()
    {
        if(count==0)
        {
            return null;
        }
        T temp = data[takeIndex];
        if(++takeIndex==data.length)
        {
            takeIndex=0;
        }
        count--;
        return temp;
    }
}
