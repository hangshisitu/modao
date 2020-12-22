package ant;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class OddAndEvenService
{
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private Integer cnt = 1;

    public void runOdd()
    {
        lock.lock();
        while(true)
        {
            if(cnt>100)
            {
                break;
            }
            if(cnt%2 !=1)
            {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else
            {
                System.out.println( String.format("%s: %d",Thread.currentThread().getName(),cnt));
                cnt +=1;
                condition.signal();
            }
        }
        lock.unlock();

    }

    public void runEven()
    {
        lock.lock();
        while(true)
        {

            if(cnt>100)
            {
                break;
            }
            if(cnt%2 !=0)
            {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else
            {
                System.out.println( String.format("%s: %d",Thread.currentThread().getName(),cnt));
                cnt +=1;
                condition.signal();
            }

        }
        lock.unlock();
    }
}

public class OddAndEven4 {



    public static void main(String[] args)
    {
        OddAndEvenService service = new OddAndEvenService();
        Thread thread1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                service.runOdd();
            }
        },"odd");
        Thread thread2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                service.runEven();
            }
        },"even");

        thread1.start();
        thread2.start();
    }

//[4,10,4,3,8,9]
}
