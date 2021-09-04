import utils.ListNode;

public class Palindrome_Linked_List {


    //243
    public boolean isPalindrome(ListNode head) {


        if(head == null || head.next == null)
            return true;

        ListNode middle = findmiddle(head);
        ListNode sechead = middle.next;
        middle.next = null;
        sechead = reverse(sechead);

        while(sechead != null){

            if(sechead.value != head.value){
                return false;
            }
            sechead = sechead.next;
            head = head.next;
        }
        return true;

    }

    public static ListNode findmiddle(ListNode head){
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
    public static ListNode reverse(ListNode head){

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
