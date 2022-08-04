class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int result=0;
        Queue Pair q = new LinkedList();
        q.offer(new Pair(0,root));
        int first=0;
        int last=0;
        while(!q.isEmpty()){
            int size=q.size();
            int maximum=q.peek().level;
            for(int i=0;isize;i++){
                int current=q.peek().level - maximum;
                TreeNode temp=q.peek().node;
                
                q.poll();
                
                if(i==0){
                    first=current;
                }
                if(i==size-1){
                    last=current;
                }
                
                if(temp.left!=null){
                    q.offer(new Pair(current2+1,temp.left));
                }
                if(temp.right!=null){
                    q.offer(new Pair(current2+2,temp.right));
                }
                
            }
            result=Math.max(result,last-first+1);
        }
        return result;
    }
}
class Pair{
    int level;
    TreeNode node;
    public Pair(int level, TreeNode node){
        this.level=level;
        this.node=node;
    }
}