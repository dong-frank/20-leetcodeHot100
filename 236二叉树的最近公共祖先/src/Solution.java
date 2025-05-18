public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q){
            return root;
        }

        boolean pInLeft = isInTree(root.left,p);
        boolean qInRight = isInTree(root.right,q);

        if(pInLeft && qInRight || (!pInLeft && !qInRight)){
            return root;
        }

        if(pInLeft){
            return lowestCommonAncestor(root.left, p, q);
        }

        return lowestCommonAncestor(root.right,p,q);

    }

    private boolean isInTree(TreeNode root, TreeNode target){
        //检查target是否在树上
        if(root == null){
            return false;
        }

        if(root == target){
            return true;
        }
        if(isInTree(root.left,target)){
            return true;
        }

        return isInTree(root.right, target);
    }
}
