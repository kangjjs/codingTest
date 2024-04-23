package programmers;

import java.util.Arrays;

public class Camera {
    public int solution(int[][] routes) {
        Arrays.sort(routes,(a, b) ->{
            if(a[1]==b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        int answer =1;
        int end = routes[0][1];

        for(int i = 1;  i<routes.length;i++){
            if(routes[i][0] > end){
                answer+=1;
                end = routes[i][1];
            }
        }

        return answer;
    }
}
