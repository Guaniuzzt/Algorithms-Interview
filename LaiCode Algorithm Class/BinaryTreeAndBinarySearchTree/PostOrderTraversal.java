import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {


    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        PostOrderTraversal a = new PostOrderTraversal();
        List<Integer> list = new ArrayList<>();
        a.method(list, node);
        System.out.println(list);  // 2,3,1


    }



    public void method(List<Integer> list, TreeNode node){

        if(node == null)
            return ;

        method(list, node.left);
        method(list, node.right);
        list.add(node.key);


    }
}
