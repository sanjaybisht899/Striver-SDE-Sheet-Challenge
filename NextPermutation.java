class Solution {
    public void nextPermutation(int[] arr) {
        int i =arr.length-2;
        //Finding the decreasing point of the array.
		while(i>=0 && arr[i]>=arr[i+1] ){
		    i--;
		}
        //System.out.println(i);
		if(i>=0){
            //Finding the element greater than i from the last
		    int j=arr.length-1;
		    while (j>=0 &&  arr[i]>=arr[j]){
		        j--;
		    }
            //Replace the element
		    swap(i,j,arr);
		}
        //reverse the other elements 
        reverse(arr,i+1,arr.length-1);
    }
    void swap(int x,int y,int arr[]){
	    int temp = arr[x];
	    arr[x]=arr[y];
	    arr[y]=temp;
	}
	void reverse(int arr[],int left , int right){
	    while(left<right){
	        swap(left,right,arr);
	        left++;
	        right--;
	    }
	}

}