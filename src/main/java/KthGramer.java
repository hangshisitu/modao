public class KthGramer {

    public int kthGrammar(int N, int K) {
        byte[] temp = new byte[1<<N-1];
        for(int i=1;i<N;++i)
        {
            int t=1<<(i-1);
            t-=1;
            for(int j=(1<<i)-1;j>=0 && t>=0;j-=2)
            {
                if(temp[t]==0)
                {
                    temp[j] = 1;
                    temp[j-1] = 0;
                }else
                {
                    temp[j] = 0;
                    temp[j-1] = 1;
                }
                t--;
            }
        }
        return temp[K-1];
    }

    public int kthGrammar2(int N, int K) {
        return recursiveKthGrammar(N,K);
    }

    public int recursiveKthGrammar(int N,int K)
    {
        if(N==1)
        {
            return 0;
        }

        if(K%2==0)
        {
            int temp = recursiveKthGrammar(N-1,K/2);
            if(temp ==0)
            {
                return 1;
            }else
            {
                return 0;
            }
        }else
        {
            int temp = recursiveKthGrammar(N-1,K/2+1);
            if(temp == 0)
            {
                return 0;
            }else
            {
                return 1;
            }
        }

    }
}
