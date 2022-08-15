class Solution {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Queue <Node> q = new LinkedList<>();
        ArrayList<Node> arr = new ArrayList<>();
        
        q.add(root);
        int tmp=1;
        while(!q.isEmpty()){
            Node temp = q.poll();
            arr.add(temp);
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
            if()
            
        }
        for(int i=1;i<arr.size();i++){
            arr.get(i-1).next=arr.get(i);
        }
        Node temp = root;
        while(temp.right!=null){
            temp.next=null;
            temp=temp.right;
        }
        return root;
    }
}