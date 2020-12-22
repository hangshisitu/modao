package modao.backtrace;

import java.util.*;

//校园单车分配
public class AssignBike {


    public class Pair
    {
        public int distance;
        public int workerIndex;
        public int bikesIndex;
        public Pair(int distance,int workerIndex,int bikesIndex)
        {
           this.distance = distance;
           this.workerIndex = workerIndex;
           this.bikesIndex = bikesIndex;
        }
    }

    public int[] assignBikes3(int[][] workers, int[][] bikes)
    {
        int[] result = new int[workers.length];
        Pair[] pairs = new Pair[workers.length*bikes.length];
        int t=0;
        for(int i=0; i<workers.length;++i)
        {
            for(int j=0;j<bikes.length;++j)
            {
                int distance =  Math.abs(workers[i][0]-bikes[j][0]) + Math.abs(workers[i][1]-bikes[j][1]);
                pairs[t] = new  Pair(distance,i,j);
                ++t;
            }
        }
        Arrays.sort(pairs,new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2)
            {
                return o1.distance - o2.distance;
            }
        });
        Set<Integer> useBikes = new HashSet<Integer>();
        Set<Integer> useWorkers = new HashSet<Integer>();
        for(int i=0; i<pairs.length; ++i)
        {
            Pair pair = pairs[i];
            if(useBikes.contains(pair.bikesIndex) || useWorkers.contains(pair.workerIndex))
            {
                continue;
            }

            if(result[pair.workerIndex]==-1)
            {
                result[pair.workerIndex] = pair.bikesIndex;
                useBikes.add(pair.bikesIndex);
                useWorkers.add(pair.workerIndex);
            }
        }
        return result;
    }

    public int[] assignBikes2(int[][] workers, int[][] bikes)
    {
        int[] result = new int[workers.length];
        Arrays.fill(result,-1);
        int n = (int)Math.pow(workers.length,2);
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>(n,new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.distance!=o2.distance)
                {
                    return o1.distance - o2.distance;
                }
                if(o1.workerIndex != o2.workerIndex)
                {
                    return o1.workerIndex - o2.workerIndex;
                }
                return o1.bikesIndex - o2.bikesIndex;
            }
        });
        for(int i=0; i<workers.length;++i)
        {
            for(int j=0;j<bikes.length;++j)
            {
                int distance =  Math.abs(workers[i][0]-bikes[j][0]) + Math.abs(workers[i][1]-bikes[j][1]);
                priorityQueue.offer(new Pair(distance,i,j));
            }
        }
        Set<Integer> useBikes = new HashSet<Integer>();
        Set<Integer> useWorkers = new HashSet<Integer>();
        do {

            Pair pair = priorityQueue.poll();
            if(useBikes.contains(pair.bikesIndex) || useWorkers.contains(pair.workerIndex))
            {
                continue;
            }
            if(result[pair.workerIndex]==-1)
            {
                result[pair.workerIndex] = pair.bikesIndex;
                useBikes.add(pair.bikesIndex);
                useWorkers.add(pair.workerIndex);
            }

        }while(!priorityQueue.isEmpty());
        return result;
    }

    //穷据法
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] result = new int[workers.length];
        Arrays.fill(result,-1);
        Set<Integer> useBikes = new HashSet<Integer>();
        Set<Integer> useWorkers = new HashSet<Integer>();
        int c = 0;
        do {
            for(int i=0; i<workers.length;++i)
            {
                if(result[i]!=-1)
                {
                    continue;
                }
                int leasteIndexBike = findLeasteIndex(workers[i][0],workers[i][1],bikes,useBikes);
                int leasteIndexWorke = findLeasteIndex(bikes[leasteIndexBike][0],bikes[leasteIndexBike][1],workers,useWorkers);
                if(leasteIndexWorke == i)
                {
                    result[i] = leasteIndexBike;
                    c++;
                    useBikes.add(leasteIndexBike);
                    useWorkers.add(leasteIndexWorke);
                }
            }
        }while(c<workers.length);

        return result;
    }

    public int findLeasteIndex(int x, int y, int[][] data, Set<Integer> used)
    {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0;i<data.length;++i)
        {
            if(used.contains(i))
            {
                continue;
            }
            if(Math.abs(x-data[i][0]) + Math.abs(y-data[i][0]) < min)
            {
                index = i;
                min = Math.abs(x-data[i][0]) + Math.abs(y-data[i][0]);
            }
        }
        return index;
    }



}
