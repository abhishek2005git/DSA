/*You are given a 2D matrix mat[][] of size n×m. The task is to modify the matrix such that if mat[i][j] is 0, all the elements in the i-th row and j-th column are set to 0 and do it in constant space complexity.

Examples:

Input: mat[][] = [[1, -1, 1],
                [-1, 0, 1],
                [1, -1, 1]]
Output: [[1, 0, 1],
        [0, 0, 0],
        [1, 0, 1]]
Explanation: mat[1][1] = 0, so all elements in row 1 and column 1 are updated to zeroes.
Approach:- Use first row and column to track 0's. also use 2 additional variables to track the 1st row and 1st column's 0.

*/

class Solution {
    public void setMatrixZeroes(int[][] matrix) {
         boolean firstRow = false, firstCol = false;

    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix[0].length; j++)
        if (matrix[i][j] == 0) {
          if (i == 0) firstRow = true;
          if (j == 0) firstCol = true;
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }

    for (int i = 1; i < matrix.length; i++)
      for (int j = 1; j < matrix[0].length; j++)
        if (matrix[i][0] == 0 || matrix[0][j] == 0)
          matrix[i][j] = 0;

    if (firstRow)
      for (int j = 0; j < matrix[0].length; j++)
        matrix[0][j] = 0;

    if (firstCol)
      for (int i = 0; i < matrix.length; i++)
        matrix[i][0] = 0;
    }
}