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
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        if(head.next.next == head) return head;
        
        ListNode slow = head.next, fast = fast = head.next.next;;
        
        while(slow != fast && fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if(slow != fast) return null;
        
        while(head != slow)
        {
            head = head.next;
            slow = slow.next;
        }
        
        return head;
    }
}