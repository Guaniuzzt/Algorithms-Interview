import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreOrderTraversalIterative {

    List<Integer> res = new ArrayList<>();
    public void method(TreeNode root){

        if(root == null)
            return ;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);

        while(deque.size() != 0){
            TreeNode temp = deque.pollLast();
            res.add(temp.key);
            if(temp.right != null)
                deque.offerLast(temp.right);
            if(temp.left != null)
                deque.offerLast(temp.left);
        }
    }
}
