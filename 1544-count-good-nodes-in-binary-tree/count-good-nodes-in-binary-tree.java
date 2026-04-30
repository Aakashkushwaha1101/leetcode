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
    int count;
    private void goodNode(TreeNode root, int max){
        if(root==null) return;
        if(root.val >= max){
            count=count+1;
        }
        goodNode(root.left,Math.max(max,root.val));
        goodNode(root.right,Math.max(max,root.val));
        

    }
    public int goodNodes(TreeNode root) {
        count=0;
        goodNode(root,Integer.MIN_VALUE);
        return count;

    }
}