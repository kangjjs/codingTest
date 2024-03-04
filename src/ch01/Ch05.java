package ch01;

import java.util.ArrayList;

class Ch05 {
    public int solution(int[] nums) {
        int answer = 0, n = nums.length;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                arrayList.add(i);
            }
        }

        for (int x : arrayList) {
            int max = 3;
            int lt = x - 1;
            int rt = x + 1;

            while (lt > 0) {
                if (nums[lt] > nums[lt - 1]) {
                    max++;
                    lt--;
                } else
                    break;
            }

            while (rt < n - 1) {
                if (nums[rt] > nums[rt + 1]) {
                    max++;
                    rt++;
                } else
                    break;
            }

            answer = Math.max(answer, max);
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch05 T = new Ch05();
        System.out.println(T.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}