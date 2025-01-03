/*
 Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

Examples:

Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
Output: 6
Explanation: The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.
 */
import java.util.*;

 class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        if(arr.length == 0) return 0;
        int max_length = 0;
        HashSet <Integer> set = new HashSet<>();
        for(int num : arr) 
            set.add(num);
        
        for(int num : arr) {
            if(!set.contains(num - 1)) {
                int curr_num = num;
                int curr_length = 1;
                while(set.contains(curr_num + 1)) {
                    curr_num++;
                    curr_length++;
                }
                max_length = Math.max(max_length , curr_length);
            }
        }
        return max_length;
    }
}