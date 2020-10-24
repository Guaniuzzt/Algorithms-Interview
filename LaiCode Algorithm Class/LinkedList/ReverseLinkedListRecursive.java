import utils.ListNode;
import utils.Printer;
import utils.TestListNode;

public class ReverseLinkedListRecursive {

    public static void main(String[] args) {

        TestListNode testListNode = new TestListNode();
        ListNode head = testListNode.createListNode();

        ListNode res = method(head);

        Printer printer = new Printer();
        printer.print(res);
    }


    // 1 - 2 - null
    public static ListNode method(ListNode head){//head :1
        if(head == null || head.next ==null)
            return head;

        ListNode newhead = method(head.next);  //head.next:2
        head.next.next = head; //head.next(2).next = head(1)
        head.next = null;//head(1).next = null

        return newhead;
    }

}
