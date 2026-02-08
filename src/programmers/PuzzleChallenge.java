package programmers;

import java.util.Arrays;

class PuzzleChallenge {
    public int solution(int[] diffs, int[] times, long limit) {
        int lt = 0;
        int rt = Arrays.stream(diffs).max().getAsInt();

        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (check(diffs, times, limit, mid))
                rt = mid;
            else
                lt = mid + 1;
        }

        return lt;
    }

    static boolean check(int[] diffs, int[] times, long limit, int mid) {

        long time = 0;
        for (int diffs_idx = 0; diffs_idx < diffs.length; diffs_idx++) {
            if (mid >= diffs[diffs_idx]) {
                time += times[diffs_idx];
            } else {
                long diff = diffs[diffs_idx] - mid;
                long prev;
                if (diffs_idx >= 1)
                    prev = (times[diffs_idx] + times[diffs_idx - 1]) * diff;
                else
                    prev = times[diffs_idx] * diff;
                time += prev + times[diffs_idx];
            }
        }

        return time <= limit;
    }

    public static void main(String[] args) {
        PuzzleChallenge s = new PuzzleChallenge();
//        System.out.println(s.solution(new int[]{1, 5, 3}, new int[]{2, 4, 7}, 30));
        System.out.println(s.solution(new int[]{1, 4, 4, 2}, new int[]{6, 3, 8, 2}, 59));
    }
}