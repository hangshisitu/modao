//快速选择
public class QuickSelect {

    public int quickSelect(int[] nums, int k, int left, int right)
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
            while(j>i && nums[j]>=key)
            {
                j--;
            }
            if(j>i)
            {
                nums[i]=nums[j];
                i++;
            }
            while(i<j && nums[i]<=key)
            {
                i++;
            }
            if(i<j)
            {
                nums[j] = nums[i];
                j--;
            }
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

    public int quickSelect2(int[] nums, int k, int left, int right)
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
            while(j>i && nums[j]>=key)
            {
                j--;
            }
            if(j>i)
            {
                nums[i]=nums[j];
                i++;
            }
            while(i<j && nums[i]<=key)
            {
                i++;
            }
            if(i<j)
            {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = key;
        if(k-1==i)
        {
            return nums[i];
        }else if(k-1<i)
        {
            return quickSelect2(nums,k,left,i-1);
        }else
        {
            return quickSelect2(nums,k,i+1,right);
        }
    }


    public int quickSelect3( int[] nums, int k, int left, int right)
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
            return quickSelect3(nums,k,left,i-1);
        }else
        {
            return quickSelect3(nums,k,i+1,right);
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
