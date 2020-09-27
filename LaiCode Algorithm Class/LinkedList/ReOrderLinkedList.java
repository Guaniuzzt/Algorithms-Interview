import utils.ListNode;
import utils.Printer;
import utils.TestListNode;

public class ReOrderLinkedList {

    public static void main(String[] args) {

        TestListNode testListNode = new TestListNode();
        ListNode head = testListNode.createListNode();

        ListNode res = reorder(head);
        Printer printer = new Printer();
        printer.print(res);
    }


    public static ListNode reorder(ListNode head) {
        // Write your solution here
        if(head == null || head.next == null){
            return head;
        }

        ListNode middle = findmiddle(head);
        ListNode secondhead = middle.next;
        middle.next = null;

        secondhead = reserve(secondhead);

        ListNode dhead = new ListNode(0);
        ListNode cur = dhead;

        while(secondhead != null){
            cur.next = head;
            head = head.next;
            cur = cur.next;
            cur.next = secondhead;
            secondhead = secondhead.next;
            cur = cur.next;
        }

        if(head != null){
            cur.next = head;
        }
        return dhead.next;




    }

    private static ListNode findmiddle(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode reserve(ListNode head){
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
}
