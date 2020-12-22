package modao.db;


import java.util.Map;
import java.util.List;
public class LongestCommonSubstring {

    Map<String,String> test;
    int maxLength = 0;
    public int longestCommonSubstring(String s1,String s2)
    {
        maxLength = Integer.MIN_VALUE;
//        int length = 0;
//        backTrace(s1.toCharArray(),s2.toCharArray(),0,0,length);

//        memo = new boolean[s1.length()][s2.length()];
//        backTraceEx(s1.toCharArray(),s2.toCharArray(),0,0,length);

        maxLength = dp(s1.toCharArray(),s2.toCharArray());
        return maxLength;
    }

    //回溯法
    public void backTrace(char[] s1, char[] s2,int i, int j,int length)
    {
        if(i==s1.length || j==s2.length)
        {
            maxLength = Math.max(maxLength,length);
            return;
        }
        if(s1[i]==s2[j])
        {
            backTrace(s1,s2,i+1,j+1,length+1);
        }else
        {
            backTrace(s1,s2,i+1,j, length);
            backTrace(s1,s2,i,j+1,length);
        }
    }

    private boolean[][] memo;
    //回溯法+备忘录
    public void backTraceEx(char[] s1, char[] s2,int i, int j,int length)
    {
        if(i==s1.length || j==s2.length)
        {
            maxLength = Math.max(maxLength,length);
            return;
        }
        if(memo[i][j])
        {
            //已经处理过的场景
            return;
        }

        if(s1[i]==s2[j])
        {
            backTrace(s1,s2,i+1,j+1,length+1);
        }else
        {
            backTrace(s1,s2,i+1,j, length);
            backTrace(s1,s2,i,j+1,length);
        }
        memo[i][j] = true;
    }

    public int dp(char[] s1,char[] s2)
    {
        int[][] states = new int[s1.length][s2.length];
        if(s1[0]==s2[0])
        {
            states[0][0] = 1;
        }
        for(int i=1;i<s1.length;++i)
        {
            if(s1[i]==s2[0])
            {
                states[i][0] = 1;
            }else
            {
                states[i][0] = states[i-1][0];
            }
        }
        for(int j=1;j<s2.length;++j)
        {
            if(s2[j]==s1[0])
            {
                states[0][j] = 1;
            }else
            {
                states[0][j] = states[0][j-1];
            }
        }

        for(int i=1; i<s1.length;++i)
        {
            for(int j=1; j<s2.length;++j)
            {
                if(s1[i]==s2[j])
                {
                    int temp = Math.max(states[i-1][j],states[i][j-1]);
                    temp = Math.max(temp,states[i-1][j-1]+1);
                    states[i][j] =temp;
                }else
                {
                    int temp = Math.max(states[i-1][j],states[i][j-1]);
                    temp = Math.max(temp,states[i-1][j-1]);
                    states[i][j] = temp;
                }
            }
        }
        return states[s1.length-1][s2.length-1];
    }
}
