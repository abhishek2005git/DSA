/*You are given an array with unique elements of stalls[], which denote the position of a stall. You are also given an integer k which denotes the number of aggressive cows. Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

Examples :

Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways. */

import java.util.Arrays;

class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        if(n == k) return 1;
        Arrays.sort(stalls);
        int low = 1, high = stalls[n-1] - stalls[0];
        int ans = 0;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            if(canPlaced(stalls,mid,k) == true) {
                ans = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
                
        }
        return ans;
        
    }
    public static boolean canPlaced(int[] stalls, int distance, int cows) {
        int countCow = 1, last = stalls[0];
        for(int i = 1; i < stalls.length; i++) {
            if(stalls[i] - last >= distance) {
                countCow++;
                last = stalls[i];
            }
            if(countCow >= cows) return true;
        }
        return false;
    }
}