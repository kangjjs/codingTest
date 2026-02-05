package programmers;

import java.util.HashMap;

class RoughBoard {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                if (hm.containsKey(key.charAt(i))) {
                    int count = hm.get(key.charAt(i));
                    if (count > i + 1)
                        hm.put(key.charAt(i), i + 1);
                } else {
                    hm.put(key.charAt(i), i + 1);
                }
            }
        }

        int[] answer = new int[targets.length];
        int idx = 0;

        for (String target : targets) {
            int cnt = 0;
            for (int i = 0; i < target.length(); i++) {
                if (hm.containsKey(target.charAt(i))) {
                    cnt += hm.get(target.charAt(i));
                } else {
                    cnt = -1;
                    break;
                }
            }

            answer[idx++] = cnt;
        }

        return answer;
    }
}