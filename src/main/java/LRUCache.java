import java.util.*;

class LRUCache {

    public class Data {
        private int value;
        private long time;
        public Data(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
        public void setValue(int value)
        {
            this.value=value;
        }

        public long getTime()
        {
            return time;
        }
        public void setTime(long time)
        {
            this.time = time;
        }
    }

    int capacity;
    Map<Integer,Data> hashMap;
    TreeMap<Long, List<Integer>> treeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<Integer,Data>(capacity);
        treeMap = new TreeMap<Long,List<Integer>>();
    }

    public int get(int key) {
        if(!hashMap.containsKey(key))
        {
            return -1;
        }
        Data data = hashMap.get(key);
        long preTime = data.getTime();
        long currTime = System.currentTimeMillis();
        data.time = currTime;
        updateTreeMap(key,preTime,currTime);
        return data.getValue();
    }

    public void put(int key, int value) {

        if(hashMap.containsKey(key))
        {
           Data data = hashMap.get(key);
           data.setValue(value);
           long preTime = data.getTime();
           long currTime = System.currentTimeMillis();
           data.setTime(currTime);
           updateTreeMap(key,preTime,currTime);
        }else
        {
            if(hashMap.size()==capacity)
            {
                Map.Entry<Long,List<Integer>> entry =  treeMap.firstEntry();
                int delKey = entry.getValue().get(0);
                hashMap.remove(delKey);
                entry.getValue().remove((Integer) delKey);
                if(entry.getValue().isEmpty())
                {
                    treeMap.remove(entry.getKey());
                }
            }
            long preTime =0L;
            Data data = new Data(value);
            long currTime = System.currentTimeMillis();
            data.setTime(currTime);
            hashMap.put(key,data);
            updateTreeMap(key,preTime,currTime);
        }

    }

    public void updateTreeMap(int key,long preTime,long currTime)
    {
        if(treeMap.containsKey(preTime))
        {
            List<Integer> pre = treeMap.get(preTime);
            pre.remove((Integer)key);
            if(pre.isEmpty())
            {
                treeMap.remove(preTime);
            }
        }
        if(treeMap.containsKey(currTime))
        {
            List<Integer> curr = treeMap.get(currTime);
            curr.add(key);
        }else
        {
            if(treeMap.size()>capacity)
            {
                treeMap.remove(treeMap.firstKey());
            }

            List<Integer> tmp = new LinkedList<Integer>();
            tmp.add(key);
            treeMap.put(currTime,tmp);
        }
    }
}
