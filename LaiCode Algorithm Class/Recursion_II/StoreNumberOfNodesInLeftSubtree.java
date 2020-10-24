public class StoreNumberOfNodesInLeftSubtree {

    /*
    Recursion 和 Tree结合
    1）What do you expect from your lchild/rchild?
    2) What do you want do in the current layer?
    3) What do you want to report to your parent?
     */


    public static void numNodesLeft(TreeNodeLeft root) {

        helper(root);
    }

    public static int helper(TreeNodeLeft root){
        if(root == null)
            return 0;

        int left = helper(root.left);
        int right = helper(root.right);
        root.numNodesLeft = left;
        return left +right + 1;
    }




}

class TreeNodeLeft {
    public int key;
    public TreeNodeLeft left;
    public TreeNodeLeft right;
    public int numNodesLeft;
    public TreeNodeLeft(int key) {
      this.key = key;
    }
}
