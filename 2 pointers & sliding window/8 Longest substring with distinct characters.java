/*
 Given a string s, find the length of the longest substring with all distinct characters. 

Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest substring with all distinct characters.
Input: s = "aaa"
Output: 1
Explanation: "a" is the longest substring with all distinct characters.
 */
import java.util.*;
 class Solution {
    public int longestUniqueSubstr(String s) {
        int n = s.length(), maxLength = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int l = 0;
        for(int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            if(map.containsKey(ch) && map.get(ch) >= l) {
                l = map.get(ch) + 1;
            }
            map.put(ch,r);
            maxLength = Math.max(maxLength , r - l + 1);
        }
        return maxLength;
    }
}