//链表逆序
public class ReverseKGroup {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
        public ListNode reverseKGroup(ListNode head, int k) {
            // int n = getLength(head);
            // int start=1;
            // int end=k;
            // while(end<=n)
            // {
            //     head = reverseM2N(head,start,end);
            //     start= start+k;
            //     end=end+k;
            // }
            // return head;
            String temp;
            Math.pow(2,31);


            int n = getLength(head);
            ListNode sentulNode = new ListNode(0,head);
            ListNode preNode = sentulNode;
            ListNode startNode = head;
            int start=1;
//            while(start+k-1<=n)
//            {
//                // head = reverseM2N(head,start,k);
//                // start= start+k;
//                ListNode[] temp = reverse3(preNode,startNode,k);
//                start= start+k;
//                preNode =temp[0];
//                startNode = temp[1];
//            }
            return head;
        }
        public int getLength(ListNode head)
        {
            ListNode temp = head;
            int i =0;
            for(;temp!=null;++i)
            {
                temp = temp.next;
            }

            return i;
        }

        // public ListNode reverseM2N(ListNode head, int m,int n)
        // {
        //     ListNode sentulNode = new ListNode(0,head);
        //     ListNode pre = sentulNode;
        //     ListNode curr = head;

        //     for(int i=0; i<m-1; ++i)
        //     {
        //         pre = curr;
        //         curr = curr.next;
        //     }

        //     ListNode tempHead = null;
        //     ListNode temptail = curr;
        //     for(int j=0; j<=n-m; ++j)
        //     {
        //         ListNode temp = curr.next;
        //         curr.next = tempHead;
        //         tempHead = curr;
        //         curr = temp;
        //     }
        //     pre.next = tempHead;
        //     temptail.next = curr;

        //     return sentulNode.next;
        // }

        // public ListNode reverseM2N(ListNode head, int m,int k)
        // {
        //     ListNode sentulNode = new ListNode(0,head);
        //     ListNode pre = sentulNode;
        //     ListNode curr = head;

        //     for(int i=0; i<m-1; ++i)
        //     {
        //         pre = curr;
        //         curr = curr.next;
        //     }

        //     ListNode tempHead = null;
        //     ListNode temptail = curr;
        //     int n = m+k-1;
        //     for(int j=0; j<=n-m; ++j)
        //     {
        //         ListNode temp = curr.next;
        //         curr.next = tempHead;
        //         tempHead = curr;
        //         curr = temp;
        //     }
        //     pre.next = tempHead;
        //     temptail.next = curr;

        //     return sentulNode.next;
        // }

//        public ListNode[] reverse3(ListNode preNode,ListNode starNode,int k)
//        {
//            ListNode pre = preNode;
//            ListNode curr = starNode;
//
//            ListNode tempHead = null;
//            ListNode temptail = curr;
//            int n = m+k-1;
//            for(int j=0; j<=n-m; ++j)
//            {
//                ListNode temp = curr.next;
//                curr.next = tempHead;
//                tempHead = curr;
//                curr = temp;
//            }
//            pre.next = tempHead;
//            temptail.next = curr;
//            ListNode[] res = new ListNode[2];
//            res[0] = temptail;
//            res[1] = curr;
//            return res;
//        }

}
