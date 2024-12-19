/*Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of a target key. Return -1 if the key is not found.

Examples :

Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
Output: 8
Explanation: 3 is found at index 8. */

class Solution {
    int search(int[] arr, int key) {
        int n = arr.length;
        int index = pivotIndex(arr, n);
        int eleFound = bs_1(arr, index, key);
        if(eleFound == -1) {
            int eleFound2 = bs_2(arr, index, key);
            return eleFound2;
        }
        return eleFound;
    }
    
    public int pivotIndex(int arr[], int n) {
        int index = n - 1;
        for(int i = 1; i < n; i++) {
            if(arr[i] < arr[i-1])  {
                index = i;
                return (index-1);
            }
        }
        return index;
    }
    
    public int bs_1(int arr[], int index, int target) {
        int left =  0;
        int right = index;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            else if(arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    public int bs_2(int arr[], int index, int target) {
        int left =  index + 1;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            else if(arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}