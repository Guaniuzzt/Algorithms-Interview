import utils.ListNode;
import utils.TestListNode;

public class CheckIfLinkedListHasACycle {



    public static boolean method(ListNode head){

        if(head==null || head.next==null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
            if(fast.next != null){   //remember here fast.next maybe null
                slow = slow.next;
                fast = fast.next.next;
            }else{
                return false;
            }
        }
        return false;
    }
}
