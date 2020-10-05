import utils.ListNode;
import utils.Printer;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(1);
        Printer printer = new Printer();
        printer.print(method(node1, node2));

    }


    public static ListNode method(ListNode node1, ListNode node2){

        ListNode dhead = new ListNode(0);
        ListNode cur = dhead;
        ListNode cur1 = node1;
        ListNode cur2 = node2;
        int tag = 0;

        while(cur1 != null || cur2 != null){

            int temp1 = (cur1 != null)? cur1.value : 0;
            int temp2 = (cur2 != null)? cur2.value : 0;

            int temp = (temp1 + temp2 + tag) % 10;
            tag = (temp1 + temp2 + tag) / 10;

            cur.next = new ListNode(temp);
            cur = cur.next;

            if(cur1 != null){
                cur1 = cur.next;
            }

            if(cur2 != null){
                cur2 = cur2.next;
            }
        }

        if(tag == 1){
            cur.next = new ListNode(1);
        }

        return dhead.next;

    }

}
