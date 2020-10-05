import utils.ListNode;
import utils.Printer;

/*
Time: O(nlogn)
Recursion Tree logn levels, every level dealing n elements, both dive and merge same
Space: O(logn) Recursion tree height
 */

public class MergeSortLinkedList {

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode cur1 = head1;
        for(int i=5; i>1; i--){
            cur1.next = new ListNode(i);
            cur1 = cur1.next;
        }
        Printer printer = new Printer();
        printer.print(head1);
        System.out.println();
        ListNode res = method(head1);
        printer.print(res);
    }


    public static ListNode method(ListNode head){

        if(head == null || head.next == null)
            return head;

        ListNode nodebeforemiddle  = findmiddle(head);
        ListNode secondhead = nodebeforemiddle.next;
        nodebeforemiddle.next = null;
        ListNode left = method(head);
        ListNode right = method(secondhead);
        ListNode res = MergeTwoSortedLinkedList.method(left, right);

        return res;
    }





    public static ListNode findmiddle(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }





}
