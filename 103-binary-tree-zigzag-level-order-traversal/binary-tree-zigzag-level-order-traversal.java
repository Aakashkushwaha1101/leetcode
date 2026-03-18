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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean flag=false;
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> res=new ArrayList<>(Collections.nCopies(size, 0));

            for(int i=0; i<size; i++){
                TreeNode temp=q.poll();
                if(flag){
                    int idx=size - i -1;
                    res.set(idx,temp.val);
                }else{
                    int idx1= i;
                    res.set(idx1,temp.val);
                }
                

                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }

            }
            flag=!flag;
            ans.add(res);

        }
        return ans;
        
    }
    
}