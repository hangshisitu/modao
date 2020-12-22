package modao.db;

import sun.nio.cs.ext.MacHebrew;

import java.util.Arrays;

public class YanHuiSanJiao {
    private int minPath = Integer.MAX_VALUE;

    public int shortPath(int[][] data)
    {
//        int path = 0;
//        backTrace(data,0,0,path);
        dp(data);
        return minPath;
    }

    public void backTrace(int[][] data,int depth,int j,int path)
    {
        if(depth == data.length)
        {
            minPath = Math.min(path,minPath);
            return;
        }
        if(data[depth][j]==-1)
        {
            return;
        }
        path += data[depth][j];
        backTrace(data,depth+1,j,path);
        backTrace(data,depth+1,j+1,path);
    }

    public void dp(int[][] data)
    {
        int[][] states = new int[data.length][data.length];
        for(int i=0;i<states.length;++i)
        {
            Arrays.fill(states[i],-1);
        }
        states[0][0] = data[0][0];
        for(int i=1; i<data.length;++i)
        {
            for(int j=0; j<=i;++j)
            {
                if(j>0)
                {
                    states[i][j] = states[i-1][j-1] + data[i][j];
                }
                if(states[i-1][j]!=-1)
                {
                    states[i][j] = states[i-1][j] + data[i][j];
                }
            }
        }

        for(int i=0; i<states[states.length-1].length; ++i)
        {
            minPath = Math.min(minPath,states[states.length-1][i]);
        }
    }
}
