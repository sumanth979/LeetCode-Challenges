/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // To store the resulted array
        List<List<Integer>> result = new ArrayList<>();

        // To store distinct elements
        HashSet<Integer> set=new HashSet<>();

        //Sorting arrays
        Arrays.sort(nums);
        if(nums.length<3){
            return result;
        }
        
        set.add(nums[0]);
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            while(j<k){
                if(k<nums.length-1 && nums[k]==nums[k+1]){
                    k--;
                    continue;
                }
                if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                } else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    if(!result.contains(temp)){
                        result.add(temp);
                    }
                    j++;
                    k--;
                }
            }
        }
        return result;
    }
}