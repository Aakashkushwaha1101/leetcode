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
    List<String> temp=new ArrayList<>();
    private void helper(TreeNode root,String s){
        if(root==null)   return;
        s += root.val;

        if(root.left==null && root.right==null){   ///when you are on leaf node then add in temp it make sense
            temp.add(s);
            return;
        }
        helper(root.left,s);
        helper(root.right,s);
    }
    public int sumNumbers(TreeNode root) {
        helper(root,"");
        int sum=0;
        for(int i=0; i<temp.size(); i++){
            if(!temp.get(i).equals("")){
                int num=Integer.parseInt(temp.get(i));
                sum +=num;
            }
            
        }

        return sum;
    }
}