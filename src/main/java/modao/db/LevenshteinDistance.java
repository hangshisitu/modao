package modao.db;

//编辑距离
public class LevenshteinDistance {

    public int minOptCnt=0;
    public int distance(String s1,String s2)
    {
        minOptCnt = Integer.MAX_VALUE;

//        char[] longStr = null;
//
//        char[] shortStr = null;
//        if(s1.length()>=s2.length())
//        {
//            longStr = s1.toCharArray();
//            shortStr = s2.toCharArray();
//        }else
//        {
//            longStr = s2.toCharArray();
//            shortStr = s1.toCharArray();
//        }
//        return recursion(longStr,shortStr,longStr.length-1);

//        backTrace(s1.toCharArray(),s2.toCharArray(),0,0,0);

//        memo = new boolean[s1.length()][s2.length()];
//        backTraceEx(s1.toCharArray(),s2.toCharArray(),0,0,0);
        minOptCnt = dp(s1.toCharArray(),s2.toCharArray());
        return minOptCnt;
    }

    //有BUG的方案
    public int recursion(char[] s1,char[] s2,int n)
    {
        if(n==0)
        {
            return s1[0]==s2[0] ? 0:1;
        }
        if(n>=s2.length)
        {
            return recursion(s1,s2,n-1)+1;
        }else
        {
            return recursion(s1,s2,n-1) + (s1[n] == s2[n]? 0:1);
        }
    }

    //回溯法
    public void backTrace(char[] s1,char[] s2, int i, int j, int optCnt)
    {
        if(i==s1.length || j==s2.length)
        {
            if(s2.length>j)
            {
                optCnt += s2.length-j;
            }
            if(s1.length>i)
            {
                optCnt += s1.length-i;
            }
            minOptCnt = Math.min(minOptCnt,optCnt);
            return;
        }

        if(s1[i]==s2[j])
        {
            backTrace(s1,s2,i+1,j+1,optCnt);
        }else
        {
            backTrace(s1,s2,i+1,j,optCnt+1);
            backTrace(s1,s2,i,j+1,optCnt+1);
            backTrace(s1,s2,i+1,j+1,optCnt+1);
        }
    }

    private boolean[][] memo;

    //回溯法+备忘录
    public void backTraceEx(char[] s1,char[] s2, int i, int j, int optCnt)
    {
        if(i==s1.length || j==s2.length)
        {
            if(s2.length>j)
            {
                optCnt += s2.length-j;
            }
            if(s1.length>i)
            {
                optCnt += s1.length-i;
            }
            minOptCnt = Math.min(minOptCnt,optCnt);
            return;
        }

        if(memo[i][j])
        {
            //已经处理过的场景
            return;
        }

        if(s1[i]==s2[j])
        {
            backTrace(s1,s2,i+1,j+1,optCnt);
        }else
        {
            backTrace(s1,s2,i+1,j,optCnt+1);
            backTrace(s1,s2,i,j+1,optCnt+1);
            backTrace(s1,s2,i+1,j+1,optCnt+1);
        }
        memo[i][j]=true;
    }

    public int dp(char[] s1, char[] s2)
    {
        int[][] states = new int[s1.length][s2.length];
        if(s1[0]==s2[0])
        {
            states[0][0] = 0;
        }else
        {
            states[0][0] = 1;
        }
        for(int j=1; j<s2.length;++j)
        {
            states[0][j] = states[0][j-1]+1;
        }
        for(int i=1; i<s1.length;++i)
        {
            states[i][0] = states[i-1][0]+1;
        }

        for(int i=1;i<s1.length;++i)
        {
            for(int j=1;j<s2.length;++j)
            {
                if(s1[i]==s2[j])
                {
                    int temp = Math.min(states[i-1][j]+1,states[i][j-1]+1);
                    temp = Math.min(temp,states[i-1][j-1]);
                    states[i][j] = temp;
//                    states[i][j] = states[i-1][j-1];
                }else
                {
                    int temp = Math.min(states[i-1][j],states[i][j-1]);
                    temp = Math.min(temp,states[i-1][j-1]);
                    states[i][j] = temp + 1;
                }
            }
        }
        return states[s1.length-1][s2.length-1];
    }
}
