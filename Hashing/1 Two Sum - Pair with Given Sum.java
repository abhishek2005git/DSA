/*Given an array arr[] of positive integers and another integer target. Determine if there exists two distinct indices such that the sum of there elements is equals to target.

Examples:

Input: arr[] = [1, 4, 45, 6, 10, 8], target = 16
Output: true
Explanation: arr[3] + arr[4] = 6 + 10 = 16.

 */
import java.util.*;

class Solution {
    boolean twoSum(int arr[], int target) {
        //Two pointer:-
        // Arrays.sort(arr);
        // int i = 0, j = arr.length - 1;
        // while(i < j) {
        //     if(arr[i] + arr[j] == target)
        //         return true;
        //     else if(arr[i] + arr[j] < target)
        //         i++;
        //     else
        //         j--;
        // }
        // return false;
        //Hashing:-
        HashMap <Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++) {
            int numToFind = target - arr[i];
            if(map.containsKey(numToFind))
                return true;
            map.put(arr[i], i);
        }
        return false;
    }
}