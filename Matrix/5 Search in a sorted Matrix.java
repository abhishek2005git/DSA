/*Given a strictly sorted 2D matrix mat[][] of size n x m and a number x. Find whether the number x is present in the matrix or not.
Note: In a strictly sorted matrix, each row is sorted in strictly increasing order, and the first element of the ith row (i!=0) is greater than the last element of the (i-1)th row.

Examples:

Input: mat[][] = [[1, 5, 9], [14, 20, 21], [30, 34, 43]], x = 14
Output: true
Explanation: 14 is present in the matrix, so output is true.

Approach:- Easy problem if we just keep the track of row and column of element which mid points in every iteration and check for the condition of BS..
*/
package DSA.Matrix;

class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        
        int low = 0, high = m * n - 1;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;
            
            if(mat[row][col] == x)
                return true;
            else if(mat[row][col] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}