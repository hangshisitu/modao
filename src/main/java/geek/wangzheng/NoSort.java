package geek.wangzheng;

//大小写相对有序
//大小写字母和数组相对有序
public class NoSort {

    public void sort(char[] array)
    {
        char[] temp = new char[array.length];
        int t=0;
        for(int i=0;i<array.length;++i)
        {
            if(array[i]>'Z')
            {
                temp[t] = array[i];
                ++t;
            }
        }
        for(int i=0;i<array.length;++i)
        {
            if(array[i]<'a')
            {
                temp[t] = array[i];
                ++t;
            }
        }
        for(int i=0;i<temp.length;++i)
        {
            array[i] = temp[i];
        }
    }

    public void sort2(char[] array)
    {
        int left=0;
        int right = array.length-1;
        for(;left<right;)
        {
            while(left<right && array[left]>'Z')
            {
                ++left;
            }
            while(right>left && array[right]<'a')
            {
                --right;
            }
            char temp=array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }

    public void sort3(char[] array)
    {
        int left=0;
        int right = array.length-1;
        for(;left<right;)
        {
            while(left<right && array[left]>'Z')
            {
                ++left;
            }
            while(right>left && array[right]<'a')
            {
                --right;
            }
            char temp=array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        right = array.length-1;
        for(;left<right;)
        {
            while(left<right && array[left]<'A')
            {
                ++left;
            }
            while(right>left && array[right]>'9')
            {
                --right;
            }
            char temp=array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }
}
