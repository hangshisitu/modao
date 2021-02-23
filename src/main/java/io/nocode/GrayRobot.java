package io.nocode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GrayRobot {

    public static class Fibonacci{

        /**
         * 斐波那契数列生成器(注意末项=limit，不一定满足递推公式)
         * @param first
         * @param second
         * @param limit
         * @return
         */
        public static int[] genFibonacci(int first,int second, int limit)
        {
            if(limit<first)
            {
                throw new RuntimeException("数列末项不能比首项小");
            }

            List<Integer> result = new LinkedList<Integer>();
            result.add(first);

            if(second<limit)
            {
                result.add(second);
            }

            int curr = first+second;
            while(curr<limit)
            {
                result.add(curr);
                first = second;
                second = curr;
                curr = first+second;
            }
            result.add(limit);
            int[] res = new int[result.size()];
            for(int i=0;i<result.size();++i)
            {
                res[i] = result.get(i);
            }
            return res;
        }
    }

    /**
     * 灰度放量基数。例如按百分比放量base=100,
     * 按千分比放量base=1000。
     */
    private int base;

    /**
     * 灰度放量时间间隔,单位为秒。
     * 例如base=100, spanTime=60，按斐波那契数列放量时
     * 从1%，到%2，到%3, 到%5,时间间隔都是1分钟。
     */
    private int spanTime;

    /**
     * 随机数生成器
     */
    private Random random;

    private int curr;
    private long preTime;

    private int[] data;

    /**
     * 灰度是否开启
     */
    private boolean isActive;

    /**
     * 暂停标志位(暂停后,灰度保持当前比例不变，直到重新调用on再次开启)
     */
    private boolean isPause;


    public GrayRobot(int base, int spanTime)
    {
        if(base<=0 || spanTime<=0)
        {
            throw new RuntimeException("base or spanTime 小于0");
        }
        this.base = base;
        this.spanTime = spanTime;
        this.random = new Random();
        this.curr = 0;
        this.preTime = 0;
        this.data = Fibonacci.genFibonacci(1,2,base);
        on();
    }

    /**
     * 判断key是否在灰度名单
     * @param key 灰度业务key
     * @return 在key灰度名单内，返回true,反之返回false。
     */
    public boolean isGrayKey(String key)
    {
        int mod = (int)key.hashCode()%this.base;
        return isGrayKey(mod);
    }

    /**
     * 判断key是否在灰度名单
     * @param key 灰度业务key
     * @return 在key灰度名单内，返回true,反之返回false。
     */
    public boolean isGrayKey(Long key)
    {
        int mod = (int)(key%this.base);
        return isGrayKey(mod);
    }

    private boolean isGrayKey(int mod)
    {
        if(!isActive)
        {
            return false;
        }

        long currSeconds = System.currentTimeMillis()/1000;
        if(this.preTime==0)
        {
            this.preTime = currSeconds;
        }
        if(!isPause)
        {
            long span = (currSeconds-this.preTime)/spanTime;
            if(span>0)
            {
                curr += span;
                curr = Math.min(curr,this.data.length-1);
                this.preTime = currSeconds;
            }
        }

        return mod<this.data[curr]? true:false;
    }

    /**
     * 判断本次调用是否在灰度名单
     * @return 在灰度名单内，返回true,反之返回false。
     */
    public boolean isGrayKey()
    {
        return isGrayKey(random.nextInt(base));
    }

    /**
     * 重置到初始态开始放量
     */
    public void reset()
    {
        curr = 0;
        this.preTime = 0;
    }

    /**
     * 修改时间间隔
     * @param spanTime 单位为秒
     */
    public void setSpanTime(int spanTime)
    {
        if(spanTime<1)
        {
            throw new RuntimeException("spanTime 要大于1");
        }
        this.spanTime = spanTime;
    }

    /**
     * 关闭灰度
     */
    public void off()
    {
        isActive = false;
    }

    /**
     * 开启灰度(可以是关闭后的，再次开启)
     */
    public void on()
    {
        isActive = true;
    }

    /**
     * 暂停(保值当前灰度比例，不再放大)
     */
    public void pause()
    {
        isPause = true;
    }

    /**
     * 暂停后继续
     */
    public void goOn()
    {
        if(isPause)
        {
            isPause = false;
            this.preTime = System.currentTimeMillis()/1000;
        }
    }

    /**
     * 预计灰度总耗时(以最新的spanTime计算的)
     * 注意，如果中途修改过spanTime, 计算值是不准确的。
     * @return 耗时秒数
     */
    public long totalCost()
    {
        return this.data.length * this.spanTime;
    }

    /**
     * 还需要多久能灰度完
     * @return
     */
    public long willTakeCost()
    {
        if(this.preTime==0)
        {
            return totalCost();
        }

        long currSeconds = System.currentTimeMillis()/1000;
        return (this.data.length-1-curr)*this.spanTime - (currSeconds-this.preTime);
    }
}
