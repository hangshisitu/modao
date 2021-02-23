package modao.sort;

/**
 * 二分插入排序，相对应普通插入排序，虽然移动原始没有变，但是原始比较的次数大大减少。
 * 稳定排序
 * 原地排序
 * 最好情况时间复杂度O(logn),平均时间复杂度O(n)
 * @author qiaojun.xiao
 */
public class BinaryInsertionSort {

    public void sort(int[] nums)
    {
        for(int i=1; i<nums.length;++i)
        {
            int left=0;
            int right=i-1;
            int curr = nums[i];
            while(left<=right)
            {
                int mid = (left + right) / 2;
                if (nums[mid] > curr) {
                    right = mid-1;
                } else if (nums[mid] <= curr) {
                    left = mid + 1;
                }
            }

            for(int j=i;j>left;--j)
            {
                nums[j]=nums[j-1];
            }
            nums[left] = curr;
        }
    }

}
