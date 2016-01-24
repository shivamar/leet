import java.util.Stack;


public class PalindromeList {
	
    public boolean isPalindrome(ListNode head) {
    	ListNode slow=head,fast=head;
    	
        Stack<Integer> stack = new Stack<>();
        
        while(fast !=null && fast.next != null)
        {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;    
        }
        
        if(fast != null)
            slow = slow.next;
            
        while(stack.isEmpty() && slow != null)
        {
            int val = stack.pop();
            
            if(val != slow.val) return false;
            
            slow = slow.next;
        }
        
        return true;
    }
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	

}
