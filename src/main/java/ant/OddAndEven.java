package ant;

import java.util.concurrent.atomic.AtomicInteger;

public class OddAndEven implements Runnable{

    public AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {

        synchronized (atomicInteger)
        {
            while(atomicInteger.get()<100)
            {
                try {
                    //这里的超时时间设长一些就不能保证结果的正确了。
                    atomicInteger.wait(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(atomicInteger.get()<100)
                {
                    System.out.println(String.format("%s: %d",Thread.currentThread().getName(),atomicInteger.incrementAndGet()));
                    atomicInteger.notify();
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        OddAndEven execution = new OddAndEven();
        Thread thread1 = new Thread(execution,"odd");
        Thread thread2 = new Thread(execution,"even");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
