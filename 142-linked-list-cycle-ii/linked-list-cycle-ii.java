/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
       //approach 2
       ListNode slow=head;
       ListNode fast=head;

       while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast) break;
       }
       if(fast!=slow) return null;
       
       ListNode nodeOne=head;
       while(nodeOne!=slow){
            slow=slow.next;
            nodeOne=nodeOne.next;
       }
    
        return nodeOne;
    }
}