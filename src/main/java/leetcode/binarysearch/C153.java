package leetcode.binarysearch;

public class C153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if(nums[nums.length-1]>nums[0])
        {
            return nums[0];
        }
        if(nums.length==1)
        {
            return nums[0];
        }
        while(left<=right)
        {
            int mid = left+((right-left)>>>1);
            if( mid>0 && nums[mid-1]>nums[mid])
            {
                return nums[mid];
            }
            if(mid<nums.length-1 && nums[mid]>nums[mid+1])
            {
                return nums[mid+1];
            }
            if(nums[mid]>=nums[0])
            {
                left = mid+1;
            }else if(nums[mid]<nums[0])
            {
                right = mid;
            }
        }
        assert false;
        return -1;
    }
}
