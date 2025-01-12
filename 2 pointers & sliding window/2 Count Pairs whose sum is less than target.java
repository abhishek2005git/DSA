/*
 Given an array arr[] and an integer target. You have to find the number of pairs in the array whose sum is strictly less than the target.

Examples:

Input: arr[] = [7, 2, 5, 3], target = 8
Output: 2
Explanation: There are 2 pairs with sum less than 8: (2, 5) and (2, 3). 
Input: arr[] = [5, 2, 3, 2, 4, 1], target = 5
Output: 4
Explanation: There are 4 pairs whose sum is less than 5: (2, 2), (2, 1), (3, 1) and (2, 1).
 */
import java.util.*;

 class Solution {
    int countPairs(int arr[], int target) {
        int l  = 0, r = arr.length - 1, count = 0;
        Arrays.sort(arr);
        while(l < r) {
            if(arr[l] + arr[r] < target) {
                count += r - l;
                l++;
            }
            else {
                r--;
            }
        }
        return count;
    }
}