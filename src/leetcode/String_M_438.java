package leetcode;

import java.util.*;

public class String_M_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();
        if (sLen < pLen)
            return ans;
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if (Arrays.compare(sCount, pCount) == 0)
            ans.add(0);
        for (int i = 1; i < sLen - pLen + 1; i++) {
            sCount[s.charAt(i - 1) - 'a']--;
            sCount[s.charAt(i + pLen - 1) - 'a']++;
            if (Arrays.compare(sCount, pCount) == 0)
                ans.add(i);
        }
        return ans;
    }
}
