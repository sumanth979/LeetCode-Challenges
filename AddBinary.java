/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.
*/

class Solution {
    public String addBinary(String a, String b) {
        String result="";
        int sum=0;
        
        int i = a.length()-1;
        int j = b.length()-1;
        
        while(i>=0 || j>=0 || sum==1){
        
            // add the number to sum
            sum += ((i >= 0) ? a.charAt(i) - '0' : 0); 
            sum += ((j >= 0) ? b.charAt(j) - '0' : 0);
            
            result = sum%2 + result;
            sum = sum/2;
            i--;
            j--;
        }
        return result;
    }
}
