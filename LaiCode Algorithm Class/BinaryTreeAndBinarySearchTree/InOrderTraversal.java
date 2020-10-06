import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {


    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        InOrderTraversal a = new InOrderTraversal();
        List<Integer> list = new ArrayList<>();
        a.method(list, node);
        System.out.println(list);   //2,1,3

    }


    public void method(List<Integer> list, TreeNode node){
        if(node == null)
            return ;

        method(list, node.left);
        list.add(node.key);
        method(list, node.right);
    }
}
