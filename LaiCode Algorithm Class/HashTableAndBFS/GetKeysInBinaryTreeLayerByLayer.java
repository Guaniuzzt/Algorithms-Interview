import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GetKeysInBinaryTreeLayerByLayer {





    public List<List<Integer>> method(TreeNode root){

        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);

        while(deque.size() != 0){
            int size = deque.size();
            List<Integer> templist = new ArrayList<>();
            while(size != 0){
                TreeNode temp = deque.pollFirst();
                templist.add(temp.key);
                if(temp.left != null)
                    deque.offerLast(temp.left);

                if(temp.right != null)
                    deque.offerLast(temp.right);
                size--;
            }
            list.add(templist);
        }

        return list;


    }
}
