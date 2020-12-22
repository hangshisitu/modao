package modao.sliding.window;

import java.util.Arrays;

public class C395 {

    //穷举法
    public int longestSubstring(String s, int k) {

        int[] count = new int[26];
        int result = 0;
        for(int i=0;i<s.length();++i)
        {
            Arrays.fill(count,0);
            for(int j=i;j<s.length();++j)
            {
                count[s.charAt(j)-'a'] +=1;
                boolean isMatch = true;
                for(int t=0;t<26;++t)
                {
                    if(count[t]>0 && count[t]<k)
                    {
                        isMatch = false;
                        break;
                    }
                }
                if(isMatch)
                {
                    result = Math.max(result,j-i+1);
                }
            }
        }
        return result;
    }

    //分而治之
    private int[] count = new int[26];
    public int longestSubstring2(String s, int k) {
        if(s.length()==0)
        {
            return 0;
        }
        int result=0;
        Arrays.fill(count,0);
        for(int i=0;i<s.length();++i)
        {
            count[s.charAt(i)-'a'] +=1;
        }
        char temp = 0;
        for(int i=0; i<count.length;++i)
        {
            if(count[i]>0 && count[i]<k)
            {
                temp = (char)('a'+i);
                break;
            }
        }
        if(temp==0)
        {
            return s.length();
        }else
        {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(temp);
            String[] subStr = s.split(stringBuilder.toString());
            for(int i=0; i<subStr.length;++i)
            {
                result = Math.max(result,longestSubstring2(subStr[i],k));
            }
        }

        return result;
    }

    //滑动窗口法
    public int longestSubstring3(String s, int k) {
        int result = 0;
        int[] count = new int[26];
        for(int i=1;i<=26;++i)
        {
            Arrays.fill(count,0);
            int left=0;
            int right=0;
            int diffCount = 0;
            int matchCount = 0;
            while(right<s.length())
            {

                count[s.charAt(right)-'a'] +=1;
                if(count[s.charAt(right)-'a']==1)
                {
                    ++diffCount;
                }
                if(count[s.charAt(right)-'a']==k)
                {
                    ++matchCount;
                }

                ++right;

                while(left<right && diffCount>i)
                {
                    if(count[s.charAt(left)-'a'] == k)
                    {
                        --matchCount;
                    }
                    if(count[s.charAt(left)-'a'] == 1)
                    {
                        --diffCount;
                    }
                    count[s.charAt(left)-'a'] -=1;
                    ++left;
                }

                if(matchCount == i)
                {
                    result = Math.max(result,right-left);
                }
            }
        }
        return result;
    }
}
