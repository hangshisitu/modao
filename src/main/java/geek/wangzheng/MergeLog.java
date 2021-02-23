package geek.wangzheng;

import sun.java2d.loops.GraphicsPrimitive;

import java.util.Arrays;
import java.util.PriorityQueue;

//10个300M的日志文件，排序，机器内存1G
public class MergeLog {

    public static void main(String[] args)
{
    PriorityQueue<String> priorityQueue = new PriorityQueue<>(args.length);
    Thread[] producter = new Thread[args.length-1];
    for(int i=0;i<producter.length;++i)
    {
        producter[i] = new Thread(()->{
            int index = Integer.valueOf(Thread.currentThread().getName());
            String fileName = args[index];
            //加载数据到内存
            String logs[] = new String[1000];
            for(int j=0;j<logs.length;++j)
            {
                if(priorityQueue.size()<10)
                {
                    priorityQueue.offer(logs[j]);
                }

            }


        },String.format("%d",i));
    }

    Thread consumer = new Thread(()->{
        String fileName = "out.log";
        do {
            String log = priorityQueue.poll();
            //写文件
        }while(true);

    });
}

    public static void doFun(String[][] logs)
    {
        int[] indexs = new int[10];
        Arrays.fill(indexs,0);
        String[] head = new String[10];
        for(int i=0;i<indexs.length;++i)
        {
            head[i] = logs[i][indexs[i]];
        }

        do{
            int minIndex = 0;
            for(int j=1;j<head.length;++j)
            {
//                if(head[j]<head[minIndex])
//                {
//                    minIndex = j;
//                }
            }
            //outPut head[minIndex]
            indexs[minIndex]++;
            head[minIndex] = logs[minIndex][indexs[minIndex]];
        }while(true);

    }
}
