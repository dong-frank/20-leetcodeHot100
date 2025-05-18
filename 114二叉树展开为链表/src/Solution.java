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
    public void flattenSolutionA(TreeNode root) {
        if(root == null){
            return;
        }

        while (root!=null){
            if(root.left == null){
                //无左子树, 直接找下一个节点
                root = root.right;
            }else {
                //开始找左子树的最右边的节点
                TreeNode pre = root.left;
                while (pre.right!=null){
                    pre = pre.right;
                }
                pre.right = root.right;

                root.right = root.left;
                root.left = null;
                root = root.right;
            }


        }

    }

    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;

    }



}
