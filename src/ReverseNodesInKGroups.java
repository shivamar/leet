
/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 * @author Shiva
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseNodesInKGroups {
    
    //checks length is >/=  group and then reverses groups recursively or doesnt reverse that group if length is less than group
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return head;
        
        if(checkLength(head,k))
            return reverseKGroupModule(head, k);
        else return head;
    }
    
    //k shud not be greater than length
    public boolean checkLength(ListNode head, int k) {
        int len=0;
        while(head != null)
        {
            head = head.next;
            len++;
        }
        return !(k > len);
    }
    
    public ListNode reverseKGroupModule(ListNode head, int k) {
        if(head==null) return head;
        ListNode curr=head;
        ListNode prev=null,next=curr.next,NextBatch=null;
        int counter=0;
        
        while(++counter !=k+1 && curr != null)
        {
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
       // head.next=next;
        head.next=reverseKGroup(curr,k);
        
        return prev;
    }
    
    
}