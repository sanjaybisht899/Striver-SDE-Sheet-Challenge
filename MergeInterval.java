import java.util.*;
class MergeInterval{
    
    public static void main(String[] args) {
        System.out.println(true);
        int arr[][] = {{1, 4}, {3, 5}, {6, 8}, {10, 12}, {8, 9},{1,3},{0,6}};
        
        Arrays.sort(arr, new Comparator<int[]>() {
            
            @Override              
            // Compare values according to columns
            public int compare(final int[] entry1, 
                               final int[] entry2) {
    
              // To sort in descending order revert 
              // the '>' Operator
              if (entry1[0] > entry2[0])
                  return 1;
              else
                  return -1;
            }
          });
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0]+"  "+arr[i][1]);
        }
        
        int start=arr[1][0];
        int end=arr[1][0];
        for (int i = 1; i < arr.length; i++) {
            if(start>arr[i][1]){
                start=arr[i][0];
                end=arr[i][1];    
            }
            
        }
    }
}