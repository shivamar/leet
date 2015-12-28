
/*
	  Given a sorted linked list, delete all duplicates such that each element appear only once.

	  For example,
	  Given 1->1->2, return 1->2.
	  Given 1->1->2->3->3, return 1->2->3. 
 */
public class DeleteDuplicatesInList {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null ) return head;
		ListNode slow = head;

		while(slow.next != null){
			if(slow.val == slow.next.val) slow.next = slow.next.next;
			else slow = slow.next;
		}

		return head;
	}
}
