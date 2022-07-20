class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            stack.push(i);
        }
        while(stack.size()!=1){
            int a=stack.pop();
            int b=stack.pop();
            if(M[a][b]==0){
                stack.push(a);
            }
            else{
                stack.push(b);
            }
        }
        int temp=stack.pop();
        if(isAllZero(temp,M,n) && isAllOne(temp,M,n)){
            return temp;
        }
        return -1;
    }
    boolean isAllZero(int index,int M[][], int n){
        for(int col=0;col<n;col++){
            if(col==index){
                continue;
            }
            if(M[index][col]!=0){
                return false;
            }
        }
        return true;
    }
    boolean isAllOne(int index,int M[][], int n){
        for(int col=0;col<n;col++){
            if(col==index){
                continue;
            }
            if(M[col][index]!=1){
                return false;
            }
        }
        return true;
    }
}