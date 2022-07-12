class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		Sorted(s);
		return s;
	}
	public void Sorted(Stack <Integer> s){
	    if(!s.isEmpty()){
	        int temp=s.pop();
	        Sorted(s);
	        correctPos(s,temp);
	    }
	}
	public void correctPos(Stack <Integer> s, int temp){
	    if(s.isEmpty() || s.peek()<temp){
	        s.push(temp);
	    }
	    else{
	        int tmp=s.pop();
	        correctPos(s,temp);
	        s.push(tmp);
	    }
	}
}