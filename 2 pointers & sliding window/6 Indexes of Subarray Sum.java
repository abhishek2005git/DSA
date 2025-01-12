/*
 Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.

Note: If no such array is possible then, return [-1].

Examples:

Input: arr[] = [1, 2, 3, 7, 5], target = 12
Output: [2, 4]
Explanation: The sum of elements from 2nd to 4th position is 12.
Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
Output: [1, 5]
Explanation: The sum of elements from 1st to 5th position is 15.
 */

 import java.util.*;
 
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int n = arr.length;
        int l = 0, r = 0, sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        while(r < n) {
            sum += arr[r];
            
            while(sum > target && l < r) { // shrinking the window
                sum -= arr[l];
                l++;
            }
            
            if(sum == target) {
                list.add(l+1);
                list.add(r+1);
                return list;
            }
            
            r++; // expanding the window 
        }
        list.add(-1);
        return list;
    }
}