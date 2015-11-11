/*
 * *
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

 */

public class RemoveNthNode {
	

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        if(n==1 && head.next == null) return null;
	        
	        ListNode fast = head;
	        ListNode slow = head;
	        int i=0;
	        while(i < n){
	            i++;
	            fast = fast.next;
	        }
	        
	        if(fast == null) return slow.next; //in case they want to remove head [1 2 3] 3
	        while(fast != null){
	            fast = fast.next;
	           if(fast!=null) slow = slow.next;
	        }
	        
	        slow.next = slow.next.next;
	        
	        return head;
	    }
	    
	    public static void main(String[] args) {
			// TODO Auto-generated method stub

		}
}


