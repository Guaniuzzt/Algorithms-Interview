import utils.TreeNode;

public class GetBinaryTreeHeight {
    /*
    Time； O(n)
    Space: O(n), Height of Tree, worst case
     */


    public static int method(TreeNode node){

        if(node == null)
            return 0;

        int left = method(node.left);
        int right = method(node.right);
        return Math.max(left, right) + 1;
    }
}
