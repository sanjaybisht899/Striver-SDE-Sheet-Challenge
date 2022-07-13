class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int []left = new int[n];
        int []right= new int [n];
        
        left(left,heights,n);
        right(right,heights,n);
        
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,(right[i]-left[i]-1)*heights[i]);
        }
        
        return max;
    }
    void left(int []left, int []heights, int n){
        Stack <Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            if(s.isEmpty()){
                left[i]=-1;
            }
            else{
                if(heights[s.peek()]<heights[i]){
                    left[i]=s.peek();
                }
                else{
                    while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                        s.pop();
                    }
                    if(s.isEmpty()){
                        left[i]=-1;
                    }
                    else{
                        left[i]=s.peek();
                    }
                }
            }
            s.push(i);
        }
    }
    void right(int []right, int []heights, int n){
        Stack <Integer> s = new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(s.isEmpty()){
                right[i]=n;
            }
            else{
                if(heights[s.peek()]<heights[i]){
                    right[i]=s.peek();
                }
                else{
                    while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                        s.pop();
                    }
                    if(s.isEmpty()){
                        right[i]=n;
                    }
                    else{
                        right[i]=s.peek();
                    }
                }
            }
            s.push(i);
        }
    }
}