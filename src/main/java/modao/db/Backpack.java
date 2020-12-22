package modao.db;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Backpack {

    private int maxWeight = 0;

    public int backPack(int[] backPacks,int limit)
    {
        Set<Integer> used = new HashSet<>();
        int weight = 0;
        int depth = 0;
        int[] path = new int[backPacks.length];
        Arrays.fill(path,-1);
//        return backTrace(backPacks,0,path,used,limit,weight,maxWeight);
//        boolean[][] states = new boolean[backPacks.length][limit];
//        backTrace2(backPacks,0,limit,weight,states);
//        return maxWeight;
        return dp(backPacks,limit);
    }

    public int backTrace(int[] backPacks,int depth,int[]path, Set<Integer> used,int limit, int weight,int maxWeight)
    {
        if(weight>limit)
        {
            return Math.max(weight-backPacks[path[depth-1]],maxWeight);
        }
        if(depth==backPacks.length)
        {
            return Math.max(weight,maxWeight);
        }

        for(int i=0;i<backPacks.length;++i)
        {
            if(used.contains(i))
            {
                continue;
            }
            used.add(i);
            path[depth]=i;
            weight += backPacks[i];

            maxWeight = backTrace(backPacks,depth+1,path,used,limit,weight,maxWeight);
            used.remove(i);
            path[depth]=-1;
            weight -= backPacks[i];
        }
        return maxWeight;
    }

    public void backTrace2(int[] backPacks,int depth,int limit, int weight,boolean[][] states)
    {
        if(weight == limit || depth==backPacks.length)
        {
            this.maxWeight = Math.max(weight,this.maxWeight);
            return;
        }
        if(states[depth][weight])
        {
            return;
        }
        states[depth][weight]=true;
        backTrace2(backPacks,depth+1,limit,weight,states);
        if(weight+backPacks[depth]<=limit)
        {
             backTrace2(backPacks,depth+1,limit,weight+backPacks[depth],states);
        }
    }

    //动态规划
    public int dp(int[] backPacks, int limit)
    {
        boolean[][] states = new boolean[backPacks.length][limit+1];
        states[0][0] = true;
        if(backPacks[0]<=limit)
        {
            states[0][backPacks[0]] = true;
        }

        for(int i=1;i<backPacks.length;++i)
        {
            for(int j=0; j<=limit; ++j)
            {
                if(states[i-1][j])
                {
                    states[i][j] = true;
                }
            }
            for(int j=0; j<= limit - backPacks[i]; ++j)
            {
                if(states[i-1][j])
                {
                    states[i][j+backPacks[i]] = true;
                }
            }
        }
        for(int i=limit; i>=0; --i)
        {
            if(states[backPacks.length-1][i])
            {
                return i;
            }
        }
        return 0;
    }
}
