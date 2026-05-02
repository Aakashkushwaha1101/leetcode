/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {

        // bruete force approach

        if(head.next==null) return new int[]{0};

        ListNode temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }

        int[] res=new int[size];
        int k=0;

        ListNode curr=head;
        
        while(curr!=null){
            ListNode temp1=curr.next;
            boolean flag=false;
            
            while(temp1!=null){
                if(temp1.val > curr.val){

                    res[k++]=temp1.val;
                    flag=true;
                    break;

                }
                temp1=temp1.next;
            }

            if(!flag) res[k++]=0;
            curr=curr.next;

            
        }
        return res;

    }
}