class JobSequencing
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,(a,b)->(b.profit-a.profit));
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i].deadline);
        }
        int deadlines[] = new int[max+1];
        
        for(int i=0;i<max+1;i++){
            deadlines[i]=-1;
        }
        
        int profit=0,count=0;
        
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>=1;j--){
                if(deadlines[j]==-1){
                    deadlines[j]=arr[i].id;
                    profit=profit+arr[i].profit;
                    count++;
                    break;
                }
            }
        }
        
       
        return new int[]{count,profit};
    }
}