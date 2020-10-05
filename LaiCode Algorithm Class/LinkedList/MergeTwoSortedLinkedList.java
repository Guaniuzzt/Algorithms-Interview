import utils.ListNode;
import utils.Printer;

import java.awt.print.PrinterGraphics;

public class MergeTwoSortedLinkedList {


    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode cur1 = l1;
        cur1.next = new ListNode(3);

        ListNode l2 = new ListNode(2);
        ListNode cur2 = l2;
        cur2.next = new ListNode(4);

        ListNode res = method(l1, l2);
        Printer printer = new Printer();
        printer.print(res);
    }



    public static ListNode method(ListNode l1, ListNode l2){

        ListNode dummyhead = new ListNode(0);
        if(l1 == null && l2 == null)
            return null;

        ListNode cur = dummyhead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while(cur1 != null && cur2 != null){
            if(cur1.value <= cur2.value){
                cur.next = cur1;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        if(cur1 != null){
            cur.next = cur1;
        }else{
            cur.next = cur2;
        }

        return dummyhead.next;




    }
}
