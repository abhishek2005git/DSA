/*Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in increasing order and a number x, the task is to find whether element x is present in the matrix.

Examples:

Input: mat[][] = [[3, 30, 38],[20, 52, 54],[35, 60, 69]], x = 62
Output: false
Explanation: 62 is not present in the matrix, so output is false.

Approach:- In this problem we have to keep track of row and column. Initialize row = 0 and column = n-1, if currValue < x then row++ else col-- (coz both row , col is sorted)
*/
package DSA.Matrix;

class Solution {
    public static boolean matSearch(int mat[][], int x) {
        int m = mat.length;
        int n = mat[0].length;
        int row = 0, col = n - 1;
        
        while(row < m && col >=0) {
            if(mat[row][col] == x)
                return true;
            else if(mat[row][col] < x)
                row++;
            else
                col--;
        }
        return false;
    }
}