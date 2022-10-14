
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
public class LinkedListCycleTwo {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null &&  fast.next!=null && slow.next!=null){
            slow=slow.next;
            fast=fast.next;
            if(fast.next!=null){
                fast=fast.next;
                if(fast==slow){
                    break;
                }
            }
        }
        if(fast==null || fast.next==null){
            return null;
        }
        fast=head;
        while(fast!=null &&  fast.next!=null){
            if(fast==slow){
                return fast;
            }
            slow=slow.next;
            fast=fast.next;
            
        }
        return null;
    }
}