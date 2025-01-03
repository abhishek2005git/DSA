/*
 Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums up to given target.

Examples:

Input: arr[] = [1, 5, 7, -1, 5], target = 6 
Output: 3
Explanation: Pairs with sum 6 are (1, 5), (7, -1) and (1, 5).
 */
import java.util.*;

 class Solution {

    int countPairs(int arr[], int target) {
        HashMap <Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            int numToFind = target - arr[i];
            
            if(map.containsKey(numToFind))
                count += map.get(numToFind);
                
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }
        return count;
    }
}