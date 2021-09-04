import utils.ListNode;

public class Merge_Two_Sorted_Lists {

    //21
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        ListNode dummyhead = new ListNode(0);
        ListNode cur = dummyhead;
        ListNode node1 = l1;
        ListNode node2 = l2;

        while(l1 != null && l2 != null){

            if(l1.value <= l2.value ){
                cur.next = new ListNode(l1.value);
                l1 = l1.next;
            }else{
                cur.next = new ListNode(l2.value);
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if(l1 != null){
            cur.next = l1;
        }
        if(l2 != null){
            cur.next = l2;
        }

        return dummyhead.next;
    }
}
