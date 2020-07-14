/*
Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.

Example 1:

Input: hour = 12, minutes = 30
Output: 165
Example 2:

Input: hour = 3, minutes = 30
Output: 75
Example 3:

Input: hour = 3, minutes = 15
Output: 7.5
Example 4:

Input: hour = 4, minutes = 50
Output: 155
Example 5:

Input: hour = 12, minutes = 0
Output: 0
 
Constraints:

1 <= hour <= 12
0 <= minutes <= 59
Answers within 10^-5 of the actual value will be accepted as correct.
*/

class Solution {
    public double angleClock(int hour, int minutes) {
        // Only case where the angle becomes zero.
        if (minutes==0 && hour==12){
            return 0;
        }
        
        // Assign hours value to zero when hours is 12.
        if(hour==12){
            hour=0;
        }
        
        // Calculate the angle difference between hours and minute/5.
        // Logic for every 1 value changes is equal to 30 degree.
        double tempDiff= Math.abs((hour-minutes/5)) * 30;
        
        // Every one minute rotates hours clock 0.5 degree.
        // Calculate the hours hand rotation.
        double hrTominDiff = 0.5*minutes;
        
        //each minute means 6 degress of rotation.
        double minDiff = (minutes%5)*6;
        
        if(hour < minutes/5){
            tempDiff = tempDiff - hrTominDiff + minDiff;
        }else{
            tempDiff = tempDiff + hrTominDiff - minDiff;
        }
        
        tempDiff= Math.abs(tempDiff);
        
        //Calculate small Angle
        if(tempDiff>360-tempDiff){
            tempDiff = 360-tempDiff;
        }
        return tempDiff;
    }
}
 
