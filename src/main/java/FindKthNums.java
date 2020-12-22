public class FindKthNums {

    public int findKthNumber(int n, int k) {
       int[] nums = new int[n];
       for(int i=0;i<n;++i)
       {
           nums[i]= i+1;
       }
       //已经有序的情况下快速排序退化成O(n**2), 需要进行散列。
       return quickSelect(nums,k,0,n-1);
    }

    public int quickSelect( int[] nums, int k, int left, int right)
    {
        if(left>=right)
        {
            return nums[right];
        }

        int i= left;
        int j= right;
        int key = nums[i];
        while(i<j)
        {
            while(j>i && GT(nums[j],key))
            {
                j--;
            }
            nums[i]=nums[j];
            while(i<j && GT(key,nums[i]))
            {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = key;
        if(k-1==i)
        {
            return nums[i];
        }
        if(k-1<i)
        {
            return quickSelect(nums,k,left,i-1);
        }else
        {
            return quickSelect(nums,k,i+1,right);
        }
    }

    boolean GT( int a, int b)
    {
        String strA = String.format("%d",a);
        String strB = String.format("%d",b);
        for(int i=0;i<strA.length()&&i<strB.length();++i)
        {
            if(strA.charAt(i)>strB.charAt(i))
            {
                return true;
            }else if(strA.charAt(i)<strB.charAt(i))
            {
                return false;
            }
        }
        if(strA.length()>=strB.length())
        {
            return true;
        }else
        {
            return false;
        }
    }
}
