import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class MergeKSortedList {
	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		Queue<ListNode> qu = new PriorityQueue<ListNode>(
				(new Comparator<ListNode>() {
					public int compare(ListNode a, ListNode b) {
						if (a.val < b.val)
							return -1;
						else if (a.val == b.val)
							return 0;
						else
							return 1;
					}
				}));

		// add to priority queue
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				qu.offer(lists[i]);
		}

		if (qu.isEmpty())
			return null;
		// remove from queue and inittialise result head
		ListNode head = qu.poll();
		;
		ListNode nextNode = head;
		if (nextNode.next != null)
			qu.offer(nextNode.next);

		// until the qu is empty , keep growing ur resultNodes and emptying the
		// k group nodes
		while (!qu.isEmpty()) {
			nextNode.next = qu.poll();
			nextNode = nextNode.next;
			if (nextNode.next != null)
				qu.offer(nextNode.next);
		}

		return head;
	}
}