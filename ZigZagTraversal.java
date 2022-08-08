
class Solution {
    List<List<Integer>> levelOrder = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List <Integer>> result = new ArrayList<>();
		levelOrder(root,0);
		for(int i=0;i<levelOrder.size();i++){
		    List <Integer> temp = levelOrder.get(i);
		    if(i%2==0){
		        result.add(temp);
		    }
		    else{
                result.add(new ArrayList<>());
		        for(int j=temp.size()-1;j>=0;j--){
		            result.get(result.size()-1).add(temp.get(j));
		        }
		    }
		}
		return result;

    }
    public void levelOrder(TreeNode root,int index){
		if(root==null){
		    return;
		}
		if(levelOrder.size()<=index){
		    levelOrder.add(new ArrayList<>());
		}
		levelOrder.get(index).add(root.val);
		levelOrder(root.left,index+1);
		levelOrder(root.right,index+1);
    }
}