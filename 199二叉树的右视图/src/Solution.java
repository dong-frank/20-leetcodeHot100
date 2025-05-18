import java.util.*;

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
    public List<Integer> rightSideView(TreeNode root) {
        //按层次遍历二叉树
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueHelp = new LinkedList<>();

        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        queue.add(root);
        queueHelp.add(0);
        int layer = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            layer = queueHelp.poll();
            if(node.left!=null){
                queue.add(node.left);
                queueHelp.add(layer+1);
            }
            if(node.right!=null){
                queue.add(node.right);
                queueHelp.add(layer+1);
            }
            if(queueHelp.isEmpty()){
                ans.add(node.val);
                break;
            }
            if(queueHelp.peek() != layer){
                ans.add(node.val);
            }
        }

        return ans;

    }
}
