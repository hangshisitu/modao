//快速排序
public class QuerySort {

//    public void sort(int[] nums)
//    {
//        if(nums.length==0){
//            return ;
//        }
//
//        int left = 0;
//        int key = nums[left];
//        int right = nums.length-1;
//        while(left<right)
//        {
//            while(nums[right]>key && right>left )
//            {
//                right--;
//            }
//            nums[left] = nums[right];
//            left++;
//            while(nums[left]<key && left<right)
//            {
//                left++;
//            }
//            nums[right] = nums[left];
//        }
//        nums[left] = key;
//        quickSort(nums,0,left);
//        quickSort(nums,left+1,rigth);
//    }

    public void quickSort(int[] nums, int left, int right)
    {
        if(left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int key = nums[i];

        while(i<j)
        {
            while(nums[j]>=key && j>i )
            {
                j--;
            }
            if(j>i)
            {
                nums[i] = nums[j];
                i++;
            }

            while(nums[i]<=key && i<j)
            {
                i++;
            }
            if(i<j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = key;
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }
}
