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

    int ans =0;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depthOfBinaryTree(root);
        return ans;
    }

    private int depthOfBinaryTree(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDepth = 0;
        if(root.left!=null){
            leftDepth = depthOfBinaryTree(root.left) +1;
        }

        int rightDepth = 0;
        if(root.right!=null){
            rightDepth = depthOfBinaryTree(root.right) +1;
        }
        ans = Math.max(leftDepth + rightDepth,ans);


        return Math.max(leftDepth,rightDepth);
    }
}
