package ByteDance;

import java.util.*;

public class Test5 {

    public static void main(String[] args)
    {
        int v=6;
        int[][] edges ={{0,1,2,3,4,5},{1,0,2,3,4,5},{2,2,0,2,3,4},{3,3,2,0,4,5},{4,4,3,4,0,5},{5,5,4,5,5,0}};

        Set<Integer> used = new HashSet<>();
        int cost = 0;
        int minCost = Integer.MAX_VALUE;
        int[] path = new int[6];
        Arrays.fill(path,-1);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] minPath = new int[6];
        minCost = backTrace2(0,edges,path,edges.length,used,cost,minCost,result,minPath);
        System.out.println(minCost);
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i <minPath.length;++i)
        {
            temp.add(minPath[i]);
        }
        System.out.println(temp);
        System.out.println(result);
        System.out.println(result.size());
    }


    public static int backTrace2(int depth,int[][] edges,int[] path, int n, Set<Integer> used,int cost,int minCost,List<List<Integer>> res,int[] minPath)
    {
        if(depth==n)
        {
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<path.length;++i)
            {
                temp.add(path[i]);
            }
            res.add(temp);
            if(cost+edges[depth-1][path[0]]<minCost)
            {
                for(int i=0; i<path.length;++i)
                {
                    minPath[i] = path[i];
                }
            }
            return Math.min(cost+edges[depth-1][path[0]],minCost);
        }
        for(int i=0;i<n;++i)
        {
            if(used.contains(i))
            {
                continue;
            }

            if(depth>0)
            {
                cost += edges[path[depth-1]][i];
            }
            used.add(i);
            path[depth]=i;
            if(cost < minCost)
            {
                minCost = backTrace2(depth+1,edges,path,n,used,cost,minCost,res,minPath);
            }
            used.remove(i);
            if(depth>0)
            {
                cost -= edges[path[depth-1]][i];
            }
            path[depth]=-1;
        }
        return minCost;
    }
}
