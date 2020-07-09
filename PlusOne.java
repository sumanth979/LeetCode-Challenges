/*
abstractGiven a non-empty array of digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [1,9,9,9]
Output: [2,0,0,0]
Explanation: The array represents the integer 1999.
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int flag = 0;
        for (int i=len-1;i>=0;i--){
            digits[i]=digits[i]+1;
            if(digits[i]==10){
                digits[i]=0;
                if(i==0){
                    flag=1;
                }
            }
            else{
                break;
            }
        }
        if(flag==1){
            int[] res = new int[len+1];
            res[0]=1;
            for(int i=0;i<len;i++){
                res[i+1]=digits[i];
            }
            return res;
        }
        else {
          return digits;  
        }
    }
}