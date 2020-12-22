package ant;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.FutureTask;

class SumService2 implements Callable<Integer> {
    public int end;
    public int start;
    public SumService2(int start,int end)
    {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        Integer sum = 0;
        while(this.start<=end)
        {
            sum +=start;
            start +=1;
        }
        return sum;
    }
}

public class Sum2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SumService2 sumService1 = new SumService2(1,2000);
        SumService2 sumService2 = new SumService2(2001,4000);
        SumService2 sumService3 = new SumService2(4001,6000);
        SumService2 sumService4 = new SumService2(6001,8000);
        SumService2 sumService5 = new SumService2(8001,10000);


        FutureTask<Integer>[] futureTasks = new FutureTask[5];
        futureTasks[0] = new FutureTask<Integer>(sumService1);
        futureTasks[1] = new FutureTask<Integer>(sumService2);
        futureTasks[2] = new FutureTask<Integer>(sumService3);
        futureTasks[3] = new FutureTask<Integer>(sumService4);
        futureTasks[4] = new FutureTask<Integer>(sumService5);

        for(int i=0;i<5;++i)
        {
            new Thread(futureTasks[i]).start();
        }

        int sum = 0;
        for(int i=0;i<5;++i)
        {
            sum += futureTasks[i].get();
        }
        System.out.println(sum);
    }
}
