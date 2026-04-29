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
    private void inOrder(TreeNode root,List<Integer> temp){
        if(root==null) return;
        
        inOrder(root.left,temp);
        temp.add(root.val);
        inOrder(root.right,temp);
    }
    public boolean findTarget(TreeNode root, int k) {
        
        List<Integer> temp=new ArrayList<>();
        inOrder(root,temp);  //O(n)
        int i=0;
        int j=temp.size()-1;
        
        while(i<j){
            int tar=temp.get(i) + temp.get(j);   //O(n)
            if(tar==k) return true;
            else if(tar > k) j--;
            else i++;
            
        };
        return false ;
    }
}