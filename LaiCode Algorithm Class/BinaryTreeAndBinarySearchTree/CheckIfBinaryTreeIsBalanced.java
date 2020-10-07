import utils.TreeNode;

public class CheckIfBinaryTreeIsBalanced {


    public boolean method(TreeNode node){

        if(node == null)
            return true;

        return helper(node) != -1;


    }
    public static int helper(TreeNode node){
        if(node == null)
            return 0;

        int left = helper(node.left);
        int right = helper(node.right);

        if(left == -1 || right == -1){
            return -1;
        }else if(Math.abs(left - right) > 1){
            return -1;
        }else
            return Math.max(left, right) + 1;
    }


    public static boolean helper2(TreeNode node){

        //Time: O(nlogn)
        //Space: O(Height)
        if(node == null)
            return true;

        int left = GetBinaryTreeHeight.method(node.left);
        int right = GetBinaryTreeHeight.method(node.right);

        if(Math.abs(left - right) > 1)
            return false;

        return helper2(node.left) && helper2(node.right);
    }
}
