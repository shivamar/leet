/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RotateList {
    /*
    Given a list, rotate the list to the right by k places, where k is non-negative.

    For example:
    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.
    */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        
        ListNode fastNode = head, slowNode = head,newHead = null;
        
        for(int i=0;i<k;i++){
           if(fastNode.next != null) fastNode = fastNode.next;
           else{
             
             int len = i+1;
             k = k % len;
             
             if(k == 0) return head;
             else {
                 fastNode = head;
                 while(k-- > 0)
                    fastNode = fastNode.next;
             }
             
           } 
        }
        
        while(fastNode.next != null)
        {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        
       if(slowNode.next != null)newHead = slowNode.next;
        
        slowNode.next = null;
        fastNode.next = head;
        
        return newHead;
    }
}