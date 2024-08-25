package leetcode;

import java.util.*;

public class String_M_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();

        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortStr = new String(c);
            hm.putIfAbsent(sortStr,new ArrayList<>());
            hm.get(sortStr).add(str);
        }

        return new ArrayList<>(hm.values());
    }
}
