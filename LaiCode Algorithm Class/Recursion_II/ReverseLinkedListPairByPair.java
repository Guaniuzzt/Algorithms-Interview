import utils.ListNode;
import utils.Printer;

public class ReverseLinkedListPairByPair {


    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        ListNode cur = test;
        for(int i=2; i<7; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        Printer printer = new Printer();
        //ListNode oneByOne = reverseOneByOne(test);
        //printer.print(oneByOne);
        ListNode twoByTwo = reversePairByPair(test);
        printer.print(twoByTwo);

    }

    /*

    reverseOneByOne 和 PairByPair不同的地方在于：
    1. 返回的节点位置不一样， 1by1返回是的最后一个节点， 2by2返回的时第二个节点
    2. subproblem不一样，1by1的是该节点后面所有部分，并且返回的是上一个节点的next指针， 指向本node，
       2by2的是两个节点后的部分， 并且返回的是整理好顺序的node，需要将本node指向这个返回结果

     */


    public static ListNode reverseOneByOne(ListNode head){
        /*
        1 - 2 - 3 - 4 - 5 - 6 - null
        6 - 5 - 4 - 3 - 2 - 1 - null
         */
        if(head == null || head.next ==null)
            return head;

        ListNode newhead = reverseOneByOne(head.next);
        head.next.next = head;
        head.next = null;

        return newhead;
    }

    public static ListNode reversePairByPair(ListNode head){
        /*
        1 - 2 - 3 - 4 - 5 - 6 - null
        2 - 1 - 4 - 3 - 6 - 5 - null
         */

        if(head == null || head.next == null){
            return head;
        }

        ListNode next = head.next;
        head.next = reversePairByPair(head.next.next);
        next.next = head;

        return next;
    }
}
