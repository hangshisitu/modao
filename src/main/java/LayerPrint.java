import java.util.*;

public class LayerPrint {

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode temp = null;
        do{
            temp = queue.poll();
            if(temp!=null)
            {
                result.add(temp.val);
                if(temp.left!=null)
                {
                    queue.add(temp.left);
                }
                if(temp.right!=null)
                {
                    queue.add(temp.right);
                }
            }
        }while(temp!=null);
        return result;
    }

    public void dfs(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> depths = new Stack<Integer>();
        Map<Integer,Integer> depth2Val = new HashMap<Integer, Integer>();
        int mathDepth = -1;
        stack.push(root);
        depths.push(0);
        while(!stack.isEmpty())
        {
            TreeNode temp = stack.peek();
            Integer depth = depths.peek();
            mathDepth = Math.max(mathDepth,depth);
            if(temp==null)
            {
                continue;
            }
            if(!depth2Val.containsKey(depth))
            {
                depth2Val.put(depth,temp.val);
            }
            System.out.println(temp.val);
            stack.push(temp.left);
            stack.push(temp.right);
        }
        for(int i=0;i<mathDepth;++i)
        {
            depth2Val.get(i);
        }
    }
}
