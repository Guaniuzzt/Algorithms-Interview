import utils.TreeNode;

public class MaxDifference {

    /*
    find the node with the max difference in the total number of
    descendents in its left subtree and right subtree

     */

    public int maxDifferentNode(TreeNode root, int[] globalmax, TreeNode[] solu){

        if(root == null)
            return 0;

        //step1
        int leftTotal = maxDifferentNode(root.left, globalmax,solu);
        int rightTotal = maxDifferentNode(root.right, globalmax, solu);

        if(Math.abs(leftTotal - rightTotal) > globalmax[0]){
            globalmax[0] = Math.abs(leftTotal - rightTotal);
            solu[0] = root;
        }

        return leftTotal + rightTotal + 1;
    }
}
