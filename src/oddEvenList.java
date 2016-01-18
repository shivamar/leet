
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

 * @author Shiva
 *
 */
public class oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode odd = head, evenHead = odd.next,even = evenHead;
        
        while(odd.next != null && odd.next.next != null )
        {
            odd.next = odd.next.next;
            odd = odd.next;
            
            even.next = even.next.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        
        return head;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
}
