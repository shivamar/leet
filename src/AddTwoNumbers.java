import CTCILibrary.*;
/*
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

	public AddTwoNumbers() {
		// TODO Auto-generated constructor stub
	}

	public static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
	
		int carry = 0, val = l1.data+l2.data;
		
		carry = val / 10;
		val = val % 10;
		LinkedListNode curr = new LinkedListNode(val);
		LinkedListNode head = curr;
		
		l1= l1.next;
		l2 = l2.next;
		
		if(l1 != null && l2 != null)
		{
			for(;l2 != null && l1 != null; l1 = l1.next, l2 = l2.next)
			{			   
				val = l1.data + l2.data + carry;				
				
				if(val > 9)
				{					
					val = val % 10;
					
					curr = curr.next = new LinkedListNode(val);					
					
					carry = 1;
				}
				else
				{
//					if(curr != head) 
						   curr = curr.next = new LinkedListNode(val);
//					else
//						curr.data = val;
					carry = 0;
				}
							
			}
		}
		
		while(l1 == null && l2 != null)
		{			
			val = l2.data + carry;
			
			if(val > 9)
			{					
				val = val % 10;
				
//				if(curr != head) 
				   curr = curr.next = new LinkedListNode(val);
//				else
//				curr.data = val;
				
				carry = 1;
			}
			else
			{
//				if(curr != head) 
					   curr = curr.next = new LinkedListNode(val);
//				else
//					curr.data = val;
				carry = 0;
			}
			
			l2 = l2.next;
			//curr.next = l2.next;			
		}		
		
		while(l2 == null && l1 != null)
		{
	val = l1.data + carry;
			
			if(val > 9)
			{					
				val = val % 10;
				
//				if(curr != head) 
				   curr = curr.next = new LinkedListNode(val);
//				else
//				curr.data = val;
				
				carry = 1;
			}
			else
			{
//				if(curr != head) 
					   curr = curr.next = new LinkedListNode(val);
//				else
//					curr.data = val;
				carry = 0;
			}
			
			l1 = l1.next;
				}		
		
		if(carry == 1) curr.next = new LinkedListNode(1);
		
		return head;
     }
	
	public static void main(String[] args)
	{
		LinkedListNode h1 = new LinkedListNode(0);
		//h1.next = new LinkedListNode(7);
		LinkedListNode h2 = new LinkedListNode(1);
		//h2.next = new LinkedListNode(2);
		
		LinkedListNode head = addTwoNumbers(h1,h2);
		
		while(head != null)
		{
			System.out.println(head.data);
			head = head.next;
		}
	}

}
