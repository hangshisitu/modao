import java.util.ArrayList;
import java.util.Arrays;

public class GrayCode {

        public String[] getGray(int n) {
            // write code here
            ArrayList<Integer> res = new ArrayList<Integer>();
            res.add(0);
            int head = 1;
            for(int i=0;i<n;i++)
            {
                for(int j=res.size()-1;j>=0;--j)
                {
                    res.add(res.get(j)+head);
                }
                head <<=1;
            }
            String[] result = new String[res.size()];
            for(int i=0;i<res.size();++i)
            {
                String temp = Integer.toBinaryString(res.get(i));
                String item = "";
                for(int j=0; j<n-temp.length();++j)
                {
                    item +="0";
                }
                item +=temp;
                result[i] = item;
            }
            return result ;
        }

    public String[] getGray2(int n) {
        int size= (int)Math.pow(2,n);
        String[] tmmp = new String[size];
        tmmp[0]="0";
        if(n==0)
        {
            return tmmp;
        }
        tmmp[1]="1";
        if(n==1)
        {
            return tmmp;
        }
        for(int i=2;i<=n;++i)
        {
            int k=0;
            int preSize = (int)Math.pow(2,i-1);
            for(int j=0;i<preSize;++j)
            {
                StringBuilder stringBuilder = new StringBuilder(tmmp[j]);
                stringBuilder.insert(0,"0");
                tmmp[k] = stringBuilder.toString();
                tmmp[k] = "0"+tmmp[j];
                ++k;
            }
            for(int t=preSize-1;t>=0;--t)
            {
                tmmp[k] = "1" +tmmp[t];
                ++k;
            }
        }
        return tmmp;
    }
}
