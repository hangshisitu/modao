public class WhiteBlack {

    //穷举法
    public int cellBrush(int n, int k)
    {
        if(k==n*n)
        {
            return 1;
        }
        if(n>k)
        {
            return 0;
        }
        int total = 0;

        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n; ++j)
            {
                if(k == (i+j)*n - i*j)
                {
                    total +=(cnm(n,i)*cnm(n,j));
                }
            }
        }

        return total;
    }

    //计算组合数
    public int cnm(int n, int m)
    {
        int res =1;
        for(int i=n;i>n-m;--i)
        {
            res = res*i;
        }
        int temp = 1;
        for(int i=1; i<=m; ++i)
        {
            temp = temp*i;
        }
        return res/temp;
    }
}
