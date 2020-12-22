package modao.array;

public class LongestOnes {

    public int longestOnes(int[] A, int K) {

        int left =0;
        int right=1;
        int maxLenght = -1;
        for(;right<A.length && left < right;++right)
        {
            if(A[right]!=1)
            {
                int c = 0;
                for(int i=left;i<=right;++i)
                {
                    if(A[left]!=0)
                    {
                        continue;
                    }
                    c++;
                }
                if(c<=K)
                {
                    maxLenght = Math.max(maxLenght, right - left + 1);
                }else
                {
                    ++left;
                }
            }else
            {
                maxLenght = Math.max(maxLenght, right - left + 1);
            }
        }
        return 0;
    }

    public int longestOnes2(int[] A, int K)
    {
        int[][] states = new int[A.length][A.length];
        if(A[0]==0)
        {
            states[0][0] = 1;
        }
        if(A[A.length-1]==0)
        {
            states[A.length-1][0] = 1;
        }
        for(int i=1;i<A.length;++i)
        {
            states[0][i] = states[0][i-1] + A[i]==0?1:0;
        }
        for(int j=A.length-2;j<A.length;--j)
        {
            states[j][0] = states[j+1][0] = A[j]==0?1:0;
        }

        int max = -1;
        for(int i=1;i<A.length;++i)
        {
            for(int j=1;j<A.length;++j)
            {
                if(states[i][j]<=K)
                {
                    int temp = Math.abs(i-j+1);
                    max = Math.max(max,temp);
                }
            }
        }
        return max==-1? 0: max;
    }

    public int longestOnes3(int[] A, int K) {

        int left,right;
        left=0;
        right=-1;
        int maxLength = 0;
        while(right<A.length)
        {
            while(right<A.length)
            {
                right +=1;
                if(right == A.length)
                {
                    break;
                }
                if(A[right]==0)
                {
                    K -=1;
                }
                if(K<0)
                {
                    break;
                }else
                {
                    maxLength = Math.max(maxLength,right-left+1);
                }
            }

            while(left<right)
            {
                left +=1;
                if(A[left]==0)
                {
                    K +=1;
                }
                if(K>=0)
                {
                    break;
                }
            }
        }
        return maxLength;
    }
}
