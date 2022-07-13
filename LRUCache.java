class LRUCache {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;
    HashMap<Integer,Node> map = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp=map.get(key);
            remove(temp);
            insert(new Node(temp.key,temp.value));
            return temp.value;
        }
        return -1;
    }
    public void remove(Node root){
        map.remove(root.key,root);
        root.next.prev=root.prev;
        root.prev.next=root.next;
    }
    
    public void insert(Node root){
        Node temp=head.next;
        head.next=root;
        root.next=temp;
        temp.prev=root;
        root.prev=head;
        map.put(root.key,root);
        
    }
    
    public void put(int key, int value) {
        Node tmp=new Node(key,value);
        
        if(map.containsKey(key)){
            Node temp=map.get(key);
            remove(temp);
            map.put(key,tmp);
        }
        else{
            if(map.size()==capacity){
                remove(tail.prev);
            }
        }
        insert(tmp);
    }
}
class Node{
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int k , int v){
        key=k;
        value=v;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */