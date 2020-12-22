package geek.wangzheng;

//    假设猎聘网有 10 万名猎头顾问，
//    每个猎头顾问都可以通过做任务（比如发布职位），
//    来积累积分，然后通过积分来下载简历。
//
//    假设你是猎聘网的一名工程师，如何在内存中存储这 10 万个猎头 ID 和积分信息，
//    让它能够支持这样几个操作：
//    根据猎头的 ID 快速查找、删除、更新这个猎头的积分信息；
//    查找积分在某个区间的猎头 ID 列表；
//    查询积分从小到大排在第 x 位的猎头 ID 信息；
//    查找按照积分从小到大排名在第 x 位到第 y 位之间的猎头 ID 列表。

import apple.laf.JRSUIUtils;

import java.util.*;

public class Hunters {

    class Hunter
    {
        public Integer id;
        public Integer score;
    }


    class IndexNode
    {
        Integer score;
        Integer nextIndex;
    }

    class SkipTable
    {
        private LinkedList<Hunter> linkedList = new LinkedList<>();
        private ArrayList<LinkedList<IndexNode>> arrayList = new ArrayList<>();

        public void add(Hunter hunter)
        {
            int nextIndex =0;
            for(int i=arrayList.size()-1;i>=0;i--)
            {
                LinkedList<IndexNode> temp = arrayList.get(i);
                int pre = nextIndex;
                int curr = nextIndex;
                for(;curr<temp.size();++curr)
                {
                    if(temp.get(curr).score.equals(hunter.score))
                    {
                        nextIndex = temp.get(curr).nextIndex;
                        break;
                    }else if(temp.get(curr).score > hunter.score)
                    {
                        nextIndex = temp.get(pre).nextIndex;
                        break;
                    }
                    pre = curr;
                }
            }
            Math.random();
            linkedList.get(nextIndex);
        }

        public void remove(Integer id)
        {

        }

        public List<Hunter> findByGTScore(Integer score)
        {
            int nextIndex =0;
            for(int i=arrayList.size()-1;i>=0;i--)
            {
                LinkedList<IndexNode> temp = arrayList.get(i);
                int pre = nextIndex;
                int curr = nextIndex;
                for(;curr<temp.size();++curr)
                {
                    if(temp.get(curr).score.equals(score))
                    {
                        nextIndex = temp.get(curr).nextIndex;
                        break;
                    }else if(temp.get(curr).score > score)
                    {
                        nextIndex = temp.get(pre).nextIndex;
                        break;
                    }
                    pre = curr;
                }
            }
            return linkedList.subList(nextIndex,linkedList.size()-1);
        }

        public List<Hunter> findByScoreRange(Integer lowScore,Integer upScore)
        {
            int nextIndex =0;
            for(int i=arrayList.size()-1;i>=0;i--)
            {
                LinkedList<IndexNode> temp = arrayList.get(i);
                int pre = nextIndex;
                int curr = nextIndex;
                for(;curr<temp.size();++curr)
                {
                    if(temp.get(curr).score.equals(lowScore))
                    {
                        nextIndex = temp.get(curr).nextIndex;
                        break;
                    }else if(temp.get(curr).score > lowScore)
                    {
                        nextIndex = temp.get(pre).nextIndex;
                        break;
                    }
                    pre = curr;
                }
            }
            int j=nextIndex;
            for(;j<linkedList.size();++j)
            {
                if(linkedList.get(j).score>upScore)
                {
                    break;
                }
            }
            return linkedList.subList(nextIndex,j-1);
        }

    }
    private HashMap<Integer,Hunter> hunterHashMap=null;
    private TreeMap<Integer,Hunter> hunterTreeMap=null;

    public Hunters()
    {
        hunterHashMap = new HashMap<>();
        hunterTreeMap = new TreeMap<>();
    }

    public void add(Hunter hunter)
    {
        hunterHashMap.put(hunter.id,hunter);
        hunterTreeMap.put(hunter.score,hunter);
    }

    public Hunter findById(Integer id)
    {
        return hunterHashMap.get(id);
    }

    public void removeById(Integer id)
    {
        Hunter hunter = hunterHashMap.get(id);
        hunterTreeMap.remove(hunter.score,hunter);
        hunterHashMap.remove(hunter.id);
    }
}
