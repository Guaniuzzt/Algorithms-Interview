import utils.TreeNode;

public class LowestCommonAncester_I {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {

        //step1. 只考虑什么时候停止往下递归，每次递归的返回给step3 去做
        if(root == null){
            return null;
        }
        if(root.key == one.key || root.key == two.key){
            return root;
        }

        //step2. 如何向下去递归
        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);

        //step3. 如何处理返回上来的数据，返回上一层
        if(left != null && right != null){
            return root;
        }
        else if(left != null){
            return left;
        }else{
            return right;
        }

    }
}
