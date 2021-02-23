package modao.skip.list;

import java.util.Random;

public class SkipList3 {

    public class Node
    {
        private int key;
        private int data;
        private Node[] rights;
        public Node(int key, int data)
        {
            this.key = key;
            this.data = data;
            this.rights = new Node[MAX_HIGH];
        }
    }

    private Node head;
    private final int MAX_HIGH = 16;
    private int high;
    private Random random = new Random();

    public SkipList3()
    {
        high = 0;
        head = new Node(Integer.MIN_VALUE,0);
    }

    public Node find(int key)
    {
        Node curr = head;
        for(int i=MAX_HIGH-1;i>=0;--i)
        {
            while(curr.rights[i]!=null && curr.rights[i].key<key)
            {
                curr = curr.rights[i];
            }
            if(curr.rights[i]!=null && curr.rights[i].key==key)
            {
                return curr.rights[i];
            }
        }
        return null;
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

    public void add(int key)
    {
        Node curr = head;
        for(int i=MAX_HIGH-1;i>=0;--i)
        {
            while(curr.rights[i]!=null && curr.rights[i].key<key)
            {
                curr = curr.rights[i];
            }
        }
        if(curr.rights[0]!=null && curr.rights[0].key == key)
        {//已存在
            curr.rights[0].data = 0;
        }

        int high =calcHigh();
        Node newNode = new Node(key,high);
        for(int i=0;i<=high;++i)
        {
            newNode.rights[i] = curr.rights[i];
            curr.rights[i] = newNode;
        }
    }

    public void remove(int key)
    {
        Node curr = head;
        for(int i=MAX_HIGH-1;i>=0;--i)
        {
            while(curr.rights[i]!=null && curr.rights[i].key<key)
            {
                curr = curr.rights[i];
            }
            if(curr.rights[i]!=null && curr.rights[i].key==key)
            {
                curr.rights[i] = curr.rights[i].rights[i];
            }
        }
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        Node curr = head;
        for(int i=MAX_HIGH-1;i>=0;--i)
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
