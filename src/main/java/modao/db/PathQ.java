package modao.db;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//最短路径
public class PathQ {

    int minValue = Integer.MAX_VALUE;
    //回溯法
    public void minPath(int[][] weights,int startX,int startY, int endX,int endY, int currValue)
    {

        if(startX==endX && startY==endY)
        {
            if(currValue<minValue)
            {
                minValue = currValue;
            }
            return;
        }

        if(startY<endY)
        {
            minPath(weights,startX,startY+1,endX,endY,currValue+weights[startX][startY+1]);
        }

        if(startX<endX)
        {
            minPath(weights,startX+1,startY,endX,endY,currValue+weights[startX+1][startY]);
        }
    }

    //最短路径
    public int minPath2(int[][] weights, int startX, int startY, int endX, int endY, int minValue, Stack<String> path, int currValue,List<String> minPath)
    {
        if(startX==endX && startY==endY)
        {
            if(currValue<minValue)
            {
                minValue = currValue;
                minPath.clear();
                minPath.addAll(path);
            }
            return minValue;
        }

        if(startY<endY)
        {
            path.push(String.format("%d_%d",startX,startY+1));
            minValue = minPath2(weights,startX,startY+1,endX,endY,minValue,path,currValue+weights[startX][startY+1],minPath);
            path.pop();
        }

        if(startX<endX)
        {
            path.push(String.format("%d_%d",startX+1,startY));
            minValue = minPath2(weights,startX+1,startY,endX,endY,minValue,path,currValue+weights[startX+1][startY],minPath);
            path.pop();
        }

        return minValue;
    }

    //回溯法，所有走法
    public void minPath3(int[][] weights, int startX, int startY, int endX, int endY,Stack<String> path,List<List<String>> res)
    {
        if(startX==endX && startY==endY)
        {
            res.add(new ArrayList<String>(path));
        }

        if(startY<endY)
        {
            path.push(String.format("%d_%d",startX,startY+1));
            minPath3(weights,startX,startY+1,endX,endY,path,res);
            path.pop();
        }

        if(startX<endX)
        {
            path.push(String.format("%d_%d",startX+1,startY));
            minPath3(weights,startX+1,startY,endX,endY,path,res);
            path.pop();
        }
    }

    //动态规划法
    public int minPath4(int[][] weights,int startX, int startY, int endX, int endY)
    {
        int[][] status = new int[endX-startX+1][endY-startY+1];
        status[0][0] = weights[startX][startY];

        for(int i=startX+1; i<=endX;++i)
        {
            status[i][0] = status[i-1][0] + weights[i][0];
        }

        for(int i=startY+1; i<=endY;++i)
        {
            status[0][i] = status[0][i-1] + weights[0][i];
        }

        for(int i=1;i<=endX;++i)
        {
            for(int j=1;j<=endY;++j)
            {
                status[i][j] = Math.min(status[i][j-1],status[i-1][j]) + weights[i][j];
            }
        }

        return status[endX][endY];
    }

    //动态规划递归版
    public int minPath5(int[][] weights,int endX, int endY)
    {
        if(endX==0 )
        {
            int sum = 0;
            for(int i=0;i<=endY;++i)
            {
                sum +=weights[0][i];
            }
            return sum;
        }
        if(endY==0)
        {
            int sum = 0;
            for(int i=0;i<=endX;++i)
            {
                sum +=weights[i][0];
            }
            return sum;
        }
        return weights[endX][endY] + Math.min(minPath5(weights,endX-1,endY),minPath5(weights,endX,endY-1));
    }

}
