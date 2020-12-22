package modao.db;

import java.util.Arrays;

//找零
public class Change {

    int minCount=0;
    public int change(int[] coins, int amount)
    {
//        minCount = Integer.MAX_VALUE;
//        int currAmount =0;
//        int currCount =0;
//        backTrace(coins,amount,currAmount,currCount);

//        minCount = recursion(coins,amount);

//        memo = new int[amount+1];
//        Arrays.fill(memo,-1);
//        minCount = recursionEx(coins,amount);

        Arrays.sort(coins);
        minCount = dp(coins,amount);
        if(minCount == Integer.MAX_VALUE)
        {//没有可行的找零方案
            return -1;
        }
        return minCount;
    }

    //回溯法
    public void backTrace(int[] coins,int amount, int currAmount,int currCount)
    {
        if(currAmount==amount)
        {
            minCount = Math.min(minCount,currCount);
            return;
        }

        for(int i=0;i<coins.length;++i)
        {
            if(coins[i]+currAmount<=amount)
            {
                backTrace(coins,amount,coins[i]+currAmount,currCount+1);
            }
        }
    }

    //递归法
    public int recursion(int[] coins,int amount)
    {
        if(amount ==0)
        {
            return 0;
        }

        int temp = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;++i)
        {
            if(amount>=coins[i])
            {
                temp = Math.min(temp,recursion(coins,amount-coins[i]));
            }
        }
        if(temp == Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }
        return temp+1;
    }

    private int[] memo = null;
    //递归法+备忘录
    public int recursionEx(int[] coins,int amount)
    {
        if(memo[amount]!=-1)
        {
            return memo[amount];
        }

        if(amount ==0)
        {
            return 0;
        }

        int temp = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;++i)
        {
            if(amount>=coins[i])
            {
                temp = Math.min(temp,recursion(coins,amount-coins[i]));
            }
        }

        int result = 0;
        if(temp == Integer.MAX_VALUE)
        {
            result = temp;
        }else
        {
            result = temp +1;
        }

        memo[amount] = result;
        return result;
    }

    //动态规划
    public int dp(int[] coins, int amount)
    {
        int[][] states = new int[coins.length][amount+1];

        for(int t=0;t<=amount;++t)
        {
            if(t<coins[0])
            {
                states[0][t] = 0;
            }else if(t==coins[0])
            {
                states[0][t]=1;
            }else
            {
                if(states[0][t-coins[0]]>0)
                {
                    states[0][t] = states[0][t-coins[0]] + 1;
                }else
                {
                    states[0][t] = 0;
                }
            }
        }

        for(int i=1; i<coins.length;++i)
        {
            for(int j=0; j<=amount;++j)
            {
                if(j<coins[i])
                {
                    states[i][j]=states[i-1][j];
                }else if(j==coins[i])
                {
                    states[i][j]=1;
                }else
                {
                    if(states[i][j-coins[0]]>0)
                    {
                        states[i][j] = states[i][j-coins[i]] + 1;
                    }else
                    {
                        states[i][j] = 0;
                    }
                }
            }
        }
        int minCount = Integer.MAX_VALUE;
        for(int i=0; i<coins.length ;++i)
        {
            if(states[i][amount]>0)
            {
                minCount = Math.min(minCount,states[i][amount]);
            }
        }
        return minCount;
    }

}
