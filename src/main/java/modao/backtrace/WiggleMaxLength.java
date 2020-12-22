package modao.backtrace;

public class WiggleMaxLength {

    private int maxLength = Integer.MIN_VALUE;

    public int wiggleMaxLength(int[] nums) {
//        backTrace(nums,0,0,0,0);
//        return maxLength;
        return dp(nums);
    }

    public void backTrace(int[] nums, int n, int length, int pre, int preSub)
    {
        if(n==nums.length)
        {
            maxLength = Math.max(maxLength,length);
            return;
        }
        if(length==0 || (length==1 && nums[n]-pre !=0 ) || (preSub>0 &&  nums[n] - pre <0) || (preSub<0 && nums[n]-pre>0))
        {
            backTrace(nums,n+1,length+1,nums[n],nums[n] - pre);
        }
        backTrace(nums,n+1,length,pre,preSub);

    }

    public int dp(int[] nums)
    {
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = down[0] = 1;
        for(int i=1;i<nums.length;++i)
        {
            if(nums[i]>nums[i-1])
            {
                up[i] = Math.max(up[i-1],down[i-1]+1);
                down[i] = down[i-1];
            }else if(nums[i]<nums[i-1])
            {
                up[i] = up[i-1];
                down[i] = Math.max(down[i-1],up[i-1]+1);
            }else
            {
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        return Math.max(up[nums.length-1],down[nums.length-1]);
    }
}
