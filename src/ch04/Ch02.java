package ch04;

import java.util.*;

class Ch02 {
    public int[] solution(int[] nums) {
        int[] answer = new int[nums.length / 2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int x : nums) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        Arrays.sort(nums);
        int idx = 0;

        for (int x : nums) {
            if (hm.get(x) == 0)
                continue;
            answer[idx++] = x;
            hm.put(x, hm.get(x) - 1);
            hm.put(x * 2, hm.get(x * 2) - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch02 T = new Ch02();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
