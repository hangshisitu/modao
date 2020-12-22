package ant;

class SumService implements  Runnable{
    public int sum;
    public int end;
    public int start;
    public SumService(int start,int end)
    {
        this.start = start;
        this.end = end;
        this.sum = 0;
    }


    @Override
    public void run() {
        while(this.start<=end)
        {
            sum +=start;
            start +=1;
        }
        System.out.println(String.format("%s: %d",Thread.currentThread().getName(),this.sum));
    }
}

public class Sum {


    public static void main(String[] args) throws InterruptedException {
        SumService sumService1 = new SumService(1,2000);
        SumService sumService2 = new SumService(2001,4000);
        SumService sumService3 = new SumService(4001,6000);
        SumService sumService4 = new SumService(6001,8000);
        SumService sumService5 = new SumService(8001,10000);

        Thread thread1 = new Thread(sumService1,"sumService1");
        Thread thread2 = new Thread(sumService2,"sumService2");
        Thread thread3 = new Thread(sumService3,"sumService3");
        Thread thread4 = new Thread(sumService4,"sumService4");
        Thread thread5 = new Thread(sumService5,"sumService5");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        System.out.println(sumService1.sum+sumService2.sum+sumService3.sum+sumService4.sum+sumService5.sum);

    }
}
