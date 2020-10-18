import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KSmallestInUnsortedArray {

    /*

    PriorityQueue时间复杂度
    堆总是一个完全二叉树
    insert: log(k)
    update: log(k)
    get: 1
    pop: log(k)
    heapify: 使一个unsorted array变成一个堆 O(n)
    1 * 2^(logN -1) + 2^1 * 2 ^(logn - 2) + 2 ^2 * 2 ^(logn -3) + ... +

    两种方法的优劣性比较(Quick Select & Heap)
    在面试中，另一个常常问的问题就是这两种方法有何优劣。看起来分治法的快速选择算法的时间、空间复杂度都优于使用堆的方法，但是要注意到快速选择算法的几点局限性：

    第一，算法需要修改原数组，如果原数组不能修改的话，还需要拷贝一份数组，空间复杂度就上去了。

    第二，算法需要保存所有的数据。如果把数据看成输入流的话，使用堆的方法是来一个处理一个，不需要保存数据，只需要保存 k 个元素的最大堆。而快速选择的方法需要先保存下来所有的数据，再运行算法。当数据量非常大的时候，甚至内存都放不下的时候，就麻烦了。所以当数据量大的时候还是用基于堆的方法比较好。

    作者：nettee
    链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/tu-jie-top-k-wen-ti-de-liang-chong-jie-fa-you-lie-/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     */



    //Method1: Using PriorityQueue
    public int[] method(int[] array, int k){

        if(array == null || array.length ==0)
            return new int[0];
        if(k > array.length)
            k = array.length;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 == o2)
                    return 0;
                return o1 > o2 ? -1 : 1;
            }
        });
        for(int i=0; i<array.length; i++){
            if(i < k){
                priorityQueue.offer(array[i]);
            }else{
                if(array[i] < priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.offer(array[i]);
                }
            }
        }
        int[] res = new int[k];
        for(int i=k-1; i>=0; i--){
            res[i] = priorityQueue.poll();
        }
        return res;
    }
}
