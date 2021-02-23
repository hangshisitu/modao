package modao.queue;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.BinaryOperator;

/**
 * 线程安全的无锁队列
 * @author qiaojun.xiao
 */
public class CasQueue<T> {

    private int capacity = 0;
    private AtomicReferenceArray<T> data = null;
    private AtomicInteger head=null;
    private AtomicInteger tail=null;


    public CasQueue(int capacity)
    {
        head = new AtomicInteger(0);
        tail = new AtomicInteger(0);
        data = new AtomicReferenceArray(capacity+1);
        this.capacity = capacity;
        for(int i=0; i<data.length();++i)
        {
            data.set(i,null);
        }
    }

    public boolean enqueue(T item)
    {
        int index = (tail.get()+1)%(capacity+1);
        if(index == head.get()%(capacity+1))
        {//队列满
            return false;
        }

        while(!data.compareAndSet(index,null,item))
        {
            return enqueue(item);
        }
        tail.incrementAndGet();
        return true;
    }

    public T dequeue()
    {
        if(head.get() == tail.get())
        {//队列空了
            return null;
        }

        int index = (head.get()+1)%(capacity+1);
        T temp = data.get(index);
        if(temp == null)
        {
            return dequeue();
        }
        while(!data.compareAndSet(index,temp,null))
        {
            return dequeue();
        }
        head.incrementAndGet();
        return temp;
    }
}
