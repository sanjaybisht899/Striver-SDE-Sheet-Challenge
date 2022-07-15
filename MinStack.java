Easy 
class MinStack {
    Stack<Pair> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Pair(val,val));
        }
        else{
            stack.push(new Pair(val,Math.min(val,stack.peek().min)));
        } 
    }
    
    public void pop() {
        Pair temp = stack.pop();
    }
    
    public int top() {
        Pair temp = stack.peek();
        return temp.data;
    }
    
    public int getMin() {
        Pair temp = stack.peek();
        return temp.min;
    }
}
class Pair{
    int data;
    int min;
    public Pair(int data,int min){
        this.data=data;
        this.min=min;
    }
}

Optimized

class MinStack {
    Stack<Long> stack = new Stack<>();
    Long min;
    public MinStack() {
        min=Long.MAX_VALUE;
    }
    
    public void push(int val) {
        Long x= Long.valueOf(val);
        if(stack.isEmpty()){
            min=x;
            stack.push(x);
        }
        else{
            if(x<min){
                stack.push(2*x - min);
                min=x;
            }
            else{
                stack.push(x);
            }
        } 
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        Long temp=stack.pop();
        if(temp<min){
            min=2*min-temp;
        }
    }
    
    public int top() {
        Long temp=stack.peek();
        if(temp<min){
            return min.intValue();
        }
        return temp.intValue();
    }
    
    public int getMin() {
        return min.intValue();
    }
}