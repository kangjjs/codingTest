package ch01;

import java.util.ArrayList;

class Ch05 {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        ArrayList<Integer> peak = new ArrayList<>();

        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1])
                peak.add(i);
        }

        for (int t : peak) {
            int count = 1;
            int lt = t;
            int rt = t;

            while (lt > 0) {
                if (nums[lt] > nums[lt - 1]) {
                    lt--;
                    count++;
                } else
                    break;
            }

            while (rt < n - 1) {
                if (nums[rt] > nums[rt + 1]) {
                    rt++;
                    count++;
                } else
                    break;
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch05 T = new Ch05();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
