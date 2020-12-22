public class NextPermutation {

    public void nextPermutation(int[] nums) {
        for(int i=nums.length-1;i>=0;--i)
        {
            for(int j=i-1;j>=0;--j)
            {
                if(nums[j]<nums[i])
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    fastSort(nums,j+1,nums.length-1);
                    return;
                }
            }
        }
        fastSort(nums,0,nums.length-1);
    }

    public void fastSort(int[] nums,int left,int right)
    {
        if(left>=right)
        {
            return;
        }
        int i=left;
        int j=right;
        int key = nums[i];
        while(i<j)
        {
            while(j>i && nums[j]>=key)
            {
                j--;
            }
            nums[i] = nums[j];

            while(i<j && nums[i]<=key)
            {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = key;
        fastSort(nums,left,i-1);
        fastSort(nums,i+1,right);
    }
}
