import java.util.* ;
/************************************
	 
	 //Following is the class structure of the LinkedListNode class:
	 
	  class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;
		
		public LinkedListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

*****************************************/
public class IntersectionList {

	public static int findIntersection(LinkedListNode<Integer> headA, LinkedListNode<Integer> headB) {
		if(headA==null || headB==null){
            return -1;
        }
        
        LinkedListNode A = headA;
        LinkedListNode B = headB;
        
        int sizeA=1;
        int sizeB=1;
        while(A.next!=null){
            sizeA++;
            A=A.next;
        }
        while(B.next!=null){
            sizeB++;
            B=B.next;
        }
        A = headA;
        B = headB;
        if(sizeA>sizeB){
            int skip=sizeA-sizeB;
            while(skip!=0){
                A=A.next;
                skip--;
            }   
        }
        else if(sizeB>sizeA){
            int skip=sizeB-sizeA;
            while(skip!=0){
                B=B.next;
                skip--;
            } 
        }
        while(A!=null && B!=null){
            if(A==B){
                return (int)A.data;
            }
            A=A.next;
            B=B.next;
        }
        
        return -1;
	}
}