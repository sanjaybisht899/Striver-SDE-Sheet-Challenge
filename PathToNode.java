public class Solution {
    public int[] solve(TreeNode A, int B) {
        ArrayList<Integer> arr = new ArrayList<>();
        find(A,B,arr);
        Object a[]= arr.toArray();
        int result[] = new int[a.length];
        for (int i=0;i<a.length;i++) {
            result[i]=Integer.valueOf(a[i].toString()).intValue();
        }
        return result;
    }
    public boolean find(TreeNode A,int B,ArrayList<Integer> arr){
        if(A==null){
            return false;
        }
        arr.add(A.val);
        if(A.val==B){
            return true;
        }
        if(find(A.left,B,arr) ||  find(A.right,B,arr)){
            return true;
        }
        arr.remove(arr.size()-1);
        return false;
    }
}