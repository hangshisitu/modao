import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LRUCache2 {
        public class ListNode {
            public int key;
            public int value;
            public ListNode next;
            public ListNode pre;
            public ListNode(int key,int value)
            {
                this.key = key;
                this.value = value;
                next = null;
                pre = null;
            }
        };

        public class DLinkList {
            ListNode head;
            ListNode tail;
            DLinkList()
            {
                head = new ListNode(0,0);
                tail = new ListNode(0,0);
                head.next = tail;
                tail.pre = head;
            }
            public void remove(ListNode node)
            {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            public void addFirst(ListNode node)
            {
                head.next.pre = node;
                node.next = head.next;
                node.pre = head;
                head.next = node;
            }
            public ListNode getLast()
            {
                return tail.pre;
            }
            public void removeLast()
            {
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
            }
        };

        Map<Integer, ListNode> hashMap = new HashMap<Integer,ListNode>();
        DLinkList dlinkList=new DLinkList();
        int captity = 0;
        /**
         * lru design
         * @param operators int整型二维数组 the ops
         * @param k int整型 the k
         * @return int整型一维数组
         */
        public int[] LRU (int[][] operators, int k) {
            // write code here
            captity = k;
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for(int i=0; i<operators.length;++i)
            {
                int opt =  operators[i][0];
                if(opt ==1)
                {
                    set(operators[i][1],operators[i][2]);
                }else
                {
                    arrayList.add(get(operators[i][1]));
                }
            }
            int[] res = new int[arrayList.size()];
            for(int i=0;i<arrayList.size();++i)
            {
                res[i] = arrayList.get(i);
            }
            return res;
        }

        public void set(int key,int value)
        {
            HashSet<Integer> hashSet = new HashSet<Integer>();

            if(hashMap.containsKey(key))
            {
                dlinkList.remove(hashMap.get(key));
                dlinkList.addFirst(hashMap.get(key));
            }else{
                if(hashMap.size()>=captity)
                {
                    hashMap.remove(dlinkList.getLast().key);
                    dlinkList.removeLast();
                }
                ListNode temp = new ListNode(key,value);
                dlinkList.addFirst(temp);
                hashMap.put(key,temp);
            }
        }

        public int get(int key)
        {
            if(hashMap.containsKey(key))
            {
                dlinkList.remove(hashMap.get(key));
                dlinkList.addFirst(hashMap.get(key));
                return hashMap.get(key).value;
            }else
            {
                return -1;
            }
        }
}
