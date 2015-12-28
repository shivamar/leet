/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedCycle {
    public boolean hasCycle(ListNode head) {
       ListNode fastNode = null;
       if(head == null) return false;
        
        //move both head by 1 and fast by 2
        if(head.next != null) fastNode = head.next.next;
        else return false;
        head = head.next;
        
        while(fastNode != null && fastNode.next != null && fastNode != head){
            head = head.next;
            fastNode = fastNode.next.next;
        }
        
        if(fastNode == head) return true;
        else return false;
        
    }
}