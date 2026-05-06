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
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));

        int max=0;
        while(q.size()>0){
            int size=q.size();
            int st=0 , end=0;
            for(int i=0; i<size; i++){
                Pair p=q.poll();
                TreeNode node=p.node;
                int idx=p.idx;

                if(i==0) st=idx;
                if(i==size-1) end=idx;

                if(node.left!=null) q.offer(new Pair(node.left,2*idx+1));
                if(node.right!=null) q.offer(new Pair(node.right,2*idx+2));
        
            } 

            max=Math.max(max,end-st+1);
        }

        return max;

    }
}