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
class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0 ){
            return head;
        }
        int n=0;
        ListNode dummy= new ListNode();
        dummy.next = head;
        
        ListNode curr= dummy;
        while(curr.next!=null){
            curr=curr.next;
            n++;
        }
        k=k%n;
        if(k==0){
            return head;
        }
        k=n-k;
        n=0;
        curr= dummy;
        while(curr.next!=null){
            curr=curr.next;
            n++;
            if(k==n){
                break;
            }
        }
        dummy=dummy.next;
        head=curr.next;
        ListNode temp=curr.next;
        curr.next=null;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=dummy;
        
        return head;
    }
}