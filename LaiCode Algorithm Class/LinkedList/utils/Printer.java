package utils;

public class Printer {


    public void print(ListNode node){

        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}
