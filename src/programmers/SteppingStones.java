package programmers;

import java.util.Arrays;

public class SteppingStones {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int answer = 0;
        int[] subDistances = new int[rocks.length + 1];
        subDistances[0] = rocks[0];
        subDistances[rocks.length] = distance - rocks[rocks.length - 1];

        for(int i = 1; i<rocks.length;i++){
            subDistances[i] = rocks[i] - rocks[i-1];
        }

        int max = distance;
        int min = 1;

        while(min <= max){
            int mid = (max+min) / 2;
            int sum = 0;
            int removed = 0;

            for (int subDistance : subDistances) {
                sum += subDistance;
                if (sum < mid) {
                    removed++;
                    continue;
                }
                sum = 0;
            }

            if(removed > n){
                max = mid -1;
                continue;
            }
            min = mid+1;
            answer = Math.max(answer,mid);

        }

        return answer;
    }

    public static void main(String[] args) {
        SteppingStones s = new SteppingStones();
        System.out.println(s.solution(25,new int[]{2,14,11,21,17},2));
    }
}
