/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3383/

*/

class Solution {
    
    public int numofneighbour(int mat[][],  
                            int i, int j, int R, int C)  
    { 
          
        int count = 0; 

        if (i > 0 && mat[i - 1][j] == 1) 
            count++; 

        if (j > 0 && mat[i][j - 1] == 1) 
            count++; 

        if (i < R - 1 && mat[i + 1][j] == 1) 
            count++; 
        
        if (j < C - 1 && mat[i][j + 1] == 1) 
            count++; 
      
        return count; 
    } 
    
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int R = grid.length;
        int C = grid[0].length;
        
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]==1){
                    perimeter += (4 -  
                    numofneighbour(grid, i, j, R, C));
                }
            }
        }
        return perimeter;
    }
}

