/**
 * AddTwoNumberList
 */
import java.util.*;
public class AddTwoNumberList {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode curr=head;
            int carry=0;
            int sum=0;
            while(l1!=null && l2!=null){
                sum=l1.val+l2.val+carry;
                carry=sum/10;
                sum=sum%10;
                l1=l1.next;
                l2=l2.next;
                curr.next=new ListNode(sum);
                curr=curr.next;
                
            }
            while(l2 == null && l1!=null){
                sum=l1.val+carry;
                carry=sum/10;
                sum=sum%10;
                l1=l1.next;
                curr.next=new ListNode(sum);
                curr=curr.next;
            }
            while(l1==null && l2!=null){
                sum=l2.val+carry;
                carry=sum/10;
                sum=sum%10;
                l2=l2.next;
                curr.next=new ListNode(sum);
                curr=curr.next;
            }
            if(carry!=0){
                curr.next=new ListNode(carry);
                curr=curr.next;
            }
            
            
            return head.next;
        }
    }

}