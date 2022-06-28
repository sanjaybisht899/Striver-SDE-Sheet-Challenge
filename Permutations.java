class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permute = new ArrayList<>();
        permutations(0,nums,permute);
        return permute;
    }
    public void permutations(int index,int arr[],List<List<Integer>> result){
        if(index==arr.length){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                temp.add(arr[i]);
            }
            result.add(new ArrayList<>(temp));
        }
        for(int i=index;i<arr.length;i++){
            swap(arr,i,index);
            permutations(index+1,arr,result);
            swap(arr,index,i);
        }
    }
    public void swap(int arr[],int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
}