import java.util.Arrays;
import java.util.Comparator;

//股票买卖
public class MaxProfit {

    public static int maxProfit(int[] prices) {

        int profix = 0;
        int i=0;
        int j=i+1;
        for(;i<prices.length-1 && j<prices.length;)
        {
            if(prices[j]>=prices[j-1])
            {
                ++j;
            }else
            {
                profix += prices[j-1]-prices[i];
                i=j;
                j=i+1;
            }
        }
        if(j == prices.length)
        {
            profix += prices[j-1]-prices[i];
        }
        return profix;
    }

    public static int maxProfit2(int[] prices) {

        int[][] temp = new int[10][2];

        int[] profits = new int[2];
        for(int i=0;i<prices.length;++i)
        {
            int sub= 0;
            for(int j=i+1;j<prices.length;++j)
            {
                sub = prices[j]-prices[i];
                if(sub<0)
                {
                    continue;
                }
                if(profits[0]>profits[1])
                {
                    if(sub>profits[1])
                    {
                        profits[1] =sub;
                    }
                }else
                {
                    if(sub>profits[0])
                    {
                        profits[0] =sub;
                    }
                }
            }
        }
        return profits[0] + profits[1];
    }
}
