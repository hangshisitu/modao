package ant;

import java.util.concurrent.atomic.AtomicInteger;

public class OddAndEven2 implements Runnable{


    public Integer cnt = 1;

    @Override
    public void run() {

        synchronized (cnt)
        {
            while(cnt<=100)
            {
                try {
                    cnt.wait(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(cnt<=100)
                {
                    System.out.println(String.format("%s: %d",Thread.currentThread().getName(),cnt));
                    cnt +=1;
//                    cnt.notify();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OddAndEven2 execution = new OddAndEven2();
        Thread thread1 = new Thread(execution,"odd");
        Thread thread2 = new Thread(execution,"even");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

