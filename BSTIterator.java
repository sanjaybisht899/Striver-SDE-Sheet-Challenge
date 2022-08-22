//optimal

class BSTIterator {
    Stack <TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp= stack.pop();
        pushAll(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public void pushAll(TreeNode root){
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }
}


//Naive
class BSTIterator {
    TreeNode root;
    List <Integer> result= new ArrayList<>();
    int curr=0;
    public BSTIterator(TreeNode root) {
        this.root=root;
        store(root,result);
    }
    
    public void store(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        store(root.left,result);
        
        result.add(root.val);
        
        store(root.right,result);
    }
    
    public int next() {
        curr++;
        return result.get(curr-1);
        
    }
    
    public boolean hasNext() {
        if(curr<result.size()){
            return true;
        }
        return false;
    }
}