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

    public int kthSmallest(TreeNode root, int k) {
        int leftChildCount = calChildCount(root.left);

        if(k == leftChildCount + 1){
            return root.val;
        }

        if(k <= leftChildCount){
            return kthSmallest(root.left, k);
        }else {
            return kthSmallest(root.right, k - leftChildCount -1);
        }

    }

    private int calChildCount(TreeNode root){
        if(root == null){
            return 0;
        }
        int childCount = 1;
        if(root.left != null){
            childCount += calChildCount(root.left);
        }

        if(root.right != null){
            childCount += calChildCount(root.right);
        }

        return childCount;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        Solution.TreeNode root = solution.new TreeNode(1);
        Solution.TreeNode node1 = solution.new TreeNode(1);
        Solution.TreeNode node2 = solution.new TreeNode(2);
        Solution.TreeNode node3 = solution.new TreeNode(4);
        root.right = node2;
        solution.kthSmallest(root,2);


    }

}
