import java.util.Arrays;

//二分查找
public class TwoSearch {


    public int[] twoSearch(char[][] src, char[][] patten)
    {
        int[] result = new int[2];
        Arrays.fill(result,-1);
        for(int i=0; i<src.length-patten.length+1;++i)
        {
            for(int j=0; j<src[0].length-patten[0].length+1;++j)
            {
                if(compare(patten,src,i,j))
                {
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }

    public boolean compare(char[][] patten, char[][] src, int i, int j)
    {
        for(int t=0; t<patten.length;++t)
        {
            int w = j;
            for(int k=0;k<patten.length;++k)
            {
                if(patten[t][k]!=src[i][w])
                {
                    return false;
                }
                w++;
            }
            i++;
        }
        return true;
    }
}
