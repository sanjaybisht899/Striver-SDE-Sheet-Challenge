class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result =new ArrayList<>();
        for(int i=0;i<n;i++){
            if(stack.isEmpty()){
                result.add(-1);
                stack.push(a[i]);
            }
            else{
                if(stack.peek()<a[i]){
                    result.add(stack.peek());
                    stack.push(a[i]);
                }
                else{
                    while(!stack.isEmpty() && stack.peek()>=a[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        result.add(-1);
                    }
                    else{
                        result.add(stack.peek());
                    }
                    stack.add(a[i]);
                }
            }
        }
        return result;
    }
}