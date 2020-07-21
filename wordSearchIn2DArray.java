/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 

Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(word.length()==1 || isCharInADJ(board, i, j, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isCharInADJ(char[][]board, int row, int col, String word, int pos){
        
        // check current position is equal to word length, if so return true.
        if(pos>=word.length()){
                return true;
        }
        
        // check current position is equal to word character at postion.
        if(board[row][col] != word.charAt(pos)) {
            return false;
        }
        
        // assign the value to temp to replace the value to help for backtrack.
        char tmp = board[row][col];
        board[row][col] = '0';
        boolean result = false;
        
        As given validate the 4 adjacent positions.
        if(row < board.length - 1) {
            result = isCharInADJ(board, row + 1, col, word, pos + 1);
        }
        
        if(!result && row > 0) {
            result = isCharInADJ(board, row - 1, col, word, pos + 1);
        }
        
        if(!result && col < board[0].length - 1) {
            result = isCharInADJ(board, row, col + 1, word, pos + 1);
        }
        
        if(!result && col > 0) {
            result = isCharInADJ(board, row, col - 1, word, pos + 1);
        }
        
        //replace the value back.
        board[row][col] = tmp;
        
        return result;
    }
}
