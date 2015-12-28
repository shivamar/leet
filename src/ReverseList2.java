/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
  Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. 
 */
public class ReverseList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        if(m==n) return head;
        
        ListNode mSpot = head,nSpot = head,prevMSpot = head;
        int c=1;
        while(c < n){
            if(c < m-1) prevMSpot = prevMSpot.next;
            if(c < m) mSpot = mSpot.next;
            nSpot = nSpot.next;
            c++;
        }
        mSpot = reverse(mSpot,nSpot.next);
        if(m != 1) prevMSpot.next = mSpot;
        
        if(m==1) return mSpot;
        else return head;
    }
    
    public ListNode reverse(ListNode start,ListNode end)
    {
        ListNode curr=start,prev=end,next=start.next;
        
        while(curr != end)
        {
            curr.next = prev;
            prev = curr;
            curr = next;
            
            if(curr != null) next = curr.next;
        }
        
        return prev;
    }
}