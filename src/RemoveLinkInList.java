/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveLinkInList {
	
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        if(head.val == val)head = findNext(head,val);
        ListNode temp = head;
        
        while(temp != null && temp.next != null){
            if(temp.next.val == val) {
                temp.next = findNext(temp.next, val);
            }
            
            temp = temp.next;
        }
        
        return head;
    }
    
    public ListNode findNext(ListNode node, int val){
        while(node != null && node.val == val){
            node=node.next;
        }
        
        return node;
    }
}