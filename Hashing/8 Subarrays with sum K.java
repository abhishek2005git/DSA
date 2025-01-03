/*
 Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number k.

Examples:

Input: arr = [10, 2, -2, -20, 10], k = -10
Output: 3
Explaination: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.
Input: arr = [9, 4, 20, 3, 10, 5], k = 33
Output: 2
Explaination: Subarrays: arr[0...2], arr[2...4] have sum exactly equal to 33.

 */
import java.util.*;
class Solution {
    public int countSubarrays(int arr[], int k) {
        HashMap <Integer,Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0 , 1);
        int currSum = 0, count = 0;
        
        for(int nums : arr) {
            currSum += nums;
            int removeDiff = currSum - k;
            
            if(prefixSumMap.containsKey(removeDiff))
                count += prefixSumMap.get(removeDiff);
                
            prefixSumMap.put(currSum , prefixSumMap.getOrDefault(currSum,0) +1);
        }
        return count;
    }
}