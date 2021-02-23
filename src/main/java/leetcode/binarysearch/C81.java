package leetcode.binarysearch;

//在升序旋转数组中查找指定元素
public class C81 {
    public boolean search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right)
        {
            int mid = left+((right-left)>>>1);
            if(nums[mid] == target)
            {
                return true;
            }
            if(nums[mid]>nums[left])
            {
                if(nums[left]<=target && target<nums[mid])
                {
                    right = mid-1;
                }else
                {
                    left = mid+1;
                }
            }else if(nums[mid]<nums[left])
            {
                if(nums[mid]<target && target<=nums[right])
                {
                    left = mid+1;
                }else
                {
                    right = mid-1;
                }
            }else
            {
                left +=1;
            }
        }
        return false;
    }
}
