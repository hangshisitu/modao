public class HalfSearch {

        /**
         * 二分查找
         * @param n int整型 数组长度
         * @param v int整型 查找值
         * @param a int整型一维数组 有序数组
         * @return int整型
         */
        public int upper_bound_ (int n, int v, int[] a) {
            // write code here
            if(n==0)
            {
                return 1;
            }
            return halfSearch(a,0,n-1,v);
        }

        public int halfSearch(int[] a,int left,int right,int v)
        {

            if(left==right)
            {
                if(a[left]>=v)
                {
                    return left+1;
                }else
                {
                    return a.length+1;
                }
            }
            int mid = (left+right)/2;
            int res = -1;
            if(a[mid]<v)
            {
                res = halfSearch(a,mid+1,right,v);
            }else if(a[mid]>v)
            {
                res = halfSearch(a,left,mid,v);
            }else {
                while (mid >= 1) {
                    if (a[mid - 1] == v) {
                        mid--;
                    } else {
                        break;
                    }
                }
                return mid + 1;
            }
            return res;
        }
}
