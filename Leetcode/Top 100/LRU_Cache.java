import java.util.HashMap;
import java.util.Map;

public class LRU_Cache {

    //146
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        /**
         * Remove an existing node from the linked list.
         */

        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node){
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail(){
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private Map<Integer, DLinkedNode> map = new HashMap<>();

    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRU_Cache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode res = map.get(key);
        if(res == null)
            return -1;
        moveToHead(res);
        return res.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if(node == null){
            DLinkedNode newhead = new DLinkedNode();
            newhead.key = key;
            newhead.value = value;
            map.put(key, newhead);
            addNode(newhead);
            size++;
            if(size > capacity){
                DLinkedNode last = popTail();
                map.remove(last.key);
                size--;

            }
        }else{
            node.value = value;
            moveToHead(node);
        }

    }
}
