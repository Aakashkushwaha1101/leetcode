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
    private int sum(TreeNode root,int cur){
        if(root==null) return 0;
        cur=cur*2 + root.val;

        // leaf node
        if (root.left == null && root.right == null) {
            return cur;
        }

        return sum(root.left,cur) + sum(root.right,cur);

    }
    public int sumRootToLeaf(TreeNode root) {
        if(root==null) return 0;
        return sum(root,0);
        
        
    }
}