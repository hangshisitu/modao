package ant;

public class OddAndEven3 implements Runnable{



    public static Integer lock =0;

    public Integer cnt =0;

    public OddAndEven3(int cnt)
    {
        this.cnt = cnt;
    }
    @Override
    public void run() {

        synchronized (lock)
        {
            while(cnt<=100)
            {
                if(cnt!=1 && cnt!=2)
                {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(String.format("%s: %d",Thread.currentThread().getName(),cnt));
                cnt +=2;
                lock.notify();

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OddAndEven3 execution1 = new OddAndEven3(1);
        OddAndEven3 execution2 = new OddAndEven3(2);
        Thread thread1 = new Thread(execution1,"odd");
        Thread thread2 = new Thread(execution2,"even");
        thread1.start();
        thread2.start();
    }
}

