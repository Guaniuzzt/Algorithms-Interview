import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class CheckIfBinaryTreeIsCompleted {

    /*
    Check if a given binary tree is completed.
    A complete binary tree is one in which every level of the binary tree is
    completely filled except possibly the last level.
    Furthermore, all nodes are as far left as possible.
     */

    public boolean method(TreeNode root){
        if(root == null)
            return true;
        Deque<TreeNode> deque = new ArrayDeque<>();
        boolean tag = false;
        deque.offerLast(root);
        while(!deque.isEmpty()){

            int size = deque.size();
            while(size != 0){
                TreeNode temp = deque.pollFirst();
                if(temp.left != null){
                    if(tag == false)
                        deque.offerLast(temp.left);
                    else
                        return false;
                }else{
                    tag = true;
                }

                if(temp.right != null) {
                    if (tag == false)
                        deque.offerLast(temp.right);
                    else
                        return false;
                }else{
                    tag = true;
                }
                size--;
            }
        }
        return true;


    }
}
