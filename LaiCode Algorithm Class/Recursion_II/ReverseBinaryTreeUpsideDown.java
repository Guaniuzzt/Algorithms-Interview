import utils.TreeNode;

public class ReverseBinaryTreeUpsideDown {


    public TreeNode reverse(TreeNode root) {
        // Write your solution here
        //step1. 找到recursion base case
        if(root == null || root.left == null)
            return root;
        //step2. recursion rule
        TreeNode newroot = reverse(root.left); //等价于 if(root.left.left == null) return root;

        //step3. 这里只处理本层和上层的关系，但上层和上上层的关系没有改变，
        //需要本次recursion结束后由上一层recursion的step3 来修改node的关系
        root.left.right = root.right;
        root.left.left = root;
        root.left = null;
        root.right = null;

        return newroot;
    }

    public TreeNode reverseRight(TreeNode root){

        if(root == null || root.right == null){
            return root;
        }
        TreeNode newhead = reverseRight(root.right);

        root.right.left = root.left;
        root.right.right = root;
        root.left = null;
        root.right = null;

        return newhead;

    }
}
