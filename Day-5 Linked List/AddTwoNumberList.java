class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0;
        ListNode dummy= new ListNode();
        ListNode copy= dummy;

        while(l1!=null || l2!=null || sum!=0){
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            ListNode temp=new ListNode();
            temp.val=sum%10;
            copy.next=temp;
            copy=temp;
            sum/=10;
        }
        return dummy.next;
    }
}