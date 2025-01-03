/*
 Given an array of strings, return all groups of strings that are anagrams. The strings in each group must be arranged in the order of their appearance in the original array. Refer to the sample case for clarification.

Examples:

Input: arr[] = ["act", "god", "cat", "dog", "tac"]
Output: [["act", "cat", "tac"], ["god", "dog"]]
Explanation: There are 2 groups of anagrams "god", "dog" make group 1. "act", "cat", "tac" make group 2.

 */
import java.util.*;

class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        Map<String , ArrayList<String>> map = new HashMap<>();
        
        for(String str : arr) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if(!map.containsKey(sortedStr)) {
                map.put(sortedStr , new ArrayList<String>());
            }
            map.get(sortedStr).add(str);
        }
        
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        for(ArrayList<String> group : map.values()) {
            result.add(group);
        }
        
        return result;
    }
}