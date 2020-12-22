package modao.array;

public class MinSubArray {

    public int minSubArrayLen(int s, int[] nums) {
        int left =0;
        int right =0;
        int sum = 0;
        int minLenght = Integer.MAX_VALUE;
        while(right<nums.length)
        {
            while(right <nums.length && sum<s)
            {
                sum += nums[right];
                ++right;
            }
            if(right==nums.length)
            {
                break;
            }
            minLenght = Math.min(minLenght,right-left+1);
            while(left<right)
            {
                sum -= nums[left];
                ++left;
                if(sum <s)
                {
                    break;
                }
                minLenght = Math.min(minLenght,right-left+1);
            }

        }

        return minLenght==Integer.MAX_VALUE?0:minLenght;
    }

    public int minSubArrayLen2(int s, int[] nums)
    {

        int sum = 0;
        int left,right;
        left=0;
        right=-1;
        int minLength = nums.length + 1;
        while(right<nums.length)
        {
            while(right<nums.length)
            {
                ++right;
                if(right<nums.length)
                {
                    sum += nums[right];
                }
                if(sum >=s)
                {
                    minLength = Math.min(minLength,right-left+1);
                    break;
                }
            }
            if(right == nums.length)
            {
                break;
            }

            while(left<right)
            {
                sum -= nums[left];
                ++left;
                if(sum>=s)
                {
                    minLength = Math.min(minLength,right-left+1);
                }else
                {
                    break;
                }
            }
        }
        return minLength==nums.length+1?0:minLength;
    }
}