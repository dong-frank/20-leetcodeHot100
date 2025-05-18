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

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return helper(root.left, root.right);

    }

    private boolean helper(TreeNode a, TreeNode b){
        if(a == null && b == null){
            return true;
        }
        if(a == null || b == null ){
            return false;
        }

        if(a.val!=b.val){
            return false;
        }
        boolean left = helper(a.left,b.right);
        boolean right = helper(a.right, b.left);
        return left&&right;
    }
}
