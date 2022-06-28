class PermutationSequence {
    public String getPermutation(int n, int k) {
        int fact=1;
        ArrayList<Integer> number = new ArrayList<>();
        
        for(int i=1;i<n;i++){
            fact=fact*i;
            number.add(i);
        }
        
        number.add(n);
        
        String ans = "";
        
        k=k-1;
        
        while(true){
            ans = ans + "" + number.get(k/fact);
            
            number.remove(k/fact);
            
            if(number.size()==0){
                break;
            }
            
            k=k%fact;
            
            fact=fact/number.size();
        }
        return ans;
    }
}