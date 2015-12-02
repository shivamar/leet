/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapKNodes {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode fastHead = head;
        ListNode newHead = head.next;
        ListNode prev = null;
        
        while(head!=null && head.next!=null)
        {
            if(fastHead.next != null) fastHead = fastHead.next.next;
            else fastHead = fastHead.next;
            
            
            while(head != fastHead)
            {
                ListNode temp = head.next;
                //swap 1 and 2 's next
                head.next = temp.next;
                temp.next = head;
                
                //store prev head as 1, link 1 to the new head of next pair 4
                if(prev!=null)prev.next = temp;
                prev = head;
                
                head = head.next;
            }
        }
        
        return newHead;
        
    }
}