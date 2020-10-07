import utils.TreeNode;

public class TweakedIdenticalBinaryTrees {
    /*
    Time:
    1, 4, 4^2, ,,,,, 4^logn => o(n ^ 2)
    Space：n(height)

     */

    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {

        if(one == null && two == null){
            return true;
        }else if(one == null || two == null){
            return false;
        }else if(one.key != two.key){
            return false;
        }

        return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)
                || isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
    }


}
