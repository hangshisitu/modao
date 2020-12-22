package modao.array;

public class LongestNorepeateSubArray {

    public int lengthOfLongestSubstring(String s) {
        Integer max = 0;
        if(s.length()==0)
        {
            return 0;
        }
        int j=1;
        max =1;
        for(int i=0;i<s.length() && j<s.length();++j)
        {
            char c=s.charAt(j);
            int cfi = 0;
            for(int k=i; k<j;++k)
            {
                if(s.charAt(k)==c)
                {
                    i = k+1;
                    cfi = 1;
                    break;
                }
            }
            if(cfi==0)
            {
                max = Math.max(j-i+1,max);
            }
        }
        return max;
    }

}
