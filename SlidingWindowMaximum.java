class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n=arr.length;
        ArrayList<Integer> result= new ArrayList<>();
        ArrayDeque <Integer> q= new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(!q.isEmpty() && arr[q.getFirst()]<=arr[i]){
                q.removeFirst();
            }
            q.addFirst(i);
        }
        for(int i=k;i<n;i++){
            result.add(arr[q.getLast()]);
            while(!q.isEmpty() && q.getLast()<=i-k){
                q.removeLast();
            }
            while(!q.isEmpty() && arr[q.getFirst()]<=arr[i]){
                q.removeFirst();
            }
            q.addFirst(i);
        }
        result.add(arr[q.getLast()]);
        
        int[] result1 = result.stream().mapToInt(i->i).toArray();
        return result1;
    }
}