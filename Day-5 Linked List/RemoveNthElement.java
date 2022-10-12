public class RemoveNthElement {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev=null;
        ListNode curr= head;
        int count = 1;
        while(curr.next !=null){
            curr=curr.next;
            count++;
        }
        n=count-n;
        count=1;
        if(n==0){
            head=head.next;
            return head;
        }
        else{
            curr=head;
            while(count != n){
                curr=curr.next;
                count++;
            }
            curr.next=curr.next.next;
            return head;
        }
    }
}