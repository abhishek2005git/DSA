/*
 You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
Note: pairs should have elements of distinct indexes. 

Examples :

Input: arr[] = [-1, 1, 5, 5, 7], target = 6
Output: 3
Explanation: There are 3 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1, 7}.
Input: arr[] = [1, 1, 1, 1], target = 2
Output: 6
Explanation: There are 6 pairs which sum up to 2 : {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1} and {1, 1}.
 */
class Solution {
    int countPairs(int arr[], int target) {
        int left = 0, right = arr.length - 1, count = 0;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == target) {
                int countL = 0, countR = 0;
                int eleL = arr[left], eleR = arr[right];
                while(left <= right && arr[left] == eleL) {
                    countL++; left++;
                }
                while(left <= right && arr[right] == eleR) {
                    countR++; right--;
                }
                if(eleL == eleR) {
                    count += (countL * (countL-1)) / 2;
                }
                else {
                    count += countL * countR;
                }
            }
            else if(sum < target)
                left++;
            else
                right--;
        }
        return count;
    }
}