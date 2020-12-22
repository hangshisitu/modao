package modao.tree;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
    public TreeNode(int val)
    {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left,TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void  dfsBefore(TreeNode root, List<Integer> result)
    {
        if(root==null)
        {
            return;
        }
        result.add(root.val);
        dfsBefore(root.left,result);
        dfsBefore(root.right,result);
    }

    public void  dfsBeforeEx(TreeNode root,List<Integer> result)
    {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode curr = stack.pop();
            if(curr==null)
            {
                return;
            }
            result.add(curr.val);
            dfsBeforeEx(root.left,result);
            dfsBeforeEx(root.right,result);
        }
    }



    public void  dfsMid(TreeNode root,List<Integer> result)
    {
        if(root==null)
        {
            return;
        }
        dfsMid(root.left,result);
        result.add(root.val);
        dfsMid(root.right,result);
    }

    public void  dfsMidEx(TreeNode root,List<Integer> result)
    {
        Deque<Pair<Boolean,TreeNode>> stack = new LinkedList<>();
        stack.push(new Pair<>(false,root));
        while(!stack.isEmpty())
        {
            Pair<Boolean,TreeNode> temp = stack.pop();
            if(temp.getValue()==null)
            {
                return;
            }
            if(temp.getKey()==false)
            {
                stack.push(new Pair<>(false,root.right));
                stack.push(new Pair<>(true,temp.getValue()));
                stack.push(new Pair<>(false,root.left));
            }else
            {
                result.add(temp.getValue().val);
            }
        }
    }



    public void dfsAfter(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        dfsAfter(root.left);
        dfsAfter(root.right);
        System.out.println(root.val);
    }

}
