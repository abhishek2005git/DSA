/*
 * Given two integer arrays a[] and b[], you have to find the intersection of the two arrays. Intersection of two arrays is said to be elements that are common in both arrays. The intersection should not have duplicate elements and the result should contain items in any order.

Note: The driver code will sort the resulting array in increasing order before printing.

Examples:

Input: a[] = [1, 2, 1, 3, 1], b[] = [3, 1, 3, 4, 1]
Output: [1, 3]
Explanation: 1 and 3 are the only common elements and we need to print only one occurrence of common elements.
 */
import java.util.*;

 class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        ArrayList <Integer> list = new ArrayList<>();
        HashMap <Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < a.length; i++) {
            map.put(a[i] , map.getOrDefault(a[i],0) + 1);
        }
        
        for(int i = 0; i < b.length; i++) {
            if(map.containsKey(b[i])) {
                list.add(b[i]);
                map.remove(b[i]);
            }
        }
        return list;
    }
}