class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> left= new ArrayList<>();
      left(root,left,0);
      return left;
    }
    void left(Node root,ArrayList<Integer> left, int level){
        if(root==null){
            return;
        }
        if(left.size()==level){
            left.add(root.data);
        }
        left(root.left,left,level+1);
        left(root.right,left,level+1);
    }
}