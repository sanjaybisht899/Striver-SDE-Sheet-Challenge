class LFUCache {
    int capacity;
    int size;
    int min;
    //This will be total number of elements present in the cache
    HashMap<Integer,Node> map = new HashMap<>();
    //This will have the frequenct of all the elements 
    HashMap<Integer,DLinkedList> freq = new HashMap<>();
    public LFUCache(int c) {
        this.capacity=c;
        size=0;
        min=0;
    }
    public int get(int key) {
        
        Node temp = map.get(key);
        if(temp==null){
            return -1;
        }
        update(temp);
        return temp.value;
    }
    
    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if(map.containsKey(key)){
            Node temp = map.get(key);
            temp.value=value;
            update(temp);
        }
        else{
            size++;
            if(size>capacity){
                DLinkedList temp =freq.get(min);
                map.remove(temp.tail.prev.key);
                temp.remove(temp.tail.prev);
                size--;
            }
            min=1;
            Node temp=new Node(key,value);
            DLinkedList tmp = freq.getOrDefault(1,new DLinkedList());
            tmp.insert(temp);
            freq.put(1,tmp);
            map.put(key,temp);
        }
    }
    public void update(Node root){
        int currentFreq= root.frequency;
        DLinkedList temp = freq.get(currentFreq);
        temp.remove(root);
        
        if(currentFreq==min && temp.size==0){
            min++;
        }
        root.frequency++;
        DLinkedList tmp = freq.getOrDefault(root.frequency, new DLinkedList());
        tmp.insert(root);
        freq.put(root.frequency,tmp);
    }
    class Node{
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;
        public Node(int k, int v){
            key=k;
            value=v;
            frequency=1;
        }
    }
    class DLinkedList{
        int size;
        Node head;
        Node tail;
        public DLinkedList(){
            this.size=0;
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
        }
        public void insert(Node root){
            Node temp=head.next;
            head.next=root;
            root.next=temp;
            temp.prev=root;
            root.prev=head;
            this.size++;

        }
        public void remove(Node root){
            root.prev.next=root.next;
            root.next.prev=root.prev;
            this.size--;
        }
    
}
}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */