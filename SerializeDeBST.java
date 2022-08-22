/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    String ans="";
    public String serialize(TreeNode root) {
        preOrder(root);
        //System.out.println(ans);
        return ans;
    }
    
    public void preOrder(TreeNode root){
        if(root==null){
            ans+=","+"*";
            return;
        }
        ans+=","+root.val;
        preOrder(root.left);
        preOrder(root.right);
        
    }

    // Decodes your encoded data to tree.
    int index=1;
    public TreeNode deserialize(String data) {
        String []result = data.split(",");
        
        TreeNode root =null;
        root=fill(root,result);
        return root;
    }
    public TreeNode fill(TreeNode root,String []result){
        
        if(index>=result.length  || result[index].equals("*")){
            index++;
            return null;
        }
        Integer num=Integer.valueOf(result[index]);
        //System.out.println(num);
        TreeNode temp = new TreeNode(num.intValue());
        index++;
        temp.left=fill(temp.left,result);
        
        temp.right=fill(temp.right,result);
        
        
        return temp;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));