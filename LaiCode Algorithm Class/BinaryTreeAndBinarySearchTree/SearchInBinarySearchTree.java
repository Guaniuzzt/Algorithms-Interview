import utils.TreeNode;

public class SearchInBinarySearchTree {


    TreeNode[] res = new TreeNode[1];


    public void method(TreeNode root, int key){

        if(res == null)
            return ;


        if(root.key > key)
            method(root.left, key);

        if(root.key == key)
            this.res[0] = root;

        if(root.key < key){
            method(root.right, key);
        }


    }
}
