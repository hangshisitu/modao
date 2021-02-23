package modao.skip.list;

import java.util.Random;

//跳跃表
public class SkipList2 {
    class Node
    {
        private int key;
        private int data;
        private Node[] rights;
        private int topIndex;

        public Node(int key, int data, int high)
        {
            this.key = key;
            this.data = data;
            this.rights = new Node[MAX_HIGH];
            this.topIndex = high;
        }
    }

    private Node head;
    private final int MAX_HIGH = 16;
    private int high;
    private Random random = new Random();
    public SkipList2()
    {
        high = 0;
        head = new Node(Integer.MIN_VALUE,0,high);
    }

    public Node find(int key)
    {
        Node curr = head;

        for(int index = curr.topIndex; index>=0;)
        {
            if(curr.rights[index]!=null && curr.rights[index].key==key)
            {
                return curr.rights[index];
            }else if(curr.rights[index]!=null && curr.rights[index].key<key)
            {
                curr = curr.rights[index];
                index = curr.topIndex;
            }
            else
            {
                --index;
            }
        }
        return null;
    }

    public void add(int key)
    {
        Node temp = find(key);
        if(temp!=null)
        {
            temp.data=0;
            return;
        }
        int high =calcHigh();
        Node newNode = new Node(key,0,high);
        this.high = Math.max(high,this.high);
        head.topIndex = this.high;
        Node curr = head;
        for(int index = curr.topIndex; index>=0;)
        {
            if(curr.rights[index]!=null && curr.rights[index].key<key)
            {
                curr = curr.rights[index];
                index = curr.topIndex;
            }else if(curr.rights[index]!=null && curr.rights[index].key>key)
            {
                newNode.rights[index] = curr.rights[index];
                curr.rights[index] = newNode;
                --index;
            }
            else if(curr.rights[index]==null )
            {
                if(newNode.topIndex>=index)
                {
                    newNode.rights[index] = curr.rights[index];
                    curr.rights[index] = newNode;
                }
                --index;
            }
        }
    }

    public void remove(int key)
    {
        Node curr = head;

        for(int index = curr.topIndex; index>=0;)
        {
            if(curr.rights[index]!=null && curr.rights[index].key==key)
            {
                curr.rights[index] = curr.rights[index].rights[index];
                --index;
            }else if(curr.rights[index]!=null && curr.rights[index].key<key)
            {
                curr = curr.rights[index];
                index = curr.topIndex;
            }
            else
            {
                --index;
            }
        }
    }

    public int calcHigh()
    {
        int high = 0;
        while(high<MAX_HIGH)
        {
            if(random.nextInt(10)%2==1)
            {
                break;
            }
            ++high;
        }
        return high;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        Node curr = head;
        for(int i=high;i>=0;--i)
        {
            while(curr!=null)
            {
                stringBuilder.append(curr.key).append("-->");
                curr = curr.rights[i];
            }
            stringBuilder.append("null\n");
            curr = head;
        }
        return stringBuilder.toString();
    }
}
