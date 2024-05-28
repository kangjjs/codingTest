package programmers;

import java.util.*;

class MissileSystem {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(o1,o2)->o1[1]-o2[1]);

        int x = 0;

        for(int[] target:targets){
            if(x<=target[0]){
                x=target[1];
                answer++;
            }
        }
        return answer;
    }
}