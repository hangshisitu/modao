package modao.db;

import java.util.Arrays;
import java.util.BitSet;

public class LengthOfLIS {
    private int maxLength = 0;

    BitSet bitSet = new BitSet();
    public int lengthOfLIS(int[] nums) {

        if(nums.length==0)
        {
            return 0;
        }
        if(nums.length==1)
        {
            return 1;
        }

//        maxLength = 0;
//        memo = new boolean[nums.length][nums.length];
//
//        backTrace(nums,0,Integer.MIN_VALUE,0);
        maxLength = dp(nums);
        return maxLength;
    }

    //回溯法
    public void backTrace(int[] nums,int depth,int pre,int length)
    {
        if(depth==nums.length)
        {
            maxLength = Math.max(maxLength,length);
            return;
        }

        //包括当前节点
        if(nums[depth]>pre)
        {
            backTrace(nums,depth+1,nums[depth],length+1);
        }else
        {
            backTrace(nums,depth+1,pre,1);
        }

        //不包括当前节点
        backTrace(nums,depth+1,pre,length);
    }

    private boolean[][] memo;
    //回溯法+备忘录
    //
    public void backTrace2(int[] nums,int depth,int pre,int length)
    {
        if(depth==nums.length)
        {
            maxLength = Math.max(maxLength,length);
            return;
        }
        if(memo[depth][pre])
        {
            return;
        }
        //包括当前节点
        if(nums[depth]>nums[pre])
        {
            backTrace2(nums,depth+1,depth,length+1);
        }else if(nums[depth]<nums[pre])
        {
            backTrace2(nums,depth+1,depth,1);
        }else
        {
            backTrace2(nums,depth+1,depth,length);
        }

        //不包括当前节点
        backTrace2(nums,depth+1,pre,length);

        memo[depth][pre] =true;
    }


    public int dp(int[] nums)
    {
        if(nums.length==0)
        {
            return 0;
        }

        int[] states = new int[nums.length];
        states[0] = 1;
        int maxValue = states[0];
        for(int i=1; i<nums.length;++i)
        {
            states[i]=1;
            for(int j=0; j<i;++j)
            {
               if(nums[i]>nums[j])
               {
                   states[i] = Math.max(states[i],states[j]+1) ;
               }
            }
            maxValue = Math.max(maxValue,states[i]);
        }

        return maxValue;
    }
    //5,7,-24,12,13,2,3,12,5,6,35
    //4,10,4,3,8,9


}
