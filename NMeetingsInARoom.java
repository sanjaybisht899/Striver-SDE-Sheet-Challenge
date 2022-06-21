import java.util.*;
class NMeetingsInARoom 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        if(n==1){
            return 1;
        }
        
        Pair arr[] = new Pair[n];
        for(int i=0;i<n;i++){
            arr[i] = new Pair(start[i],end[i]);
        }
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(final Pair s1, final Pair s2) {
              return s1.right < s2.right ? -1 : 1;
            }
        });
        
        int prev=arr[0].right;
        int count=1;
        for(int i=1;i<n;i++){
            if(arr[i].left>prev){
                prev=arr[i].right;
                count++;
            }
        }
        
        return count;
    }
    static class Pair{
        int left;
        int right;
        public Pair(int left, int right){
            this.left=left;
            this.right=right;
        }
    }
}