/*
Given a row-wise sorted 2D matrix mat[][] of size n x m and an integer x, find whether element x is present in the matrix.
Note: In a row-wise sorted matrix, each row is sorted in itself, i.e. for any i, j within bounds, mat[i][j] <= mat[i][j+1].

Examples :
Input: mat[][] = [[3, 4, 9],[2, 5, 6],[9, 25, 27]], x = 9
Output: true
Explanation: 9 is present in the matrix, so the output is true. 
Thoughts: Easy problem just apply BS on each row, thus keep track of current row and check for condition.

*/
package DSA.Matrix;

class Solution {
    public boolean searchRowMatrix(int[][] mat, int x) {
        int n = mat.length;
        
        for(int row = 0; row < n; row++) {
            int low = 0, high = mat[0].length-1;
            while(low <= high) {
                int mid = (low + high) / 2;
                
                if(mat[row][mid] == x)
                    return true;
                else if(mat[row][mid] < x)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }
}