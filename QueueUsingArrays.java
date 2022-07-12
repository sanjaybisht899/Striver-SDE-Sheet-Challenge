			package Queue;
			class Queue{
			    int capacity;
			    int front;
			    int rear;
			    int arr[];
			    public Queue(int capacity){
			        this.capacity=capacity;
			        arr=new int[capacity];
			        front=-1;
			        rear=-1;
			    }
			    void enqueue(int data){
			        if(!isfull()){
			            if(rear==-1){
			                front++;
			            }
			            rear++;
			            arr[rear]=data;
			        }
			    }
			    int dequeue(){
			        if(isempty()){
			            return -1;
			        }
			        int temp=arr[front];
			        for(int i=0;i<rear;i++){
			            arr[i]=arr[i+1];
			        }
			        if(front==rear){
			            front=-1;
			            rear=-1;
			        }
			        else{
			            rear=rear-1;
			        }
			        return temp;
			    }
			    boolean isempty(){
			        if(front==-1){
			            return true;
			        }
			        return false;
			    }
			    boolean isfull(){
			        if(rear+1==capacity){
			            return true;
			        }
			        return false;
			    }
			    void content(){
			        if(isempty()){
			           System.out.println("Queue Is Empty"); 
			        }
			        else{
			            for (int i = rear; i >= 0 ; i--) {
			                System.out.print(arr[i]+" ");
			            }
			        }
			    }
			    
			}
			public class Queue_Using_Array {
			    public static void main(String[] args) {
			        Queue q= new Queue(2);
			        q.enqueue(1);
			        q.enqueue(2);
			        System.out.println(q.dequeue());
			        System.out.println(q.dequeue());
			        q.enqueue(3);
			        
			        q.content();
			    }
			    
			}
