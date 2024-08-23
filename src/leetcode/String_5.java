package leetcode;

import java.util.HashMap;
import java.util.Map;

class String_5 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int ans = 0;
        boolean flag = false;

        for (int count : map.values()) {
            if (count % 2 == 0) {
                ans += count;
            } else {
                ans += count - 1;
                flag = true;
            }
        }

        return flag ? ans + 1 : ans;
    }
}
