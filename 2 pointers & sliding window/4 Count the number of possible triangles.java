/*
 Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as lengths of three sides of the triangle. 

A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.

Examples:

Input: arr[] = [4, 6, 3, 7]
Output: 3
Explanation: There are three triangles possible [3, 4, 6], [4, 6, 7] and [3, 6, 7]. Note that [3, 4, 7] is not a possible triangle.  
Input: arr[] = [10, 21, 22, 100, 101, 200, 300]
Output: 6
Explanation: There can be 6 possible triangles: [10, 21, 22], [21, 100, 101], [22, 100, 101], [10, 100, 101], [100, 101, 200] and [101, 200, 300]
 */
import java.util.*;

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        int n = arr.length, count = 0;
        Arrays.sort(arr);
        for(int r = n - 1; r >= 2; r--) {
            int l = 0;
            int i =  r - 1;
            
            while(l < i) {
                if(arr[l] + arr[i] <= arr[r]) {
                    l++;
                }
                else {
                    count += (i-l);
                    i--;
                }
            }
        }
        return count;
    }
}