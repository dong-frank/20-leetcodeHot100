import java.util.HashMap;
import java.util.Map;

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

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> preFixSum = new HashMap<>();
        preFixSum.put(0L,1); //前缀和为0的, 有1条

        return dfs(root,preFixSum,0,targetSum);

    }

    private int dfs(TreeNode node, Map<Long, Integer> preFixSum, long cur, int targetSum){
        if(node == null){
            return 0;
        }

        cur+= node.val;

        int ret = preFixSum.getOrDefault(cur - targetSum, 0);

        preFixSum.put(cur, preFixSum.getOrDefault(cur,0) + 1);

        ret += dfs(node.left, preFixSum, cur, targetSum);
        ret += dfs(node.right, preFixSum, cur, targetSum);
        preFixSum.put(cur, preFixSum.getOrDefault(cur, 0) -1); //要去走另一条路了, 要去掉这个前缀和
        return ret;
    }
}
