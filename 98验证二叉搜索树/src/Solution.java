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

    private TreeNode prevNode;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        if(root.left!=null){
            if(!isValidBST(root.left)){
                return false;
            }
        }
        if(prevNode != null){
            if(prevNode.val >= root.val){
                return false;
            }
        }

        prevNode = root;

        if(root.right!=null){
            if(!isValidBST(root.right)){
                return false;
            }
        }

        return true;
    }

}
