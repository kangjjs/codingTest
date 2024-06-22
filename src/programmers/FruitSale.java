package programmers;

import java.util.Arrays;
import java.util.Collections;

public class FruitSale {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int[] reserveScore = Arrays.stream(score)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        int cnt = score.length / m;
        int j =0;
        int x = 1;
        for(int i=0;i<reserveScore.length;i++){
            if(j==cnt){
                break;
            }

            if(m==x){
                j++;
                answer+=(m*reserveScore[i]);
                x=1;
                continue;
            }
            x++;
        }

        return answer;
    }
}
