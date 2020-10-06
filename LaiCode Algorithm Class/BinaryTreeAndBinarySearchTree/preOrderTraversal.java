import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class preOrderTraversal {

    //recursive

    List<Integer> res = new ArrayList<>();

    public void method(TreeNode node){

        if(node == null){
            return ;
        }

        res.add(node.key);
        method(node.left);
        method(node.right);


    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        preOrderTraversal a = new preOrderTraversal();
        a.method(node);
        System.out.println(a.res);  // 1,2,3
    }
}
