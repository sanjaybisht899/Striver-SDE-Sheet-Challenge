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
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
            }
        }
        ListNode prev= null;
        ListNode curr=slow;
        while(curr!=null){
            ListNode temp= curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        
        fast=head;
        while(prev!=null){
            //System.out.println(fast.val + " " + prev.val);
            if(fast.val!=prev.val){
                return false;
            }
            fast=fast.next;
            prev=prev.next;
        }
        
        return true;
    }
}