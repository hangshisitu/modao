package modao.sliding.window;

import java.util.Deque;
import java.util.LinkedList;

public class C239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];

        Deque<Integer> queue = new LinkedList<Integer>();
        int j=0;
        for(int i=0;i<nums.length;++i)
        {
            if(i>=k)
            {
                result[j] = queue.peekFirst();
                ++j;
            }
            //栈底元素已经在窗口外了。
            if(!queue.isEmpty() && queue.peekFirst()==i-k)
            {
                queue.pollFirst();
            }
            //保持栈内元素单调递减
            while(!queue.isEmpty() && queue.peekLast()<nums[i])
            {
                queue.pollLast();
            }
            queue.offerLast(nums[i]);
        }
        result[j] = queue.peekFirst();
        return result;
    }
}
