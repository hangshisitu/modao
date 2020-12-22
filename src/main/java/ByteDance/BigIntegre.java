package ByteDance;

import java.util.Arrays;

public class BigIntegre {

    public int[] add(int[] a, int[] b)
    {
        int size = Math.max(a.length,b.length)+1;
        int[] res = new int[size];
        int i= a.length-1;
        int j= b.length-1;
        int k=size-1;
        int up = 0;
        do {
            int temp = up;
            if(i>=0)
            {
                temp += a[i];
            }
            if(j>=0)
            {
                temp += a[j];
            }
            res[k] = temp%10;
            up = temp/10;
            i--;
            j--;
            k--;
        }while(i>=0 || j>=0 || up !=0);

        if(res[0]==0)
        {
            return Arrays.copyOfRange(res,1,res.length);
        }

        return res;
    }

}
