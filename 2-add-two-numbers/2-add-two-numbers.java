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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0, sum;
        ListNode head = new ListNode(0);
        ListNode ln1 = l1, ln2 = l2, node = head;
        
        while (carry != 0 || ln1 != null || ln2 != null) {
            sum = carry; // reset sum to the value of carry
            
            if (ln1 != null) {
                sum += ln1.val;
                ln1 = ln1.next;
            }
            if (ln2 != null) {
                sum += ln2.val;
                ln2 = ln2.next;
            }
            
            carry = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next; 
        }
        return head.next;    
        
    }
}