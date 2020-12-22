import java.util.Arrays;

//无重复字符子串
public class NoRepeateCharSubString {

    //时间复杂度O(n**3)
    //空间复杂度O(1)
    public String doMain(String s)
    {
        String res="";
        byte[] bytes = new byte[129];
        for(int i=0;i<s.length();++i)
        {
            for(int j=i+1;j<=s.length();++j)
            {
                Arrays.fill(bytes,(byte)0);
                String subString = s.substring(i,j);
                if(isNoRepeatedChar(subString,bytes))
                {
                    if(res.length()<subString.length())
                    {
                        res = subString;
                    }
                }
            }
        }
        return res;
    }

    public boolean isNoRepeatedChar(String s,byte[] bytes)
    {
        for(int i=0;i<s.length();++i)
        {
            if(bytes[(int)s.charAt(i)]==(byte)1)
            {
                return false;
            }else
            {
                bytes[(int)s.charAt(i)]=(byte)1;
            }
        }
        return true;
    }

    //时间复杂度O(n)
    //空间复杂度O(1)
    public String doMain2(String s)
    {
        String res="";
        int[] char2Position = new int[129];
        Arrays.fill(char2Position,-1);
        int i=0;
        for(int j=0;j<s.length();++j)
        {
            int c = (int)s.charAt(j);
            if(char2Position[c]!=-1 && char2Position[c]>=i) {
                i = char2Position[c]+1;
            }
            char2Position[c]=j;

            if(res.length()<s.substring(i,j+1).length())
            {
                res = s.substring(i,j+1);
            }
        }
        return res;
    }
}
