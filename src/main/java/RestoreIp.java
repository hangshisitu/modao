import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//恢复ip
public class RestoreIp {

    //回溯法
    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<String>();
        Stack<Integer> path = new Stack<Integer>();
        backTrace(s,0,s.length(),0,path,result);
        return result;

    }

    public void backTrace(String s,int depth,int n,int curr,Stack<Integer>path,List<String> result)
    {
        if(depth==4)
        {
            if(curr == s.length())
            {
                result.add(buildRes(path));
            }
            return;
        }
        for(int i=curr+1;i<=s.length();i++)
        {
            String tempStr = s.substring(curr,i);
            if(tempStr.length()>1 && tempStr.charAt(0)=='0')
            {
                break;
            }
            int temp = Integer.valueOf(s.substring(curr,i));
            if(temp<=255 && temp>=0)
            {
                path.push(temp);
                backTrace(s,depth+1,n,i,path,result);
                path.pop();
            }else
            {
                break;
            }
        }

    }
    public String buildRes(Stack<Integer>path)
    {
        return String.format("%d.%d.%d.%d",path.elementAt(0),path.elementAt(1),path.elementAt(2),path.elementAt(3));
    }
}
