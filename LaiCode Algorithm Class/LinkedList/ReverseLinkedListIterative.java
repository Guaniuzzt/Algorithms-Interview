import utils.ListNode;
import utils.TestListNode;

public class ReverseLinkedListIterative {

    public static void main(String[] args) {

        TestListNode test = new TestListNode();
        ListNode head = test.createListNode();

        ListNode res = method(head);
        while(res != null){
            System.out.println(res.value);
            res = res.next;
        }
    }



    public static ListNode method(ListNode head){

        if(head == null || head.next == null ){
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;

    }
}
