package ch04;

import java.util.*;

class Ch01 {

    static class Number implements Comparable<Number> {
        int cnt;
        int x;

        public Number(int cnt, int x) {
            this.cnt = cnt;
            this.x = x;
        }

        @Override
        public int compareTo(Number o) {
            if (this.cnt == o.cnt)
                return this.x - o.x;
            return this.cnt - o.cnt;
        }
    }

    public int[] solution(int[] nums) {
        int[] answer = new int[nums.length];
        ArrayList<Number> arrayList = new ArrayList<>();
        for (int x : nums) {
            String s = Integer.toBinaryString(x);
            char[] c = s.toCharArray();
            int cnt = 0;
            for(char y:c){
                if(y=='1')
                    cnt++;
            }
            arrayList.add(new Number(cnt,x));
        }

        Collections.sort(arrayList);

        for (int i = 0; i < nums.length; i++) {
            answer[i]=arrayList.get(i).x;
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch01 T = new Ch01();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}