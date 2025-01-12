/*
 Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.

Examples:

Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
Output:  [3, 4, 4, 3]
Explanation: Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3. 
Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.
 */
import java.util.*;
 class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer , Integer> map = new HashMap<>();
        
        int n = arr.length;
        
        for(int i = 0; i < k; i++) {
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }
        
        list.add(map.size());
            
        for(int i = k; i < n; i++) {
            if(map.get(arr[i-k]) == 1)
                map.remove(arr[i-k]);
            else
                map.put(arr[i-k] , map.get(arr[i-k]) - 1);
                
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
            list.add(map.size());
        }
        return list;
    }
}