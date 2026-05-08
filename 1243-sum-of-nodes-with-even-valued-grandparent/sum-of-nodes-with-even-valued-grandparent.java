/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int dfs(TreeNode node, TreeNode parent, TreeNode grandParent) {
        if (node == null) return 0;

        int sum = 0;

        // if grandparent exists and is even
        if (grandParent != null && grandParent.val % 2 == 0) {
            sum += node.val;
        }

        sum += dfs(node.left, node, parent);
        sum += dfs(node.right, node, parent);

        return sum;
    }
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root,null,null);
    }
}