package geek.wangzheng;

//求平方根，精确到小数点后6位
public class SquareRoot {
    public String square(int a)
    {
        StringBuilder stringBuilder = new StringBuilder();

        int left=0;
        int right = a;
        while(left<=right)
        {
            int mid = left +((right-left)>>2);
            int temp = mid*mid;
            if(temp==a)
            {
                stringBuilder.append(mid).append(".");
                Float b = Float.parseFloat(stringBuilder.toString());
                if(a-b==0)
                {
                    //结束
                }else
                {

                }
            }else if(temp>a)
            {
                right =mid-1;
            }else
            {
                if((mid+1)*(mid+1)>a)
                {
                    stringBuilder.append(mid).append(".");

                }
                left = mid+1;
            }
        }
        return "null";
    }
}
//3
//1
