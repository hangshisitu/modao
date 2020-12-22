package maodao.link;

import javax.xml.soap.Node;
import java.util.LinkedList;

public class IsCycString {

    public class NodeList{
        char v;
        NodeList next;

        public NodeList()
        {
            v=0;
            this.next =null;
        }
        public NodeList(char c,NodeList next)
        {
            v=c;
            this.next =next;
        }
    }

    public NodeList buildNodes(String str)
    {
        NodeList next = null;
        for(int i=str.length()-1;i>=0;--i)
        {
            next = new NodeList(str.charAt(i),next);
        }
        return next;
    }
    public boolean isCycString(NodeList head)
    {
        NodeList slow=head;
        NodeList fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null)
        {
            slow = slow.next;
        }
        slow= reverse(slow);
        if(slow==null)
        {
            return false;
        }

        while(slow!=null)
        {
            if(slow.v!=head.v)
            {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    public NodeList reverse(NodeList head)
    {
        NodeList newHead = null;

        NodeList curr = head;

        while(curr!=null)
        {
            NodeList temp = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = temp;
        }
        return newHead;
    }
}
