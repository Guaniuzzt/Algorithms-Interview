import utils.TreeNode;

public class IsBinarySearchOrNot {



    public boolean method(TreeNode root){

        if(root == null)
            return true;

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        return helper(root, max, min);



    }


    public static boolean helper(TreeNode root, int max, int min){

        if(root == null)
            return true;

        if(root.key > max || root.key < min)
            return false;

        return helper(root.left, root.key, min) && helper(root.right, max, root.key);

    }
}
