/*
 Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

Examples: 

Input: arr[] = [4, 2, 2, 6, 4], k = 6
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.
Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.

 */
import java.util.*;

 class Solution {
    public long subarrayXor(int arr[], int k) {
        Map<Long, Long> map = new HashMap<>();
        long xor = 0, count = 0;
        map.put(0L,1L);
        
        for(int i : arr) {
            xor = xor ^ i;
            long x = xor ^ k;
            count += map.getOrDefault(x ,0L);
            map.put(xor , map.getOrDefault(xor,0L) + 1);
        }
        return count;
    }
}