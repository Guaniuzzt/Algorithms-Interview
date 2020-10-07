import utils.TreeNode;

public class DeleteInBinarySearchTree {


    public TreeNode method(TreeNode root, int key){

        if(root == null)
            return root;


        if(root.key > key)
           root.left =  method(root.left, key);
        else if(root.key < key)
            root.right = method(root.right, key);

        //左null或者右null
        if(root.left == null)
            return root.right;
        else if(root.right == null)
            return root.left;
        else{

            //root.right.left == null 直接把root.left移动到root.right.left
            if(root.right.left == null){
                root.right.left = root.left;
                return root.right;
            }else{
                //找到root.right下最小值， 移动时注意把smallest.right移到上一层的left
                //smallest.left = root.left
                //smallest.right = root.right
                //移除root
                TreeNode smallest = findsmallest(root.right);
                smallest.right = root.right;
                smallest.left = root.left;
                return smallest;
            }


        }



    }


    public static TreeNode findsmallest(TreeNode root){

        TreeNode pre = root;
        TreeNode cur = pre.left;
        while(cur.left != null){
            pre = cur;
            cur = cur.left;
        }
        pre.left = cur.right;

        return cur;
    }


}
