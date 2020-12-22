import java.util.ArrayList;

//爬楼梯
public class DynamicSample {

    public int doMain(int start, int end)
    {
        int[] stepCnt = new int[end];
        for(int i=end-1;i>=start;--i)
        {
            int cnt = 0;
            if(end-i==1)
            {
                stepCnt[i] =1;
            }else if(end-i==2)
            {
                stepCnt[i] =2;
            }else
            {
                stepCnt[i] = stepCnt[i+1]+ stepCnt[i+2];
            }
        }
        return stepCnt[start];
    }
}
