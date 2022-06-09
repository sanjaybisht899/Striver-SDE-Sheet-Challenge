import java.sql.Array;
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
        
        ArrayList <ArrayList<Integer>> a = new ArrayList<>(); 
        int start=arr[0][0];
        int end=arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if(end>=arr[i][0]){

                end=Math.max(end,arr[i][1]);    
            }
            else{
                ArrayList <Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end);
                start=arr[i][0];
                end=arr[i][1];
                a.add(temp);
            }
        }
        ArrayList <Integer> temp = new ArrayList<>();
        temp.add(start);
        temp.add(end);
        a.add(temp);
        
        int result[][] = new int[a.size()][2];
        for (int i = 0; i < a.size(); i++) {
            result[i][0]=a.get(i).get(0);
            result[i][1]=a.get(i).get(1);
        }
       
        
    }
}