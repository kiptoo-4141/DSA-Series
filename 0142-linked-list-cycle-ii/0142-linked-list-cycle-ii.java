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
public class Solution {
    // private int findIdx(int n, ListNode head){
    //     int count = 0;
    //     while(head != null){
    //         if(head.val == n){
    //             return count;
    //         }
    //         count++;
    //         head = head.next;
    //     }
    // }
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;

                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}