import java.util.ArrayList;
import java.util.LinkedList;

//最长回文子串
public class LongestCycSubString {

    //时间复杂度O(n**3)
    public String doFun(String s)
    {
        String res="";
        for(int i=0; i<s.length();++i)
        {
            for(int j=i+1; j<=s.length(); ++j)
            {
                String subString = s.substring(i,j);
                if(isCycString(subString))
                {
                    if(subString.length()>res.length())
                    {
                        res = subString;
                    }
                }
            }
        }
        return res;
    }

    public boolean isCycString(String s)
    {
        for(int i=0,j=s.length()-1;i<=j;++i,--j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
        }
        return true;
    }

    //时间复杂度O(n**2)
    //空间复杂度O(n**2)
    public String doMain(String s)
    {
        byte[][] byteTable = new byte[s.length()][s.length()];

        String res = "";
        for(int j=0;j<s.length();++j)
        {
            for(int i=j;i>=0;--i)
            {
                if(i==j)
                {
                    byteTable[i][j] = (byte) 1;
                }
                else if(i+1==j && s.charAt(i) == s.charAt(j))
                {
                    byteTable[i][j] = (byte) 1;
                }else if( j>=1 && s.charAt(i) == s.charAt(j) && byteTable[i+1][j-1]==(byte)1)
                {
                    byteTable[i][j] = (byte) 1;
                }else
                {
                    continue;
                }
                if(res.length() < j-i+1)
                {
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;

    }
}
