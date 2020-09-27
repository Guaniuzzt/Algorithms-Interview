package utils;

public class TestListNode {



    public ListNode createListNode(){

        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i=1; i<10; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return head;
    }
}
