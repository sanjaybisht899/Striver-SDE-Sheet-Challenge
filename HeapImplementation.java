public static void insert(int arr[], int value, int n){
        //adding space for the last element in the array
        n=n+1;
        arr[n]=value;
        int i=n;
        while(i>1){
            int parent=i/2;
            //finding the parent of the current node
            if(arr[parent]<arr[i]){
                swap(arr,parent,i);
                i=parent;
            }
            else{
                return;
            }
        }
    }


	• Delete


public static void delete(int arr[],int n){
        //here we will be deleting the 1st index
        arr[0]=arr[n];
        n=n-1;
        i=1;
        while(i<n){
            int left=arr[2*i];
            int right=arr[2*i+1];
            int larger = left>right?2*i:2*i+1;
            if(arr[larger]>arr[i]){
                swap(arr,i,larger);
                i=large;
            }
            else{
                return;
            }
        }
    }

    public static void heapify(int arr[], int n, int i){
        int largest=i;
        int l=2*i;
        int r=2*i+1;
        if(l<=n && a[l]>a[largest]){
            largest=l;
        }
        if(r<=n && a[r]>a[largest]){
            largest=r;
        }
        if(largest!=i){
            swap(arr,i,largest);
            heapify(arr, n, largest);
        }
     }
 
 
     public static void buildheap(int arr[], int n){
        for(int i=n/2;i>0;i--){
            heapify(arr, n, i);
        }
     }