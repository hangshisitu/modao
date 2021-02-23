package modao.tree;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
    public TreeNode(int val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
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
        Deque<Pair<Boolean,TreeNode>> stack = new LinkedList<>();
        stack.push(new Pair<>(false,root));
        while(!stack.isEmpty())
        {
            Pair<Boolean,TreeNode> temp = stack.pop();
            if(temp.getValue()==null)
            {
                continue;
            }
            if(temp.getKey()==false)
            {
                stack.push(new Pair<>(false,temp.getValue().right));
                stack.push(new Pair<>(false,temp.getValue().left));
                stack.push(new Pair<>(true,temp.getValue()));
            }else
            {
                result.add(temp.getValue().val);
            }
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
                continue;
            }
            if(temp.getKey()==false)
            {
                stack.push(new Pair<>(false,temp.getValue().right));
                stack.push(new Pair<>(true,temp.getValue()));
                stack.push(new Pair<>(false,temp.getValue().left));
            }else
            {
                result.add(temp.getValue().val);
            }
        }
    }



    public void dfsAfter(TreeNode root,List<Integer> result)
    {
        if(root==null)
        {
            return;
        }
        dfsAfter(root.left,result);
        dfsAfter(root.right,result);
        result.add(root.val);
    }

    public void  dfsAfterEx(TreeNode root,List<Integer> result)
    {
        Deque<Pair<Boolean,TreeNode>> stack = new LinkedList<>();
        stack.push(new Pair<>(false,root));
        while(!stack.isEmpty())
        {
            Pair<Boolean,TreeNode> temp = stack.pop();
            if(temp.getValue()==null)
            {
                continue;
            }
            if(temp.getKey()==false)
            {
                stack.push(new Pair<>(true,temp.getValue()));
                stack.push(new Pair<>(false,temp.getValue().right));
                stack.push(new Pair<>(false,temp.getValue().left));
            }else
            {
                result.add(temp.getValue().val);
            }
        }
    }


    public void bfs(TreeNode root,List<Integer> result)
    {
        if(root==null)
        {
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty())
        {
            TreeNode temp = deque.poll();
            if(temp == null)
            {
                continue;
            }
            result.add(temp.val);
            deque.add(temp.left);
            deque.add(temp.right);
        }
    }

    public void bfsEx(TreeNode root,List<Integer> result)
    {
        if(root==null)
        {
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty())
        {
            TreeNode temp = deque.poll();
            if(temp == null)
            {
                continue;
            }
            result.add(temp.val);
            deque.add(temp.right);
            deque.add(temp.left);
        }
    }

    public int height(TreeNode root)
    {
        int height = 0;
        if(root!=null)
        {

            int leftHeight = 0;
            if(root.left!=null)
            {
                leftHeight = height(root.left)+1;
            }
            int rightHeight = 0;
            if(root.right!=null)
            {
                rightHeight = height(root.right)+1;
            }
            height = Math.max(leftHeight,rightHeight);
        }
        return height;
    }
}
