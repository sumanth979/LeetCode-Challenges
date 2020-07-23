/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

*/

class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[2];
        boolean flag=false;
        int k=0;
        
        //check whether the current number is equal to previous number or next number neglect it.
        //If not add to the result.
        for (int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                flag = true;
            }
            else if(i<nums.length-1 && nums[i]==nums[i+1]){
                flag = true; 
            }
            if(!flag){
                result[k]=nums[i];
                k++;
            }
            flag=false;
        }
        return result;
    }
}
