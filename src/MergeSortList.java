/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
 * Sort a linked list in O(n log n) time using constant space complexity
 */


public class MergeSortList {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        
        ListNode fastNode = head,slow = head,prev=slow;
        
        if(head.next == null) return head;
        
        while(fastNode != null && fastNode.next != null)
        {
            fastNode = fastNode.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next=null;
        
       head = merge(sortList(head), sortList(slow));
       
       return head;
    }
    
    public ListNode merge(ListNode head1, ListNode head2)
    {
        ListNode temp = new ListNode(0), head=temp;
        
        while(head1 != null && head2 != null)
        {
            if(head1.val < head2.val){
                temp.next = head1;
                temp=temp.next;
                head1 = head1.next;
            }
            else {
                temp.next=head2;
                temp=temp.next;
                head2 = head2.next;
            }
        }
        
        if(head1 == null && head2 != null){
            temp.next = head2;
        }
        
        if(head2 == null && head1 != null){
            temp.next = head1;
        }
        
        return head.next;
    }
}