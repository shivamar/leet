
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class isSinglyListPalindrome {
    /*
    get the slow pointer at the midpoint and reverse the first half od list until the slow pointer
    keep checking the head and slo pointer moving thru the list until head reaches mid point
    1,2,3,3,2,1
    becomes 3,2,1,3,2,1
    */
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        ListNode fastNode = head,slow=head;
        
        while(!(fastNode == null || fastNode.next == null))
        {
            slow = slow.next;
            fastNode = fastNode.next.next;
        }
        //slow node is just after midpoint for even lists and mid points for odd lists
        
        head = reverse(head,slow);
        //adjust the midpoint and slow node start for odd lists
        ListNode midPoint = slow;
        if(fastNode != null) slow = slow.next; 
        while(head != midPoint){
            if(head.val != slow.val) return false;
            
            head = head.next;
            slow = slow.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head,ListNode slow){
        ListNode prev = slow,curr = head, next = head.next;
        
        while(curr != slow)
        {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        
        return prev;
    }
}