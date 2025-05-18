import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queueForNode = new LinkedList<>();
        Queue<Integer> queueForLayer = new LinkedList<>();
        queueForNode.add(root);
        queueForLayer.add(1);
        int layer = 1;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> layerAns = new ArrayList<>();
        while (!queueForNode.isEmpty()){
            TreeNode node = queueForNode.poll();
            int tmp = queueForLayer.poll();
            if(tmp == layer){
                layerAns.add(node.val);
            }else {
                layer = tmp;
                ans.add(layerAns);
                layerAns = new ArrayList<>();
                layerAns.add(node.val);
            }
            if(node.left!=null){
                queueForNode.add(node.left);
                queueForLayer.add(layer+1);
            }
            if(node.right!=null){
                queueForNode.add(node.right);
                queueForLayer.add(layer+1);
            }
        }

        ans.add(layerAns);
        return ans;
    }
}

