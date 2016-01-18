import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
tion for singly-linked list.

 * public class ListNode {

 *     int val;

 *     ListNode next;

 *     ListNode(int x) { val = x; }

 * }

 */

 /*

 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 */


public class Merge2SortedList {	
    // k is number of list ; O(n) is n(logK); 100 list of size 10 each- 2000 is complexity

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0) return null;      
		
        Comparator<ListNode> comp = new ListNodeCompartor();
        
       PriorityQueue<ListNode> pq = new PriorityQueue(lists.length,comp);   //new Comparator<ListNode>{
//        	public int compare(ListNode a,ListNode b){
//                return a.val - b.val;
//        });
//        
        

        for(ListNode ls : lists){
            if(ls != null) pq.offer(ls);
        }

        ListNode head =null,curr=null,iteratorNode=null;
        
        if(!pq.isEmpty()){

            iteratorNode = pq.remove();

            curr=iteratorNode;

            head = curr;

            

            if(iteratorNode.next != null) {

                pq.offer(iteratorNode.next);

            }

        }

        

        while(!pq.isEmpty())

        {

            iteratorNode = pq.remove();

            curr.next =  iteratorNode;

            curr = curr.next;

            

            if(iteratorNode.next != null) {

                pq.offer(iteratorNode.next);

            }

        }

        

        return head;

        

    }

    

        

    // k is number of list ; O(n) is nK; 100 list of size 10 each- 100000 is complexity

    public ListNode mergeKLists_nk(ListNode[] lists) {

        if(lists== null || lists.length == 0) return null;

        boolean[] arr = new boolean[lists.length];

        Arrays.fill(arr,true);

        ListNode curr=null,head = null;

        int smallest_Index=-1,smallest=Integer.MAX_VALUE;

        

        while(hasAtleastOneVal(arr)){

            for(int i=0;i < lists.length;i++)

            {

                if(arr[i] == false) continue;

                

                if(lists[i] == null){

                   // lists[i] = null;

                    arr[i] = false;

                    

                    continue;

                }

                

                if(lists[i].val <= smallest){

                    smallest = lists[i].val;

                    smallest_Index = i;

                }

            }

            

            if(smallest_Index != -1){

             Object[] res_arr = assign(curr, head, lists, smallest_Index);

             head = (ListNode)res_arr[0];

             curr = (ListNode)res_arr[1];

            }

            

           // print(head.val);

            

            smallest = Integer.MAX_VALUE;

            smallest_Index = -1;

        }

        

       if(curr != null) curr.next = null;

        

        return head;

    }

    

    public boolean hasAtleastOneVal(boolean[] arr)

    {

        for(boolean arr_val : arr)

        {

            if(arr_val){

                return true;

            }

        }

        

        return false;

    }

    

    public Object[] assign(ListNode curr, ListNode head, ListNode[] lists, int smallest_Index)

    {

        if(head == null && curr == null) {

            head = lists[smallest_Index];

            curr = head;

        }

        else if(curr != null){

            curr.next = lists[smallest_Index];

            curr = curr.next;

        }

        

       // print(head.val);

        lists[smallest_Index] = lists[smallest_Index].next;

        

        return new Object[]{head,curr};

    }

    

    public static void print(int v){

        System.out.println(v);

    }

    

    public static void main(String[] args){

    }

    

}
