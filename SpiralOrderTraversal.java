class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    List<List<Integer>> levelOrder = new ArrayList<>();
    ArrayList<Integer> findSpiral(Node root) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        levelOrder(root,0);
        for(int i=0;i<levelOrder.size();i++){
            List <Integer> temp = levelOrder.get(i);
            if(i%2==1){
                for(int j=0;j<temp.size();j++){
                    result.add(temp.get(j));
                }
            }
            else{
                for(int j=temp.size()-1;j>=0;j--){
                    result.add(temp.get(j));
                }
            }
        }
        return result;
    }
    public void levelOrder(Node root,int index){
        if(root==null){
            return;
        }
        if(levelOrder.size()<=index){
            levelOrder.add(new ArrayList<>());
        }
        levelOrder.get(index).add(root.data);
        levelOrder(root.left,index+1);
        levelOrder(root.right,index+1);
    }
}