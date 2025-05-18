import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        if(root.left!=null){
            ret.addAll(inorderTraversalRec(root.left));
        }
        ret.add(root.val);
        if(root.right!=null){
            ret.addAll(inorderTraversalRec(root.right));
        }
        return ret;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
         //尝试用迭代解决TODO
        List<Integer> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true){
            if(node.left !=null){
                stack.push(node);
                node = node.left;
            }else {
                ret.add(node.val);
                if(!stack.isEmpty()){
                    node = stack.pop();
                }
                if(node.right != null){
                    node = node.right;
                }else {
                    if(!stack.isEmpty()){
                        node = stack.pop();
                    }else {
                        ret.add(node.val);
                        break;
                    }
                }
            }

        }
        return ret;
    }

}