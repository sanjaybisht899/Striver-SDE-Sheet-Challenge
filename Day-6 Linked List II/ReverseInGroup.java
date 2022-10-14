class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        
        ListNode groupprev=dummy;
        
        while(true){
            ListNode kth = getKth(groupprev,k);
            if(kth==null){
                break;
            }
            ListNode groupnext= kth.next;
            
            //Reversing the group
            
            ListNode prev= kth.next;
            ListNode curr= groupprev.next;
            
            while(curr!=groupnext){
                ListNode temp = curr.next;
                curr.next = prev;
                prev= curr;
                curr= temp;
            }
            ListNode tmp = groupprev.next;
            groupprev.next = kth; 
            groupprev = tmp;
            
        }
        
        return dummy.next;
    }
    public ListNode getKth(ListNode node, int k){
        while(node!=null && k>0){
            node=node.next;
            k=k-1;
        }
        return node;
    }
}