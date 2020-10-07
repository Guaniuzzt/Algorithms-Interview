import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderTraversalIterative {

    List<Integer> list = new ArrayList<>();
    public void method(TreeNode root){
        if(root == null)
            return ;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur != null || deque.size() != 0){
            if(cur != null){
                deque.offerLast(cur);
                cur = cur.left;
            }else{
                cur = deque.pollLast();
                list.add(cur.key);
                cur = cur.right;
            }
        }
    }
}
