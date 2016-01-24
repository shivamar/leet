/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 
 /*
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode lastSmallPtr = dummy, currPtr=dummy;
        
        while(currPtr.next != null)
        {
            if(currPtr.next.val < x && lastSmallPtr == currPtr )
            {
                lastSmallPtr=lastSmallPtr.next;
                currPtr = currPtr.next;
            }
            else if(currPtr.next.val < x && lastSmallPtr != currPtr )
            {
                ListNode firstBiggerPtr = lastSmallPtr.next;
                ListNode thisPtr = currPtr.next;
                
                //update the currPtr.next to point to (smaer element s next node)thisPtr.next
                currPtr.next = currPtr.next.next;
                
                //update lastSmallPtr to point to thisPtr and make thisPtr the lastSmallPtr and make lastSmallPtr.next point to firstBigPtr
                lastSmallPtr.next = thisPtr;
                lastSmallPtr = lastSmallPtr.next;
                
                lastSmallPtr.next =firstBiggerPtr;
            }
            else
            {
                currPtr = currPtr.next;
            }
            
        }
        
        return dummy.next;
    }
}