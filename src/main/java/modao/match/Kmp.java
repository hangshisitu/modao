package modao.match;

import java.util.Arrays;

public class Kmp {

    public int[] genericNext(String pattern)
    {
        int[] next = new int[pattern.length()];
        Arrays.fill(next,-1);
        int length = pattern.length();
        for(int i=0;i<pattern.length();++i)
        {
            String subString = pattern.substring(0,i+1);
            for(int j=0;j<subString.length()-1;j++)
            {
                if(subString.substring(0,j+1).equals(subString.substring(subString.length()-j-1,subString.length())))
                {
                    next[i] = j;
                }
            }
        }
        return next;
    }

    private static int[] getNexts(char[] b, int m)
    {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i)
        {
            while (k != -1 && b[k + 1] != b[i])
            {
                k = next[k];
            }
            if (b[k + 1] == b[i])
            {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    public int kmp(String s,String pattern)
    {
        int[] next = getNexts(pattern.toCharArray(),pattern.length());
        int j=0;
        for(int i=0;i<s.length();++i)
        {
            while(j>0 && s.charAt(i)!=pattern.charAt(j))
            {
                j = next[j-1]+1;
            }
            if(s.charAt(i) == pattern.charAt(j))
            {
                ++j;
            }
            if(j==pattern.length())
            {
                return i-j+1;
            }
        }
        return -1;
    }
}
