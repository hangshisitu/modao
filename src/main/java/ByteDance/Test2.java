package ByteDance;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test2 {

    public static void main(String [] args)
    {
        Scanner scaner = new Scanner(System.in);
        int n = scaner.nextInt();
        int d = scaner.nextInt();
        boolean[] pos = new boolean[1000000];
        for(int i=0;i<n;++i)
        {
            pos[scaner.nextInt()]=true;
        }

        int j=0;
        while(!pos[j])
        {
            ++j;
        }
        int cnt =0;
        for(int t=j+1;t<=j+d;++t)
        {
            if(pos[t])
            {
                ++cnt;
            }
        }


        int total =0 ;
//        for(int i=0;i<pos.length-2;++i)
//        {
//            for(int j=i+1;j<pos.length-1;++j)
//            {
//                for(int k=j+1; k<pos.length;++k)
//                {
//                    if(pos[k]-pos[i]<=d)
//                    {
//                        ++total;
//                    }
//                }
//            }
//        }

        System.out.println(total);
    }

//    public static int doFun(int[] pos, int d)
//    {
//        int total =0 ;
//        for(int i=0;i<pos.length-2;++i)
//        {
//            for(int j=i+i;j<pos.length-1;++j)
//            {
//                for(int k=j+1; k<pos.length-1;++k)
//                {
//                    if(pos[k]-pos[i]<=d)
//                    {
//                        ++total;
//                    }
//                }
//            }
//        }
//        return total;
//    }
}
