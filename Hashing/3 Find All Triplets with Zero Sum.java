/*
 * Given an array arr[], find all possible triplets i, j, k in the arr[] whose sum of elements is equals to zero. 
Returned triplet should also be internally sorted i.e. i<j<k.

Examples:

Input: arr[] = [0, -1, 2, -3, 1]
Output: [[0, 1, 4], [2, 3, 4]]
Explanation: Triplets with sum 0 are:
arr[0] + arr[1] + arr[4] = 0 + (-1) + 1 = 0
arr[2] + arr[3] + arr[4] = 2 + (-3) + 1 = 0
 */
import java.util.*;

 class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        int n = arr.length;
        Set<List<Integer>> st = new HashSet<>();
        Map<Integer, List<int[]>> mp = new HashMap<>();
        
        // Store pairs and their sums
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                mp.putIfAbsent(sum, new ArrayList<>());
                mp.get(sum).add(new int[]{i, j});
            }
        }
        
        // Check for triplets
        for (int i = 0; i < n; i++) {
            int req = -arr[i];
            if (mp.containsKey(req)) {
                for (int[] pair : mp.get(req)) {
                    if (i != pair[0] && i != pair[1]) {
                        List<Integer> curr = new ArrayList<>(Arrays.asList(i, pair[0], pair[1]));
                        Collections.sort(curr);
                        st.add(curr);
                    }
                }
            }
        }
        
        // Convert set to list
        return new ArrayList<>(st);
    }
}