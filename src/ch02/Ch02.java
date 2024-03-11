package ch02;

import java.util.*;

class Ch02 {
    public int[] solution(String s) {
        int[] answer = new int[5];
        int max = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char x : s.toCharArray()) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }

        for (char x : hm.keySet()) {
            answer[(int) x - 97] = hm.get(x);
            max = Math.max(max,hm.get(x));
        }

        for (int i = 0; i < 5; i++) {
            answer[i]=max-answer[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch02 T = new Ch02();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
