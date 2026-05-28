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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode curr=dummy;

        int carry=0;
        while(temp1!=null && temp2!=null){
            int sum=temp1.val + temp2.val;
            if(carry!=0) sum +=carry;
            carry =sum/10;
            int data=sum%10;

            ListNode node=new ListNode(data);
            curr.next=node;
            curr=curr.next;


            temp1=temp1.next;
            temp2=temp2.next;

            
        }
        // if(temp1!=null) temp1=temp1.next;
        // if(temp2!=null) temp2=temp2.next;
        while(temp1!=null){
            int sum=temp1.val;
            if(carry!=0) sum +=carry;
            carry =sum/10;
            int data=sum%10;

            ListNode node=new ListNode(data);
            curr.next=node;
            curr=curr.next;
            temp1=temp1.next;
        }
        while(temp2!=null){
            int sum=temp2.val;
            if(carry!=0) sum +=carry;
            carry =sum/10;
            int data=sum%10;

            ListNode node=new ListNode(data);
            curr.next=node;
            curr=curr.next;
            temp2=temp2.next;
        }
        if(carry!=0){
            ListNode node=new ListNode(carry);
            curr.next=node;   
        }

        return dummy.next;
    }
}