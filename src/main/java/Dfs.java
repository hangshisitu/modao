import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Dfs {

    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        Stack<Integer> path = new Stack<Integer>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,0,path,used,res);

        return res;
    }
    public void dfs(int []nums,int depth,Stack<Integer> path,boolean[] used,List<List<Integer>> res)
    {
        if(depth == nums.length)
        {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i=0;i<nums.length;++i)
        {
            if(used[i] || i>0 && nums[i-1]==nums[i] && !used[i-1])
            {
                continue;
            }

            used[i]=true;
            path.push(nums[i]);
            dfs(nums,depth+1,path,used,res);
            path.pop();
            used[i]=false;

        }
    }

}
