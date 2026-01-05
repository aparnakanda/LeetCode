/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m=getLength(headA);
        int n=getLength(headB);
        int diff=Math.abs(m-n);
        while(diff>0){
            if(m>n){
                headA=headA.next;
            }
            else{
                headB=headB.next;
            }
            diff--;
        }
        int min=Math.min(m,n);
        while(min>0){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
            min--;
        }
        return null;
        
    }
    private int getLength(ListNode head){
         int len=0;
         ListNode temp=head;
         while(temp!=null){
            len++;
            temp=temp.next;
         }
         return len;
    }
}