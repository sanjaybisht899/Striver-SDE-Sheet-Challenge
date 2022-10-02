class Solution {
    public:
        double myPow(double x, int n) {
            double result=1.0;
            //Taking long long to prevent from overflow
            long long nn=n;
            //handling the negatives
            if(n<0){
                nn=-1*nn;
            }
            //till nn becomes 0
            while(nn!=0){
                //if it is odd we know that we cannot divide it into two parts so
                //reducting it by one to make it even
                //and we know that eventually it will become 1 so that we will get the result
                if(nn%2==1){
                    result*=x;
                    nn-=1;
                }
                //if it is even we will just incement the double the x value.
                else{
                    x*=x;
                    nn/=2;
                }
            }
            //handling negatives
            if(n<0){
                return 1.0/result;
            }
            return result;
        }
    };