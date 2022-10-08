class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        int n=arr.length;
        List<List<Integer>> fourSum = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                int left=j+1;
                int right=n-1;
                while(left<right){
                    long sum=0;
                    sum+=arr[i];
                    sum+=arr[j];
                    sum+=arr[left];
                    sum+=arr[right];
                    //System.out.println(sum);
                    if(sum==target){
                        List <Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[left]);
                        temp.add(arr[right]);
                        if(set.add(temp)){
                            fourSum.add(new ArrayList<>(temp));
                        }
                        left++;
                        right--;
                    }
                    else if(target>sum){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return fourSum;
    }
}