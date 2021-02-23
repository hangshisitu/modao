package leetcode.binarysearch;

//最大子序和
public class C53 {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums,0,nums.length-1);
    }

    public int maxSubArray(int[] nums, int left,int right)
    {
        if(left==right)
        {
            return nums[left];
        }
        int mid = left+((right-left)>>1);
        int leftMax = maxSubArray(nums,left,mid);
        int rightMax = maxSubArray(nums,mid+1,right);
        //求中间情况的最大值midMax, 再取max(leftMax,rightMax,midMax)

        int midLeftMax=nums[mid];
        int temp = 0;
        for(int i=mid;i>=left;--i)
        {
            temp += nums[i];
            midLeftMax = Math.max(midLeftMax,temp);
        }
        int midRightMax = nums[mid+1];
        temp = 0;
        for(int i=mid+1;i<=right;++i)
        {
            temp += nums[i];
            midRightMax = Math.max(midRightMax,temp);
        }
        int midMax = midLeftMax+midRightMax;

        return Math.max(leftMax,Math.max(midMax,rightMax));
    }
}
