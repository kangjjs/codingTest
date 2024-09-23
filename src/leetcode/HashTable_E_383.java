package leetcode;

import java.util.HashMap;

public class HashTable_E_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char c : ransomNote.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        for (char c : magazine.toCharArray()) {
            if(hm.isEmpty())
                return true;
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c) - 1);
                if(hm.get(c)==0)
                    hm.remove(c);
            }
        }

        return hm.isEmpty();
    }
}
