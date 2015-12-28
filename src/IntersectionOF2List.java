
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
 * Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.

 */
public class IntersectionOF2List {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA,B= headB;
        int lenA=0,lenB=0;
        
        
        
        while(A != null){
            A= A.next;
            lenA++;
        }
        
        while(B != null){
            B= B.next;
            lenB++;
        }
        
        int diff = lenA - lenB;
        
        if(diff < 0){
            while(diff != 0){
                diff+=1;
                headB = headB.next;
            }
        }
        else if(diff > 0){
            while(diff != 0){
                diff-=1;
                headA = headA.next;
            }
        }
        
        while(headA != null && headB != null && headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        if(headA == null || headB == null || headA != headB) return null;
        else return headA;
        
    }
}