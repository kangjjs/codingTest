package ch02;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

class Ch03 {
    public int solution(String s) {
        int answer = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        for (char x : s.toCharArray()) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }

        for(char key:hm.keySet()){
            while(hs.contains(hm.get(key))){
                answer++;
                hm.put(key,hm.get(key)-1);
            }
            if(hm.get(key)==0)
                continue;
            hs.add(hm.get(key));
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch03 T = new Ch03();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
