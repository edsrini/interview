package com.company.arrays;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import javax.xml.transform.stream.StreamSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutReatingChars {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstring_(String s){
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;

        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                j = map.get(s.charAt(i));
            }
            result = Math.max(result, i - j +1);
            map.put(s.charAt(i), i+1);
        }
        return result;
    }

    public static void main(String[] args) {
       // System.out.println(lengthOfLongestSubstring("pwwkew"));

        System.out.println(lengthOfLongestSubstring_("pwwoek"));
    }
}
