/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // assign current Node to curNode.
        ListNode curNode = head;
        
        // assign prev Node to null.
        ListNode preNode = null;
        
        // Check the head node it self equal to value.
        // If so assign the head to next node (which means deleting the current node).
        while(curNode != null && curNode.val == val){
            head = curNode.next;
            curNode = head;
        }
        
        while (curNode != null) {
            // if curNode val is not equals to val then assign next node to current node and current node to prev node.
            if(curNode.val != val){
                preNode = curNode;
                curNode = curNode.next;
                //System.out.println(curNode.val+"-------"+preNode.val);
            } 
            
            // if curNode val is equals to val then assign current node next to prevoius node next. // means skipping the current node value.
            //assign the current node to previous node next.
            else {
                preNode.next = curNode.next;
                curNode = preNode.next;
                //System.out.println("-----"+curNode.val+"-------"+preNode.val);
            }
        }
        return head;
    }
}
