package ch05;

import java.util.ArrayList;
import java.util.Collections;

class Ch04 {

    static class Plant implements Comparable<Plant> {
        int pt, et;

        public Plant(int pt, int et) {
            this.pt = pt;
            this.et = et;
        }

        @Override
        public int compareTo(Plant o) {
            if (this.et == o.et)
                return o.pt - this.pt;
            return o.et - this.et;
        }
    }

    public int solution(int[] plantTime, int[] growTime) {
        int answer = 0;
        int n = plantTime.length;
        ArrayList<Plant> plants = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            plants.add(new Plant(plantTime[i],growTime[i]));
        }

        Collections.sort(plants);
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            cnt += plants.get(i).pt;
            answer = Math.max(answer,cnt+plants.get(i).et);
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch04 T = new Ch04();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}
