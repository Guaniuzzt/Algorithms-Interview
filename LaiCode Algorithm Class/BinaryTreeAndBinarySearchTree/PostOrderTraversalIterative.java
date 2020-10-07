import utils.TreeNode;

import java.util.*;

public class PostOrderTraversalIterative {



    public void method(TreeNode root){

        if(root == null)
            return ;

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while(deque.size() != 0){

            TreeNode temp = deque.pollLast();
            list.add(temp.key);
            if(temp.left != null){
                deque.offerLast(temp.left);
            }
            if(temp.right != null){
                deque.offerLast(temp.right);
            }
        }
        Collections.reverse(list);



    }
}
