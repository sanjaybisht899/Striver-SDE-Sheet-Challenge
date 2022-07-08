import java.util.*;

import javax.swing.text.DefaultStyledDocument.ElementSpec;
/**
 * FindMedianfromDataStream
 */
class Solution{
    //By Default Min Heap in Java
    //root element will be minimum
    PriorityQueue <Integer> minheap = new PriorityQueue<>();
    //root element will be maximum
    PriorityQueue <Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    int n=0;
    public void addNum(int num) {
        if(n==0){
            minheap.add(num);
        }
        else{
            if(num>minheap.peek()){
                minheap.add(num);
            }
            else{
                maxheap.add(num);
            }
        }
        n++;
        balanace();
    }
    public void balanace(){
        if(maxheap.size() > minheap.size()){
            minheap.add(maxheap.poll());
        }
        else if(maxheap.size()+1 < minheap.size()){
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(n%2==0){
            return (minheap.peek()+maxheap.peek())/2.0;
        }
        return minheap.peek()/1.0;
    }
}
public class FindMedianfromDataStream {
    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        sol.addNum(1);
        sol.addNum(2);
        sol.addNum(3);
        sol.addNum(4);
        System.out.println(sol.maxheap);
        System.out.println(sol.minheap);
        System.out.println(sol.findMedian());

    }
}