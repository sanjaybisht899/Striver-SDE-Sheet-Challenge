/**
 * MergeSortedList
 */
public class MergeSortedList {

    public static LinkedListNodeInteger sortTwoLists(LinkedListNodeInteger list1, LinkedListNodeInteger list2) {
		if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.datalist2.data){
            list1.next=sortTwoLists(list1.next, list2);
            return list1;
        }
        else{
            list2.next=sortTwoLists(list1,list2.next);
             return list2;
        }
	}
}