/**
 * MergeKSortedList
 */
public class MergeKSortedList {

    
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue <Integer> pq = new PriorityQueue<>();
            for(ListNode list : lists){
                while(list!=null){
                    pq.add(list.val);
                    list=list.next;
                }
            }
            ListNode result= new ListNode(0);
            ListNode temp=result;
            while(pq.size()!=0){
                temp.next=new ListNode(pq.poll());
                temp=temp.next;
            }
            return result.next;
        }
    
}

Node mergeKList(Node[]arr,int k)
    {
        
        int interval=1;
        
        while(interval<k){
            for(int i=0; i + interval < k; i=i+interval*2){
                arr[i]= mergeList(arr[i], arr[i+interval]);
            }
            interval=interval*2;
        }
        
        return arr[0];
    }
    Node mergeList(Node list1, Node list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.data<list2.data){
            list1.next=mergeList(list1.next,list2);
            return list1;
        }
        else{
            list2.next=mergeList(list1,list2.next);
            return list2;
        }
    }