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

import java.util.*;
import modao.skip.list.SkipList;
public class Hunters {

    public static class Hunter
    {
        public Integer id;
        public Integer score;
        public Hunter(Integer id, Integer score)
        {
            this.id = id;
            this.score = score;
        }
        @Override
        public String toString()
        {
            return String.format("id: %d,score: %d",id,score);
        }
    }


    private HashMap<Integer,Hunter> hunterHashMap=null;
    private SkipList<Hunter> skipList = null;

    public Hunters()
    {
        hunterHashMap = new HashMap<>();
        skipList = new SkipList<Hunter>();
    }

    public void add(Hunter hunter)
    {
        hunterHashMap.put(hunter.id,hunter);
        skipList.add(hunter.score,hunter);
    }

    //通过id查找
    public final Hunter findById(Integer id)
    {
        return hunterHashMap.get(id);
    }

    //左闭右开区间
    public List<Hunter> findByScoreRange(Integer lowScore,Integer highScore)
    {
        return skipList.findListByRange(lowScore,highScore);
    }

    //通过id删除
    public void removeById(Integer id)
    {
        Hunter hunter = hunterHashMap.get(id);

        skipList.remove(hunter.score,hunter);

        hunterHashMap.remove(hunter.id);
    }

    //通过id更新积分
    public void updateScoreById(Integer id, Integer score)
    {
        Hunter hunter = hunterHashMap.get(id);
        skipList.remove(hunter.score,hunter);
        hunter.score = score;
        skipList.add(hunter.score,hunter);
    }

    public Hunter rankByScore(int x)
    {
        PriorityQueue<Hunter>  priorityQueue = new PriorityQueue<>((Hunter o1, Hunter o2)->{return o2.score-o1.score;});

        for(Hunter hunter: hunterHashMap.values())
        {
            if(priorityQueue.size()<x)
            {
                priorityQueue.add(hunter);
            }else
            {
                if(hunter.score<priorityQueue.peek().score)
                {
                    priorityQueue.poll();
                    priorityQueue.add(hunter);
                }
            }
        }

        return priorityQueue.poll();
    }

    public Hunter[] rankByScoreRange(int x,int y)
    {
        PriorityQueue<Hunter>  priorityQueue = new PriorityQueue<>((Hunter o1, Hunter o2)->{return o2.score-o1.score;});

        for(Hunter hunter: hunterHashMap.values())
        {
            if(priorityQueue.size()<y)
            {
                priorityQueue.add(hunter);
            }else
            {
                if(hunter.score<priorityQueue.peek().score)
                {
                    priorityQueue.poll();
                    priorityQueue.add(hunter);
                }
            }
        }

        Hunter[] huntes = new Hunter[y-x+1];
        for(int i=huntes.length-1;i>=0;--i)
        {
            huntes[i] = priorityQueue.poll();
        }

        return huntes;
    }
}
