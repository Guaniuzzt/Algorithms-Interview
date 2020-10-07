import utils.TreeNode;

public class SymmetricBinaryTree {


    /*
        Time：
        1 + 2 +2^2+ ...+ 2^logn = n
        每个节点1 => O（n)
        Space: O(height)
     */

    public boolean method(TreeNode root){

        if(root == null)
            return true;
        return helper(root.left, root.right);
    }

    public static boolean helper(TreeNode left, TreeNode right){

        if(left == null && right == null)
            return true;

        else if(left == null)
            return false;
        else if(right == null)
            return false;
        else if(left.key != right.key)
            return false;

        return helper(left.left, right.right) && helper(left.right, right.left);

    }
}
