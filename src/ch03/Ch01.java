package ch03;

import java.util.HashSet;

class Ch01 {
    public int solution(int[] nums){
        int answer = Integer.MIN_VALUE;

        HashSet<Integer> hs = new HashSet<>();

        for(int x:nums){
            hs.add(x);
        }

        for(int x: hs){
            if(hs.contains(x-1))
                continue;
            int cnt=0;
            while(hs.contains(x)){
                cnt++;
                x++;
            }
            answer=Math.max(cnt,answer);
        }

        return answer;
    }

    public static void main(String[] args){
        Ch01 T = new Ch01();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
