package modao.backtrace;

import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SplitIntoFibonacci {

    public List<Integer> splitIntoFibonacci(String S) {
        Stack<Integer> path = new Stack<>();
        List<Integer> result = new ArrayList<>();
        backTrace(S,0,path,result);
        return result;
    }

    public boolean backTrace(String s,int depth,Stack<Integer> path,List<Integer> result)
    {
        if(depth==s.length())
        {
            if(path.size()>2)
            {
                for(int i=0;i<path.size();++i)
                {
                    result.add(path.elementAt(i));
                }
                return true;
            }
            return false;
        }

        for(int i=1;i<=s.length()-depth;++i)
        {
            String substr = s.substring(depth,depth+i);
            if(substr.length()>1 && substr.charAt(0)=='0')
            {
                break;
            }
            Integer temp =null;
            try {
                temp = Integer.valueOf(substr);
            }catch (NumberFormatException e)
            {
                break;
            }

            if(path.size()>1 )
            {
                if(temp > (path.elementAt(path.size()-1) + path.elementAt(path.size()-2)))
                {
                    break;
                }else if(temp < (path.elementAt(path.size()-1) + path.elementAt(path.size()-2)))
                {
                    continue;
                }
            }
            path.push(temp);
            if(backTrace(s,depth+i,path,result))
            {
                return true;
            }
            path.pop();
        }
        return false;
    }
}
