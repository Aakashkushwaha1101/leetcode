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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // if(list1==null && list2==null) return list1;
        // if(list1==null) return list2;
        // if(list2==null) return list1;
    
        ListNode temp=list1;
        ListNode temp2=list1;
        while(a-1>0){
            temp=temp.next;
            a--;
        }
        while(b+1>0){
            temp2=temp2.next;
            b--;
        }

        ListNode list2Last=list2;
        while(list2Last.next!=null){
            list2Last=list2Last.next;
        }
        temp.next=list2;
        list2Last.next=temp2;

        return list1;
    }
}