package modao.skip.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * 跳表
 * @author qiaojun.xiao
 */
public class SkipList<V> {

    public static class SkipListNode<V>
    {
        private int key;
        private V data;

        private SkipListNode right;
        private SkipListNode down;

        public SkipListNode(int key, V data)
        {
            this.key = key;
            this.data = data;
            right = null;
            down = null;
        }
    }

    private int hight;
    private SkipListNode<V> head;

    private final int MAX_HIGHT=16;

    public SkipList()
    {
        hight = 1;
        head = new SkipListNode<V>(Integer.MIN_VALUE,null);
    }

    public V find(int key)
    {
        SkipListNode<V> curr = head;
        while(curr!=null)
        {
            if(curr.key == key)
            {
                return curr.data;
            }
            else if(curr.right==null || curr.right.key>key)
            {
                curr = curr.down;
            }else
            {
                curr = curr.right;
            }
        }
        return null;
    }

    public List<V> findList(int key)
    {
        List<V> result = new LinkedList<>();
        SkipListNode<V> curr = head;
        while(curr!=null)
        {
            if(curr.key == key)
            {
                result.add(curr.data);
            }
            else if(curr.right==null || curr.right.key>key)
            {
                curr = curr.down;
            }else
            {
                curr = curr.right;
            }
        }
        return result;
    }

    //左闭右开区间
    public List<V> findListByRange(int lowKey, int highKey)
    {
        List<V> result = new LinkedList<>();
        SkipListNode<V> curr = head;
        while(curr!=null)
        {
            if(curr.key >= lowKey)
            {
                while(curr.down!=null)
                {
                    curr = curr.down;
                }
                break;
            }
            else
            if(curr.right==null || curr.right.key>=lowKey)
            {
                if(curr.down!=null)
                {
                    curr = curr.down;
                }else
                {
                    break;
                }

            }else
            {
                curr = curr.right;
            }
        }

        while(curr!=null && curr.key<lowKey)
        {
            curr = curr.right;
        }

        while( curr !=null && curr.key<highKey)
        {

            result.add(curr.data);
            curr = curr.right;
        }

        return result;
    }


    public void remove(int key)
    {
        SkipListNode<V> curr = head;
        while(curr!=null)
        {
            if(curr.right==null|| curr.right.key>key)
            {
                curr = curr.down;
            }else if(curr.right.key==key)
            {
                //curr为待删除节点的左侧节点
                curr.right = curr.right.right;
                curr = curr.down;
            }
            else
            {
                curr = curr.right;
            }
        }
    }

    public void remove(int key,V data)
    {
        SkipListNode<V> curr = head;
        while(curr!=null)
        {
            if(curr.right==null|| curr.right.key>key)
            {
                curr = curr.down;
            }else if(curr.right.key==key)
            {
                //curr为待删除节点的左侧节点
                if(curr.right.data.equals(data))
                {
                    curr.right = curr.right.right;
                    curr = curr.down;
                }else
                {
                    curr = curr.right;
                }
            }
            else
            {
                curr = curr.right;
            }
        }
    }

    public void add(int key,V data)
    {
//        V temp = find(key);
//        if(temp!=null)
//        {
//            temp = data;
//            return;
//        }

        SkipListNode curr = head;
        Stack<SkipListNode> stack = new Stack<SkipListNode>();
        while(curr!=null)
        {
            if(curr.right==null|| curr.right.key>key)
            {
                //curr为待插入节点的左侧节点
                stack.push(curr);
                curr = curr.down;
            }
            else
            {
                curr = curr.right;
            }
        }

        SkipListNode down = null;
        while(!stack.isEmpty())
        {
            curr = stack.pop();
            SkipListNode newNode = new SkipListNode(key,data);
            newNode.right = curr.right;
            newNode.down = down;
            curr.right = newNode;
            down = newNode;

            //是否需要加上层索引
            if(!isUpIndex())
            {
                break;
            }
        }

        if(stack.isEmpty() && hight<MAX_HIGHT)
        {
            //是否需要新加一层索引
            if(isUpIndex())
            {
                hight++;
                SkipListNode newHead = new SkipListNode(Integer.MIN_VALUE,null);
                newHead.right = new SkipListNode(key,data);
                newHead.right.down = down;
                newHead.down = head;
                head = newHead;
            }
        }
    }

    public boolean isUpIndex()
    {
        Random random = new Random();
        int temp = random.nextInt(10);
        if(temp%2==0)
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        SkipListNode curr = head;
        SkipListNode down = head.down;
        for(int i=0;i<hight;++i)
        {
            while(curr!=null)
            {
                stringBuilder.append(curr.key).append("-->");
                curr = curr.right;
            }
            stringBuilder.append("null\n");
            curr = down;
            if(down!=null)
            {
                down = down.down;
            }
        }
        return stringBuilder.toString();
    }
}
