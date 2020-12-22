package ByteDance;

import modao.backtrace.AssignBike;

import java.beans.IndexedPropertyDescriptor;
import java.util.*;

public class Test4 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

    }

    public static void doFun2(List<List<String>> data)
    {
        int max = 0;
        Map<String,Integer> preFrame = new HashMap<>();
        Map<String,Integer> currFrame = new HashMap<>();
        for(int i=0; i<data.size();++i)
        {
            for(int j=0;j<data.get(i).size();++j)
            {
                if(preFrame.containsKey(data.get(i).get(j)))
                {
                    currFrame.put(data.get(i).get(j),preFrame.get(data.get(i).get(j))+1);
                }else
                {
                    currFrame.put(data.get(i).get(j),1);
                }
                if(currFrame.get(data.get(i).get(j))>max)
                {
                    max =  currFrame.get(data.get(i).get(j));
                }
            }
            preFrame.clear();
            preFrame.putAll(currFrame);
        }
    }

    public static void doFun(List<List<String>> data)
    {
        Map<String,List<Integer>> map = new HashMap<>();
        for(int i=0; i<data.size();++i)
        {
            for(int j=0; j<data.get(i).size();++j)
            {
                if(map.containsKey(data.get(i).get(j)))
                {
                    map.get(data.get(i).get(j)).add(i);
                }else
                {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    map.put(data.get(i).get(j), temp);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        String key ="";
        for( Map.Entry<String,List<Integer>> entry: map.entrySet())
        {
            List<Integer> temp = entry.getValue();
            int first =0;
            int pre = temp.get(0);
            for(int i=1;i<temp.size();++i)
            {
                if(temp.get(i) != pre+1)
                {

                    if(i-first>max)
                    {
                        max = i-first;
                        start = first;
                        end = i;
                        key = entry.getKey();
                    }
                    first = i;
                }
                pre = temp.get(i);
            }
        }
    }
}
