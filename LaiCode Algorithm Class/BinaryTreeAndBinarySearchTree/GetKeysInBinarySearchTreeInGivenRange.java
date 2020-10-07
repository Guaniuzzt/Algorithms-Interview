import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GetKeysInBinarySearchTreeInGivenRange {


    List<Integer> list = new ArrayList<>();


    public void method(TreeNode root, int min, int max){

        if(root == null)
            return ;

        if(root.key > min){
            method(root.left, min, max);
        }

        if(root.key >= min && root.key <= max){
            this.list.add(root.key);
        }

        if(root.key > max){
            method(root.right, min, max);
        }


    }



}
