import utils.ListNode;

public class Reverse_Linked_List {

    //206
    //iterative
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = null;

        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //recursion
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newhead;
    }
}
