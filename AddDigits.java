/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
Follow up:
  Could you do it without any loop/recursion in O(1) runtime?

Hint #1  
  A naive implementation of the above process is trivial. Could you come up with other methods?
Hint #2  
  What are all the possible results?
Hint #3  
  How do they occur, periodically or randomly?
Hint #4  
  You may find this Wikipedia article useful.
*/

class Solution {
    public int addDigits(int num) {
        while(num>=10){
            int temp=0;
            while(num!=0){
                temp=temp+num%10;
                num=num/10;
            }
            num=temp;
        }
        return num;
    }
}
