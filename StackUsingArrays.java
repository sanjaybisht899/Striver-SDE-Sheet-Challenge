			Using Arrays
			class Stack{
			    int capacity;
			    int top;
			    int S[];
			    Stack(int capacity){
			        this.capacity=capacity;
			        S=new int[capacity];
			        top=-1;
			    }
			    public boolean isempty(){
			        if(top==-1){
			            return true; 
			        }
			        return false;
			    }
			    public boolean isfull(){
			        if(capacity-1==top){
			            return true;
			        }
			        return false;
			    }
			    public void push(int data){
			        if(isfull()){
			            System.out.println("Array is Full");
			        }
			        else{
			            top++;
			            S[top]=data;
			        }
			    }
			    public int pop(){
			        if(isempty()){
			            return -1;
			        }
			        int temp=arr[top];
			        top--;
			        return temp; 
			    }
			    public void print(){
			        if(isempty()){
			            System.out.println("Array is Empty");
			        }
			        else{
			            for(int i=0;i<=top;i++){
			                System.out.print(S[i]+" ");
			            }
			        }
			    }
			}
			
			Using Linked List
			class Node{
			    int data;
			    Node next;
			}
			class Stack{
			    int top;
			    int capacity;
			    Node head;
			    Stack(){
			        capacity=10;
			        top=-1;
			    }
			    public boolean isempty(){
			        if(top==-1){
			            return true; 
			        }
			        return false;
			    }
			    public boolean isfull(){
			        if(capacity-1==top){
			            return true;
			        }
			        return false;
			    }
			    public void push(int data){
			        if(isfull()){
			            System.out.println("Array is Full");
			        }
			        else{
			            Node temp=new Node();
			            temp.data=data;
			            temp.next=null;
			            if(isempty()){
			                head=temp;
			                top++;
			            }
			            else{
			                temp.next=head;
			                head=temp;
			                top++;
			            }
			        }
			    }
			    public int pop(){
			        if(isempty()){
			            return -1;
			        }
			        int temp=head.data;
			        head=head.next!=null?head.next:null;
			        top--;
			        return temp; 
			    }
			    public void print(){
			        if(isempty()){
			            System.out.println("Array is Empty");
			        }
			        else{
			            Node curr=head;
			            while(curr!=null){
			                System.out.print(curr.data+" ");
			                curr=curr.next;
			            }
			        }
			    }
			}
