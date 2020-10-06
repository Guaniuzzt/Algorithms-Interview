import utils.ListNode;

public class CheckIfIsPalindrome {



    public static boolean method(ListNode head){

        if(head == null || head.next == null)
            return true;

        ListNode middle = MiddleNodeOfLinkedList.method(head);
        ListNode sechead = middle.next;
        middle.next = null;
        sechead = ReverseLinkedListIterative.method(sechead);

        while(sechead != null){

            if(sechead.value != head.value){
                return false;
            }
            sechead = sechead.next;
            head = head.next;
        }
        return true;


    }
}
