package modao.sliding.window;

import java.util.Arrays;
import java.util.Collection;

public class MinWindow {

    public String minWindow(String s, String t) {
        int[] count = new int[128];
        String result = "";
        int minLength = Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int [] patten = new int[128];
        for(int k=0;k<t.length();++k)
        {
            patten[t.charAt(k)] +=1;
        }
        while(i<=s.length()-t.length())
        {
            for(;j<s.length();)
            {
                count[s.charAt(j)] +=1;
                if(j-i+1>=t.length() && cover(count,patten))
                {
                    if(j-i+1 < minLength)
                    {
                        result = s.substring(i,j+1);
                        minLength = result.length();
                    }
                    break;
                }
                ++j;
            }
            do {
                count[s.charAt(i)] -=1;
                ++i;
                if(cover(count,patten))
                {
                    if(j-i+1 < minLength)
                    {
                        result = s.substring(i,j+1);
                        minLength = result.length();
                    }
                }else
                {
                    break;
                }
            }while(j-i>=t.length());
            ++j;
        }
        return result;
    }

    public boolean cover(int[] count,int[] patten)
    {
        for(int i=0; i<patten.length;++i)
        {
           if(patten[i]>count[i])
           {
               return false;
           }
        }
        return true;
    }
}
