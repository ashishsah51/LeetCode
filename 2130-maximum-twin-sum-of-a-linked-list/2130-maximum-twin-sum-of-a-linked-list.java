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
    int len;
    public int pairSum(ListNode head) {
        len = 0;
        ListNode rev = reverse(head);
        len = len / 2;
        int res = 0;
        while(len > 0) {
            res = Math.max(head.val + rev.val, res);
            head = head.next;
            rev = rev.next;
            len--;
        }
        return res;
    }
    private ListNode reverse(ListNode head) {
        ListNode rev = null;
        while(head != null) {
            len++;
            ListNode tmp = new ListNode(head.val);
            head = head.next;
            tmp.next = rev;
            rev = tmp;
        }
        return rev;
    }
}