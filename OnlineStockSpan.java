class StockSpanner {
    Stack <Pair> stack = new Stack<Pair>();
    int index=-1;
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        index++;
       if(stack.isEmpty()){
           stack.push(new Pair(index,price));
           return 1;
       }
        else{
            while(!stack.isEmpty() && stack.peek().data<=price){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.push(new Pair(index,price));
                return index+1;
            }
            else{
                int result=index-stack.peek().index;
                stack.push(new Pair(index,price));
                return result;
            }
        }
    }
}
class Pair{
    int index;
    int data;
    public Pair(int index,int data){
        this.index=index;
        this.data=data;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */