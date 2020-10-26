import utils.ListNode;

public class Add_Two_Numbers {
    //2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyhead = new ListNode(0);
        ListNode cur = dummyhead;
        int tag = 0;
        int val1 ;
        int val2 ;
        while(l1 != null || l2 != null){
            if(l1 != null){
                val1 = l1.value;
            }else{
                val1 = 0;
            }
            if(l2 != null){
                val2 = l2.value;
            }else{
                val2 = 0;
            }
            int tempsum = val1 + val2 + tag;
            if(tempsum >= 10){
                tag = 1;
                tempsum = tempsum % 10;
            }else{
                tag = 0;
            }
            cur.next = new ListNode(tempsum);
            cur = cur.next;
            if(l1 != null){     //注意，这里需要判断是否为null，再做next操作
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(tag != 0){
            cur.next = new ListNode(1);
        }
        return dummyhead.next;
    }
}
