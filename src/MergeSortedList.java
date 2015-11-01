
public class MergeSortedList {
	
	  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		  
	        if(l1 == null && l2 == null){
	            return null;    
	        }
	        
	        if(l1 == null || l2 == null){
	           if(l1 == null) return l2;
	           else return l1;
	        }
	        
	        ListNode ans = null;
	        if(l1.val <= l2.val){
	            ans = l1;
	            l1=l1.next;
	            
	        }
	        else if(l1.val > l2.val){
	            ans = l2;
	            l2=l2.next;
	        }
	        ListNode head = ans;
	        
	        while(l1 != null && l2 != null){
	            if(l1.val <= l2.val ){
	                ans.next = l1;
	                l1 = l1.next;
	            }
	            else{
	                ans.next = l2;
	                
	                l2 = l2.next;
	            }
	            
	            ans = ans.next;
	        }
	        
	        
	        if(l1 == null){
	            ans.next = l2;
	        }
	        
	        if(l2 == null){
	            ans.next = l1;
	        }
	        
	        return head;
	    }	
	  
	  public static void main(String[] args){
		  ListNode li1 = new ListNode(1);
		  li1.next = new ListNode(5);
		  
		  ListNode li2 = new ListNode(3);
		  li2.next = new ListNode(30);
		  
		  ListNode a = mergeTwoLists(li1,li2);
		  
		  while(a != null){
			  System.out.println(a.val);
			  a = a.next;
		  }
	  }
}

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
