package ByteDance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test3 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = 14;
        int[] cards = new int[n];
        cards[n-1] = Integer.MAX_VALUE;
        for(int i=0; i<n-1;++i)
        {
             cards[i] = scanner.nextInt();
        }
        Arrays.sort(cards);
        Set<Integer> fourCnt = new HashSet<Integer>();
        int first = 0;
        int curr = 0;
        for(int i=0; i<n;++i)
        {
            if(cards[i]==curr )
            {
                if(i-first+1==4)
                {
                    fourCnt.add(curr);
                }
            }else
            {
                curr = cards[i];
                first = i;
            }
        }

        for(int i=1;i<=9;++i)
        {
            if(fourCnt.contains(i))
            {
                continue;
            }
            cards[n-1] = i;
            int [] temp = Arrays.copyOf(cards,n);
            Arrays.sort(temp);
            if(isHu(temp,n,false))
            {
                System.out.println(i);
            }
        }
    }

    public static boolean isHu(int[] cards,int n,boolean flag)
    {
        if(n==0)
        {
            return true;
        }

        if(n<2)
        {
            return false;
        }

        if(!flag && cards[n-1]==cards[n-2])
        {

            return isHu(cards,n-2,true);
        }
        else
        {
            if(n<3)
            {
                return false;
            }
            if (cards[n - 1] == cards[n - 2] && cards[n - 2] == cards[n - 3])
            {
                return isHu(cards,n-3,flag);
            }else if(cards[n-1] == cards[n-2]+1 && cards[n-2] == cards[n-3]+1)
            {
                return isHu(cards,n-3,flag);
            }
        }

        return false;
    }
}
