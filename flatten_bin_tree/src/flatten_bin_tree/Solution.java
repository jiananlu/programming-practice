package flatten_bin_tree;

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
 public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode p = helper(root);
        p.left = null;
    }
    
    TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if(left == null && right == null) {
            root.left = root;
            root.right = null;
            return root;
        }
        if (right == null) {
            root.left = left.left;
            root.right = left;
            left.left = root;
            return root;
        }
        if (left == null) {
            root.left = right.left;
            root.right = right;
            right.left = root;
            return root;
        }
        root.left = right.left;
        root.right = left;
        right.left = left.left;
        left.left.right = right;
        left.left = root;
        return root;
    }
}