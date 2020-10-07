import utils.TreeNode;

public class InsertIntoBinarySearchTree {



    public TreeNode method(TreeNode root, int val){

        if(root == null)
            return new TreeNode(val);

        if(root.key < val)
            root.right = method(root.right, val);
        else
            root.left = method(root.left, val);

        return root;

    }
}
