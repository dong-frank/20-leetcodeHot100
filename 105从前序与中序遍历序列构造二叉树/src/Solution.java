import java.util.Arrays;

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //由前序遍历确定根节点
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int idx = 0;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == rootVal){
                idx = i;
                break;
            }
        }
        int leftSize = idx;
        int rightSize = inorder.length-1-idx;

        if(leftSize != 0){
            int[] newPreOrder = Arrays.copyOfRange(preorder,1,1 + leftSize);
            int[] newInOrder = Arrays.copyOfRange(inorder,0,leftSize);
            root.left = buildTree(newPreOrder,newInOrder);
        }

        if(rightSize!= 0){
            int[] newPreOrder = Arrays.copyOfRange(preorder,1 + leftSize, 1 + leftSize + rightSize);
            int[] newInOrder = Arrays.copyOfRange(inorder,idx+1,idx+1+rightSize);
            root.right = buildTree(newPreOrder, newInOrder);

        }

        return root;
    }

}
