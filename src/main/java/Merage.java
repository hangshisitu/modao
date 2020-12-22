import java.util.*;

public class Merage {

    public static  int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<Object>(){
            @Override
            public int compare(Object a, Object b)
            {
                int [] tempA = (int [])a;
                int [] tempB = (int [])b;
                if(tempA[0] < tempB[0] )
                {
                    return -1;
                }else if(tempA[0]>tempB[0])
                {
                    return 1;
                }else
                {
                    return 0;
                }
            }
        });

        int[][] res = new int[intervals.length][2];
        int[] pre = intervals[0];
        int j=0;
        for(int i=1; i<intervals.length;++i)
        {
            int[] curr = intervals[i];
            if(curr[0]>pre[1])
            {
                res[j] = pre;
                pre = intervals[i];
                ++j;
            }else {
                if (curr[1] > pre[1]) {
                    pre[1] = curr[1];
                }
            }
        }
        res[j]=pre;
        return Arrays.copyOf(res,j+1);
    }

    public static  boolean isValid(String s)
    {
        List<List<Integer>> tempList = new ArrayList<List<Integer>>();
        Map<Character,Character> kv=new HashMap<Character,Character>(6);
        kv.put('(',')');
        kv.put('[',']');
        kv.put('{','}');
        Stack<Character> stack= new Stack<Character>();
        for(int i=0;i<s.length();++i)
        {
            if(stack.isEmpty())
            {
                stack.push(s.charAt(i));
            }else
            {
                if(!kv.containsKey(stack.peek()))
                {
                    return false;
                }else if(kv.get(stack.peek()).equals(s.charAt(i)))
                {
                    stack.pop();
                }else
                {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }

}
