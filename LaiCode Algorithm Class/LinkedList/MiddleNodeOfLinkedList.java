import utils.ListNode;
import utils.Printer;
import utils.TestListNode;

public class MiddleNodeOfLinkedList {

    public static void main(String[] args) {
        TestListNode testListNode = new TestListNode();
        ListNode head = testListNode.createListNode();

        ListNode res = method(head);
        Printer printer = new Printer();
        printer.print(res);
    }


    public static ListNode method(ListNode head){
        if(head == null || head.next == null ){
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
}
