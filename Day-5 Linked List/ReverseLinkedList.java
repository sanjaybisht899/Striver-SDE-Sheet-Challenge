class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}

class Solution {
    public ListNode reverseList(ListNode head){
        return reverslist(head);
    }
    ListNode reverslist(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode newhead = reverslist(head.next);
        head.next.next=head;
        head.next=null;
        return newhead;
    }
}
