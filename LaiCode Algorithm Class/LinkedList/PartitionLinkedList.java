import utils.ListNode;
import utils.Printer;
import utils.TestListNode;

public class PartitionLinkedList {

    public static void main(String[] args) {

        TestListNode  testListNode = new TestListNode();
        ListNode head = testListNode.createListNode();
        ListNode res = method(head, 3);
        Printer printer = new Printer();
        printer.print(res);
    }


    public static ListNode method(ListNode head ,int target){
        if(head == null || head.next == null){
            return head;
        }


        ListNode dummyhead1 = new ListNode(0);
        ListNode dummyhead2 = new ListNode(1);
        ListNode cur1 = dummyhead1;
        ListNode cur2 = dummyhead2;
        ListNode cur3 = head;

        while(cur3 != null){
            if(cur3.value < target){
                cur1.next = cur3;
                cur1 = cur1.next;
            }else{
                cur2.next = cur3;
                cur2 = cur2.next;
            }
            cur3 = cur3.next;
        }
        cur2.next = null;
        cur1.next = dummyhead2.next;
        return dummyhead1.next;



    }
}
