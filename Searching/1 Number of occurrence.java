/*Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 
 * Examples :
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.
 */
//Code:-
class Solution {
    int countFreq(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        if(first == -1) return 0;
        int last = lastOccurrence(arr, target);
        return (last - first + 1);
    }
    int firstOccurrence(int[] arr, int target) {
        int n = arr.length, index = 0;
        int low = 0;
        int high = n-1;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == target) {
                index = mid;
                high = mid - 1;
            }
            else if(arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return index;
    }
    int lastOccurrence(int[] arr, int target) {
        int n = arr.length, index = -1;
        int low = 0;
        int high = n-1;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == target) {
                index = mid;
                low = mid + 1;
            }
            else if(arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return index;
    }
}