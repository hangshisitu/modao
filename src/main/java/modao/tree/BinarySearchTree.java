package modao.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    public static class TreeNode {
        public int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int v)
        {
            this.val = v;
            this.left = null;
            this.right = null;
        }

        public TreeNode(int v,TreeNode l, TreeNode r)
        {
            this.val = v;
            this.left = l;
            this.right = r;
        }

        @Override
        public String toString()
        {
            return String.format("%d",val);
        }
    }

    public TreeNode root;

    public List<TreeNode> find(int v)
    {
        List<TreeNode> result = new ArrayList<>();
        TreeNode temp = root;
        while(temp!=null)
        {
            if(temp.val>v)
            {
                temp = temp.left;
            }else if(temp.val<v)
            {
                temp = temp.right;
            }else
            {
                result.add(temp);
                temp = temp.right;
            }
        }
        return result;
    }

    public void insert(int v)
    {
        if(root==null)
        {
            root = new TreeNode(v);
            return;
        }

        TreeNode temp = root;
        while(temp!=null)
        {
            if(temp.val>v)
            {
                if(temp.left==null)
                {
                    temp.left = new TreeNode(v);
                    return;
                }
                temp = temp.left;
            }if(temp.val<=v )
            {
                if(temp.right==null)
                {
                    temp.right = new TreeNode(v);
                    return;
                }
                temp = temp.right;
            }
        }
    }

    public void remove(int v)
    {
        while(true)
        {
            TreeNode pre = null;
            TreeNode curr = root;

            while(curr!=null && curr.val!=v)
            {

                pre =curr;
                if(curr.val>v)
                {
                    curr = curr.left;
                }else if(curr.val<v)
                {
                    curr = curr.right;
                }
            }
            if(curr ==null)
            {//not found
                return;
            }

            if(curr.right!=null && curr.left!=null)
            {
                TreeNode pre2 = curr;
                TreeNode curr2 = curr.right;

                while(curr2.left!=null)
                {
                    pre2 = curr2;
                    curr2 = curr2.left;
                }
                curr.val = curr2.val;

                pre = pre2;
                curr = curr2;
            }

            TreeNode child = null;
            if(curr.left==null)
            {
                child = curr.right;
            }else if(curr.right==null)
            {
                child = curr.left;
            }

            if(pre==null)
            {
                root = child;
            }
            else if(pre.left==curr)
            {
                pre.left = child;
            }else
            {
                pre.right = child;
            }
        }
    }

    public void  dfsMid(TreeNode head,List<Integer> result)
    {
        if(head==null)
        {
            return;
        }
        dfsMid(head.left,result);
        result.add(head.val);
        dfsMid(head.right,result);
    }
}
