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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        int size=0;
        ListNode temp=head;
        
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        
        int n=k%size;  //if k==size hota hai it means after k rotation same list milegi input vaali
        
        if(n==0) return head;
        
        ListNode last=head;
        while(last.next!=null){last=last.next;}
        last.next=head;   //circular --> connect last.next=first(head)
        
        int rotate = size - n;
        ListNode temp2 = head;
        for (int i = 1; i < rotate; i++) {
            temp2 = temp2.next;                   //ekk aur new pointer leke aage gaye jhaa se rotate krna tha
        }
        
        ListNode head1=temp2.next;
        temp2.next=null;

        return head1;





    }
}