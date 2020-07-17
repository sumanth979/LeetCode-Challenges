/*
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]

*/

class Solution {
    public double myPow(double x, int n) {
        //Intializing result to 1.
        double result=1;
        
        // if the number is 0 or 1 return the value directly.
        if(x==0 || x==1){
            return x;
        }
        
        // if the power is 0 return 1.
        if(n==0){
            return 1;
        }
        
        //if the power is 1 return number.
        if(n==1){
            return x;
        }
        
        // if the power is less than 0 then change the number to 1/number.
        if(n<0){
            // if power equals to limit then -power won't work as it is out of bounds.
            if(n==-2147483648){
                n+=1;
                // recursive approach
                return 1/x*myPow(1/x, -n);
            }
            else{
                // recursive approach
                return myPow(1/x, -n);
            }
        }
        // recursive approach
        result=myPow(x*x, n/2);
        if(n%2==1){
            result*=x;
        }
        return result;
    }
}
