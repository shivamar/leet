/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
 Reverse a singly linked list.
 */
public class ReverseAList {
    
    public ListNode reverseList(ListNode head){
        if(head == null) return null;
        ListNode prev = null,curr = head, next = head.next;
        
        while(curr != null)
        {
            curr.next = prev;
            prev = curr;
            curr = next;
            
            if(curr != null) 
                next = curr.next;
        }
        
        return prev;
    }
}