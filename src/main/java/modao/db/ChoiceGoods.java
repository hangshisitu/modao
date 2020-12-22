package modao.db;

import java.util.ArrayList;
import java.util.List;

public class ChoiceGoods {

    int maxValue = 0;
    List<Integer> result = null;
    public void choiceGoods(int[] goods, int limit)
    {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrace(goods,0,limit,0,path);
    }

    public void backTrace(int[] goods, int n, int limit , int value, List<Integer> path)
    {
        if(n==goods.length)
        {
            maxValue = Math.max(maxValue,value);
            if(value>maxValue)
            {
                result.clear();
                result.addAll(path);
            }
            return;
        }
        backTrace(goods,n+1,limit,value,path);
        if(value+goods[n]<=limit)
        {
            path.add(n);
            backTrace(goods,n+1,limit,value+goods[n],path);
            path.remove(n);
        }
    }

    public void db(int[] goods,int limit)
    {
        boolean states[][] = new boolean[goods.length][limit+1];
        if(goods[0]<=limit)
        {
            states[0][goods[0]] = true;
        }
        for(int i=1;i<goods.length;++i)
        {
            for(int j=0;j<=limit;++j)
            {
               if(states[i-1][j])
               {
                   states[i][j] = true;
               }
            }
            for(int j=0; j<=limit-goods[i];++j)
            {
                if(states[i-1][j])
                {
                    states[i][j+goods[i]] = true;
                }
            }
        }
        for(int j=limit;j>=0;--j)
        {
            if(states[goods.length-1][j])
            {
                maxValue = j;
                break;
            }
        }
        int temp = maxValue;
        for(int t=goods.length-1;t>=0 && temp>0;--t)
        {
            if(t==0 && goods[t]==temp)
            {
                result.add(t);
            }else if(states[t-1][temp-goods[t]] == true)
            {
                temp -= goods[t];
                result.add(t);
            }else if(states[t-1][temp] == true)
            {
                continue;
            }
        }
    }
}
