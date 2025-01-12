/*
 Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose sum is closest to target.
Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.

Examples:

Input: arr[] = [10, 30, 20, 5], target = 25
Output: [5, 20]
Explanation: As 5 + 20 = 25 is closest to 25.
Input: arr[] = [5, 2, 7, 1, 4], target = 10
Output: [2, 7]
Explanation: As (4, 7) and (2, 7) both are closest to 10, but absolute difference of (2, 7) is 5 and (4, 7) is 3. Hence, [2, 7] has maximum absolute difference and closest to target. 
 */
import java.util.*;

 class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        int n = arr.length;
        if(n == 1) return new ArrayList<>();
        
        List <Integer> ans = new ArrayList<>();
        int left = 0, right = n - 1;
        int closestSum = Integer.MAX_VALUE;
        int maxAbsDiff = Integer.MIN_VALUE;
        
        Arrays.sort(arr);
        
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(Math.abs(sum - target) < Math.abs(closestSum - target)
            ||(Math.abs(sum - target) == Math.abs(closestSum - target) &&
            (arr[right] - arr[left] > maxAbsDiff))) {
                closestSum = sum;
                maxAbsDiff = arr[right] - arr[left];
                ans = Arrays.asList(arr[left] , arr[right]);
            }
            
            if(sum < target)
                left++;
            else
                right--;
        }
        
        return ans;
    }
}