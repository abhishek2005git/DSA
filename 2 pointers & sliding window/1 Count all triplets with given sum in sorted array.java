/*
 Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

Examples:

Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
Output: 4
Explanation: Two triplets that add up to -2 are:
arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2

 */

 class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length, res = 0;
        for(int i = 0; i < n-2 ; i++) {
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == target) {
                    int countL = 0, countR = 0;
                    int left = arr[j], right = arr[k];
                    while(j <= k && arr[j] == left) {
                        countL++; j++;
                    }
                    while(j <= k && arr[k] == right) {
                        countR++; k--;
                    }
                    if(left == right) 
                        res += (countL * (countL-1))/2;
                    else
                        res += countL * countR;
                    
                }
                else if(sum < target) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return res;
    }
}