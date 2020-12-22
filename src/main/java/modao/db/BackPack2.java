package modao.db;

public class BackPack2 {

    private int maxValue = 0;

    public int backPack2(int[] weights,int[] values, int limit)
    {
//        backTrace(0,weights,values,limit,0,0);
        dp(weights,values,limit);
        return maxValue;
    }

    public void backTrace(int depth,int[] weights,int[] values,int limit,int value,int weight)
    {
        if(weight==limit || depth==weights.length)
        {
            maxValue = Math.max(value,maxValue);
            return;
        }

        backTrace(depth+1,weights,values,limit,value,weight);
        if(weight+weights[depth]<=limit)
        {
            backTrace(depth+1,weights,values,limit,value+values[depth],weight+weights[depth]);
        }
    }

    public void dp(int[] weights,int[] values,int limit)
    {
        int[][] states = new int[weights.length][limit+1];
        for(int i=0; i<weights.length;++i)
        {
            for(int j=0 ;j<=limit;++j)
            {
                states[i][j]=-1;
            }
        }
        states[0][0]=0;
        if(weights[0]<=limit)
        {
            states[0][weights[0]] = values[0];
        }

        for(int i=1; i<weights.length;++i)
        {
            for(int j=0;j<=limit;++j)
            {
                if(states[i-1][j]>=0)
                {
                    states[i][j] = states[i-1][j];
                }
            }
            for(int j=0; j<=limit-weights[i];++j)
            {
                if(states[i-1][j]>=0)
                {

                    states[i][j+weights[i]] = Math.max(states[i][j+weights[i]],states[i-1][j] + values[i]);
                }
            }
        }

        for(int j=0; j<=limit; ++j)
        {
            if(states[weights.length-1][j]>this.maxValue)
            {
                this.maxValue = states[weights.length-1][j];
            }
        }
    }
}

