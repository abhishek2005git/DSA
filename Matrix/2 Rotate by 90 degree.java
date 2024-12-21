/*Given a square matrix mat[][] of size n x n. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space. 

Examples:

Input: mat[][] = [[1, 2, 3],
                [4, 5, 6]
                [7, 8, 9]]
Output: Rotated Matrix:
[3, 6, 9]
[2, 5, 8]
[1, 4, 7] 
Approach :- first transpose the matrix then reverse the columns in the matrix..
*/


package DSA.Matrix;
class Solution {
    static void reverse(int[][] mat, int col, int rowCount) {
        int start = 0;
        int end = rowCount - 1;
        while (start < end) {
            int temp = mat[start][col];
            mat[start][col] = mat[end][col];
            mat[end][col] = temp;
            start++;
            end--;
        }
    }
    static void rotateby90(int mat[][]) {
        int row = mat.length;
        int col  = mat[0].length;
        
        for(int i = 0; i < row - 1; i++) {
            for(int j = i + 1; j < row; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
             }
        }
        for(int i = 0; i < col; i++) {
            reverse(mat, i, row);
        }
    }
}

