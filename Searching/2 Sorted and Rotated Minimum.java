/*A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to find the minimum element in it. 

Examples:

Input: arr[] = [5, 6, 1, 2, 3, 4]
Output: 1
Explanation: 1 is the minimum element in the array. */

class Solution {
    public int findMin(int[] arr) {
       int low = 0, high = arr.length - 1, ans = Integer.MAX_VALUE;
       
       while(low <= high) {
           int mid = (low + high) / 2;
           if(arr[low] <= arr[mid]) {
               ans = Math.min(ans,arr[low]);
               low = mid + 1;
           }
           else {
               ans = Math.min(ans, arr[mid]);
               high = mid - 1;
           }
       }
       return ans;
    }
}