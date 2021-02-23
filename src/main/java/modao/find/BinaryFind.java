package modao.find;

public class BinaryFind {

    public int findRecursion(int[] array,int target)
    {
        return binaryFind(array,0,array.length-1,target);
    }

    public int binaryFind(int[] array, int left, int right, int target)
    {
        if(left==right)
        {
            if(array[left]==target)
            {
                return left;
            }
            return -1;
        }

        int res = -1;
        int mid = left + ((right-left)>>>1);
        while(left<right)
        {
            if(array[mid]==target)
            {
                return mid;
            }else if (array[mid]>target)
            {
                res = binaryFind(array,left,mid,target);
            }else
            {
                res = binaryFind(array,mid+1,right,target);
            }
        }
        return res;
    }

    //二分查找，非递归实现
    public int find(int[] array, int target) {

        int left=0;
        int right = array.length-1;
        while(left<=right)
        {
            int mid = left + ((right-left)>>>1);
            if(array[mid]==target)
            {
                return mid;
            }else if(array[mid]>target)
            {
                right= mid-1;
            }else
            {
                left = mid+1;
            }
        }
        return -1;
    }

    //查找第一个等于目标值的元素
    public int findFirstEQ(int[] array, int target)
    {
        int left=0;
        int right = array.length-1;
        while(left<=right)
        {
            int mid = left + ((right-left)>>>1);
            if(array[mid]>target)
            {
                right = mid-1;
            }else if(array[mid]<target)
            {
                left = mid+1;
            }else {
               if(mid==0 || array[mid-1]!=target)
               {
                   return mid;
               }else
               {
                   right = mid-1;
               }
           }
        }
        return -1;
    }

    //查找最后一个等于目标值的元素
    public int findLastEQ(int[] array, int target)
    {
        int left=0;
        int right = array.length-1;
        while(left<=right)
        {
            int mid = left + ((right-left)>>>1);
            if(array[mid]==target)
            {
                if(mid==array.length-1 || array[mid+1]!=target)
                {
                    return mid;
                }else
                {
                    left = mid+1;
                }
            }else if(array[mid]>target)
            {
                right= mid-1;
            }else
            {
                left = mid+1;
            }
        }
        return -1;
    }

    //查找第一个大于等于目标值的元素
    public int findLastGE(int[] array, int target)
    {
        int left=0;
        int right = array.length-1;
        while(left<=right)
        {
            int mid = left + ((right-left)>>>1);
            if(array[mid]>=target)
            {
                if( mid==0 || array[mid-1]<target)
                {
                    return mid;
                }else
                {
                    right = mid-1;
                }
            }else
            {
                left = mid+1;
            }
        }
        return -1;
    }

    //查找第一个大于目标值的元素
    public int findLastGT(int[] array, int target)
    {
        int left=0;
        int right = array.length-1;
        while(left<=right)
        {
            int mid = left + ((right-left)>>>1);
            if(array[mid]>target)
            {
                if(mid==0 || array[mid-1]<=target)
                {
                    return mid;
                }else
                {
                    right= mid-1;
                }
            }else
            {
                left = mid+1;
            }
        }
        return  -1;
    }

    //查找最后一个小于等于目标值的元素
    public int findLastLE(int[] array, int target)
    {
        int left=0;
        int right = array.length-1;
        while(left<=right)
        {
            int mid = left + ((right-left)>>>1);
            if(array[mid]>target)
            {
                right= mid-1;
            }else
            {
                if(mid==array.length-1 || array[mid+1]>target)
                {
                    return mid;
                }else
                {
                    left = mid+1;
                }
            }
        }
        return  -1;
    }

    public int findReverseEQ(int[] array, int target)
    {
        int left=0;
        int right=array.length-1;
        int split=-1;
        for(int i=0;i<array.length-1;++i)
        {
            if(array[i]>array[i+1])
            {
                split = i+1;
                break;
            }
        }
        if(split!=-1)
        {
            if(array[0]>target)
            {
                left=split;
            }
            if(array[array.length-1]<target)
            {
                right=split-1;
            }
        }

        //二分查找
        while(left<=right)
        {
            int mid = left + ((right-left)>>>1);
            if(array[mid]==target)
            {
                return mid;
            }else if(array[mid]>target)
            {
                right= mid-1;
            }else
            {
                left = mid+1;
            }
        }
        return -1;

    }
}
