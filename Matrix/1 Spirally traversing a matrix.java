/*You are given a rectangular matrix mat[][] of size n x m, and your task is to return an array while traversing the matrix in spiral form.

Examples:

Input: mat[][] = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10] */

package DSA.Matrix;
import java.util.*;
class Solution {
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        int row = mat.length, col = mat[0].length;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        ArrayList <Integer> list = new ArrayList<>();
        
        while(left <= right && top <= bottom) {
            for(int i = left; i <= right; i++) 
                list.add(mat[top][i]);
             top++;
             
            for(int i = top; i <= bottom; i++) 
                list.add(mat[i][right]);
            right--;
            
            if(top <= bottom) {
                for(int i = right; i >= left; i--) 
                    list.add(mat[bottom][i]);
                bottom--;
            }
            
            if(left <= right) {
                for(int i = bottom; i >= top; i--) 
                    list.add(mat[i][left]);
                left++;
            }
        }
        return list;
    }
}